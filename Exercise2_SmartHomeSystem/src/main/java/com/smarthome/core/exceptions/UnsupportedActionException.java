package com.smarthome.core.exceptions;

/**
 * Thrown when a requested action is not supported for a given device or context.
 */
public class UnsupportedActionException extends Exception {
    public UnsupportedActionException(String message) {
        super(message);
    }
} 