package com.smarthome.core;

import com.smarthome.core.devices.Door;
import com.smarthome.core.devices.Light;
import com.smarthome.core.devices.Thermostat;
import com.smarthome.core.exceptions.InvalidTriggerException;
import com.smarthome.core.exceptions.UnsupportedActionException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SmartHomeHub is the central orchestrator of the smart home system.
 * It is a thread-safe singleton and the Subject for observer notifications.
 */
public class SmartHomeHub implements Subject {
    private static volatile SmartHomeHub instance;
    private static final Logger logger = Logger.getLogger(SmartHomeHub.class.getName());

    private final Map<Integer, Device> idToDevice = new ConcurrentHashMap<>();
    private final List<Trigger> triggers = Collections.synchronizedList(new ArrayList<>());
    private final List<DeviceObserver> observers = Collections.synchronizedList(new ArrayList<>());

    private SmartHomeHub() {
    }

    public static SmartHomeHub getInstance() {
        if (instance == null) {
            synchronized (SmartHomeHub.class) {
                if (instance == null) {
                    instance = new SmartHomeHub();
                }
            }
        }
        return instance;
    }

    public void addDevice(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("device must not be null");
        }
        idToDevice.put(device.getId(), device);
        registerObserver(device);
    }

    public void removeDevice(Device device) {
        if (device == null) return;
        idToDevice.remove(device.getId());
        unregisterObserver(device);
    }

    public void turnOn(int id) throws UnsupportedActionException {
        Device device = idToDevice.get(id);
        if (device == null) {
            logger.log(Level.WARNING, "Device not found with id - " + id);
            throw new UnsupportedActionException("Device not found with id - " + id);
        }
        device.turnOn();
        notifyObservers(capitalize(device.deviceType()) + " " + id + " is on.");
    }

    public void turnOff(int id) throws UnsupportedActionException {
        Device device = idToDevice.get(id);
        if (device == null) {
            logger.log(Level.WARNING, "Device not found with id - " + id);
            throw new UnsupportedActionException("Device not found with id - " + id);
        }
        device.turnOff();
        notifyObservers(capitalize(device.deviceType()) + " " + id + " is off.");
    }

    public void setSchedule(int deviceId, String time, String action) throws UnsupportedActionException {
        Device device = idToDevice.get(deviceId);
        if (device == null) {
            logger.log(Level.WARNING, "Device with ID " + deviceId + " not found.");
            throw new UnsupportedActionException("Device with ID " + deviceId + " not found.");
        }
        logger.info("Scheduled Task - [device: " + device.deviceType() + ", time: " + time + ", command: " + action + "]");
        new Schedule(device, time, action).schedule();
    }

    public void addTrigger(String condition, String action) throws InvalidTriggerException, UnsupportedActionException {
        String[] arr = action.split("[()]\s*");
        if (arr.length >= 2) {
            String actionType = arr[0];
            int id;
            try {
                id = Integer.parseInt(arr[1]);
            } catch (NumberFormatException e) {
                throw new InvalidTriggerException("Invalid device id in action");
            }
            Device device = idToDevice.get(id);
            if (device != null) {
                triggers.add(new Trigger(condition, actionType, id));
            } else {
                throw new UnsupportedActionException("Device with ID " + id + " not found.");
            }
        } else {
            throw new InvalidTriggerException("Invalid Trigger format");
        }
    }

    public void executeSchedules() {
        // No-op: schedules are self-scheduled when created
    }

    public void checkTriggers() throws UnsupportedActionException {
        synchronized (idToDevice) {
            for (Device device : idToDevice.values()) {
                synchronized (triggers) {
                    for (Trigger trigger : triggers) {
                        if (trigger.isTriggered(device)) {
                            String action = trigger.getAction();
                            int id = trigger.getId();
                            logger.info("Trigger - [condition: " + trigger.getCondition() + ", action: " + action + "(" + id + ")] ");
                            executeAction(action, id);
                        }
                    }
                }
            }
        }
    }

    private void executeAction(String action, int id) throws UnsupportedActionException {
        switch (action) {
            case "turnOff" -> turnOff(id);
            case "turnOn" -> turnOn(id);
            default -> throw new UnsupportedActionException("Unsupported Action - " + action);
        }
    }

    public String getStatusReport() throws UnsupportedActionException {
        StringBuilder sb = new StringBuilder();
        for (Device device : idToDevice.values()) {
            sb.append(device.statusSummary());
        }
        return sb.toString();
    }

    @Override
    public void registerObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (DeviceObserver observer : observers) {
            observer.update(message);
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
} 