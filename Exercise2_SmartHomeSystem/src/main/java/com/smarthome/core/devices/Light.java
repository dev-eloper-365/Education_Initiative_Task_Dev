package com.smarthome.core.devices;

import com.smarthome.core.Device;
import com.smarthome.core.DeviceType;

/**
 * Represents a smart light device.
 */
public class Light implements Device {
    private final int id;
    private String status;

    public Light(int id, String initialStatus) {
        this.id = id;
        this.status = initialStatus == null ? "off" : initialStatus.toLowerCase();
    }

    @Override
    public void turnOn() {
        this.status = "on";
    }

    @Override
    public void turnOff() {
        this.status = "off";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String deviceType() {
        return DeviceType.LIGHT.name().toLowerCase();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String statusSummary() {
        String deviceName = DeviceType.LIGHT.name().substring(0, 1) + DeviceType.LIGHT.name().substring(1).toLowerCase();
        String statusCap = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        return deviceName + " " + id + " is " + statusCap + ".";
    }

    @Override
    public void update(String message) {
        // no-op
    }
} 
