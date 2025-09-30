package com.smarthome.core;

import com.smarthome.core.exceptions.UnsupportedActionException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Represents a one-shot schedule to execute an action on a device at a given HH:mm time.
 */
public class Schedule {
    private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

    private final Device device;
    private final String time; // HH:mm
    private final String action; // turnOn | turnOff | setTemperature? (future)

    public Schedule(Device device, String time, String action) {
        this.device = Objects.requireNonNull(device, "device");
        this.time = Objects.requireNonNull(time, "time");
        this.action = Objects.requireNonNull(action, "action");
    }

    public void schedule() throws UnsupportedActionException {
        long delaySeconds = computeDelaySeconds(time);
        EXECUTOR.schedule(() -> {
            try {
                execute();
            } catch (UnsupportedActionException e) {
                throw new RuntimeException(e);
            }
        }, delaySeconds, TimeUnit.SECONDS);
    }

    public void execute() throws UnsupportedActionException {
        if ("turnOn".equalsIgnoreCase(action)) {
            device.turnOn();
        } else if ("turnOff".equalsIgnoreCase(action)) {
            device.turnOff();
        } else {
            throw new UnsupportedActionException("Unsupported Action - " + action);
        }
    }

    private static long computeDelaySeconds(String hhmm) throws UnsupportedActionException {
        try {
            LocalTime target = LocalTime.parse(hhmm, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime targetDateTime = LocalDateTime.of(LocalDate.now(), target);
            if (!targetDateTime.isAfter(now)) {
                targetDateTime = targetDateTime.plusDays(1); // wrap to next day
            }
            return java.time.Duration.between(now, targetDateTime).toSeconds();
        } catch (DateTimeParseException ex) {
            throw new UnsupportedActionException("Invalid time format. Use HH:mm");
        }
    }
} 