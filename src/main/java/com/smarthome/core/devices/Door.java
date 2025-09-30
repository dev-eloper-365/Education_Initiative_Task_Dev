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
        this.status = "unlocked";
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
        return deviceType() + " " + id + " is " + status + ".";
    }

    @Override
    public void update(String message) {
        // no-op
    }
} 
