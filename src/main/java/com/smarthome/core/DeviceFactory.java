package com.smarthome.core;

import com.smarthome.core.devices.Door;
import com.smarthome.core.devices.Light;
import com.smarthome.core.devices.Thermostat;

/**
 * Factory for creating devices using the DeviceType enum.
 */
public class DeviceFactory {
    public static Device buildDevice(int id, DeviceType type, String statusOrValue) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("Device id must be positive");
        }
        if (type == null) {
            throw new IllegalArgumentException("DeviceType must not be null");
        }
        switch (type) {
            case LIGHT -> {
                String status = (statusOrValue == null || statusOrValue.isBlank()) ? "off" : statusOrValue.toLowerCase();
                if (!status.equals("on") && !status.equals("off")) {
                    throw new IllegalArgumentException("Invalid light status. Use 'on' or 'off'");
                }
                return new Light(id, status);
            }
            case THERMOSTAT -> {
                try {
                    int temp = Integer.parseInt(statusOrValue);
                    return new Thermostat(id, temp);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Thermostat temperature must be an integer", e);
                }
            }
            case DOOR -> {
                String status = (statusOrValue == null || statusOrValue.isBlank()) ? "locked" : statusOrValue.toLowerCase();
                if (!status.equals("locked") && !status.equals("unlocked")) {
                    throw new IllegalArgumentException("Invalid door status. Use 'locked' or 'unlocked'");
                }
                return new Door(id, status);
            }
            default -> throw new IllegalArgumentException("Unsupported device type - " + type);
        }
    }
} 