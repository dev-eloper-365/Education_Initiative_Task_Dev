package com.smarthome.core.exceptions;

/**
 * Thrown when a trigger definition is invalid or cannot be parsed.
 */
public class InvalidTriggerException extends Exception {
    public InvalidTriggerException(String message) {
        super(message);
    }
} 