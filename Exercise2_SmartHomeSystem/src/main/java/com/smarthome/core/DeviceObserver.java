package com.smarthome.core;

/**
 * Observer interface for receiving updates from a Subject in the smart home system.
 */
public interface DeviceObserver {
    void update(String message);
} 