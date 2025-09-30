package com.smarthome.core;

import com.smarthome.core.devices.Thermostat;

/**
 * Represents a trigger condition and action pair, e.g. "temperature > 70" and "turnOff(1)".
 */
public class Trigger {
    private final String condition;
    private final String action;
    private final int id;

    public Trigger(String condition, String action, int id) {
        this.condition = condition;
        this.action = action;
        this.id = id;
    }

    public boolean isTriggered(Device device) {
        if (condition == null || condition.isBlank()) {
            return false;
        }
        String[] arr = condition.trim().split(" ");
        if (arr.length != 3) {
            return false;
        }
        String property = arr[0];
        String operator = arr[1];
        int value;
        try {
            value = Integer.parseInt(arr[2]);
        } catch (NumberFormatException ex) {
            return false;
        }

        if (device instanceof Thermostat && "temperature".equals(property)) {
            int deviceTemperature = ((Thermostat) device).getTemperature();
            return switch (operator) {
                case ">" -> deviceTemperature > value;
                case "<" -> deviceTemperature < value;
                case ">=" -> deviceTemperature >= value;
                case "<=" -> deviceTemperature <= value;
                case "==" -> deviceTemperature == value;
                default -> false;
            };
        }
        return false;
    }

    public String getAction() {
        return action;
    }

    public String getCondition() {
        return condition;
    }

    public int getId() {
        return id;
    }
} 