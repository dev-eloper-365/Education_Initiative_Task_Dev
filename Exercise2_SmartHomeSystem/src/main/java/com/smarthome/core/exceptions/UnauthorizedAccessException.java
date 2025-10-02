package com.smarthome.core.exceptions;

/**
 * Thrown when a user attempts an operation without proper authorization.
 */
public class UnauthorizedAccessException extends Exception {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
} 