package com.smarthome.core.devices;

import com.smarthome.core.Device;
import com.smarthome.core.DeviceType;

/**
 * Represents a smart door lock device.
 */
public class Door implements Device {
    private final int id;
    private String status;

    public Door(int id, String initialStatus) {
        this.id = id;
        this.status = initialStatus == null ? "locked" : initialStatus.toLowerCase();
    }

    @Override
    public void turnOn() {
        this.status = "unlocked";
    }

    @Override
    public void turnOff() {
        this.status = "locked";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String deviceType() {
        return DeviceType.DOOR.name().toLowerCase();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String statusSummary() {
        String deviceName = DeviceType.DOOR.name().substring(0, 1) + DeviceType.DOOR.name().substring(1).toLowerCase();
        String statusCap = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        return deviceName + " " + id + " is " + statusCap + ".";
    }

    @Override
    public void update(String message) {
        // no-op
    }
} 
