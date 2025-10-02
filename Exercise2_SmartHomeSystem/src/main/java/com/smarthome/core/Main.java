package com.smarthome.core;

import com.smarthome.core.exceptions.InvalidTriggerException;
import com.smarthome.core.exceptions.UnauthorizedAccessException;
import com.smarthome.core.exceptions.UnsupportedActionException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point for Smart Home Dev application.
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            SmartHomeHub hub = SmartHomeHub.getInstance();

            Device light1 = DeviceFactory.buildDevice(1, DeviceType.LIGHT, "off");
            Device thermostat1 = DeviceFactory.buildDevice(2, DeviceType.THERMOSTAT, "75");
            Device door1 = DeviceFactory.buildDevice(3, DeviceType.DOOR, "locked");
            Device door2 = DeviceFactory.buildDevice(4, DeviceType.DOOR, "locked");

            hub.addDevice(light1);
            hub.addDevice(thermostat1);
            hub.addDevice(door1);
            hub.addDevice(door2);

            hub.turnOn(1);

            hub.setSchedule(1, "19:11", "turnOn");

            hub.addTrigger("temperature > 70", "turnOff(1)");

            hub.removeDevice(door2);

            DeviceProxy proxy = new DeviceProxy(light1, "admin");
            proxy.turnOn();

            hub.executeSchedules();
            hub.checkTriggers();

            System.out.println("Status Report - " + hub.getStatusReport());
        } catch (UnsupportedActionException | InvalidTriggerException | UnauthorizedAccessException e) {
            logger.log(Level.WARNING, e.getMessage());
            System.out.println("Error - Some Error occurred");
        }
    }
} 