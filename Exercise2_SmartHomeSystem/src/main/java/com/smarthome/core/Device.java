package com.smarthome.core;

/**
 * The Device interface represents a smart home device that can be controlled
 * and observed. Implementations should provide concrete behavior for the
 * supported operations and return meaningful identifiers and types.
 */
public interface Device extends DeviceObserver {
    void turnOn();
    void turnOff();
    String deviceType();
    int getId();
    String statusSummary();
} 