package com.smarthome.core;

/**
 * Subject interface defines the contract for managing observers and broadcasting updates.
 */
public interface Subject {
    void registerObserver(DeviceObserver observer);
    void unregisterObserver(DeviceObserver observer);
    void notifyObservers(String message);
} 