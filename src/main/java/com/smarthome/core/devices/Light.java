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
        this.status = "on";
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
        return deviceType() + " " + id + " is " + status + ".";
    }

    @Override
    public void update(String message) {
        // no-op
    }
} 
