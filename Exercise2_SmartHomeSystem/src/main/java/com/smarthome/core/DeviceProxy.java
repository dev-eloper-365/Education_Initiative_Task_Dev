package com.smarthome.core;

import com.smarthome.core.exceptions.UnauthorizedAccessException;

/**
 * Proxy that guards access to a Device based on basic authorization.
 */
public class DeviceProxy {
    private final Device realDevice;
    private final String username;

    public DeviceProxy(Device realDevice, String username) {
        this.realDevice = realDevice;
        this.username = username;
    }

    public void turnOn() throws UnauthorizedAccessException {
        if (authorizeUser()) {
            realDevice.turnOn();
        } else {
            throw new UnauthorizedAccessException("User not authenticated");
        }
    }

    public void turnOff() throws UnauthorizedAccessException {
        if (authorizeUser()) {
            realDevice.turnOff();
        } else {
            throw new UnauthorizedAccessException("User not authenticated");
        }
    }

    public boolean authorizeUser() {
        return "admin".equals(username);
    }
} 