package com.smarthome.core.devices;

import com.smarthome.core.Device;
import com.smarthome.core.DeviceType;

/**
 * Represents a thermostat device.
 */
public class Thermostat implements Device {
    private final int id;
    private int temperature;

    public Thermostat(int id, int initialTemperature) {
        this.id = id;
        this.temperature = initialTemperature;
    }

    @Override
    public void turnOn() {
        // no special on/off state; could be extended
    }

    @Override
    public void turnOff() {
        // no special on/off state; could be extended
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String deviceType() {
        return DeviceType.THERMOSTAT.name().toLowerCase();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String statusSummary() {
        String deviceName = DeviceType.THERMOSTAT.name().substring(0, 1) + DeviceType.THERMOSTAT.name().substring(1).toLowerCase();
        return deviceName + " is set to " + temperature + " degrees.";
    }

    @Override
    public void update(String message) {
        // no-op
    }
} 