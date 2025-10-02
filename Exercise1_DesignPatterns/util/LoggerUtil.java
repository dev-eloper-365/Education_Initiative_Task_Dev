package com.designpatterns.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for logging with different levels and proper formatting.
 * Implements gold standard logging mechanism with timestamp and level information.
 */
public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        info(message);
    }

    public static void info(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [INFO] %s", timestamp, message);
        System.out.println(formattedMessage);
        logger.info(message);
    }

    public static void warning(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [WARNING] %s", timestamp, message);
        System.out.println(formattedMessage);
        logger.warning(message);
    }

    public static void error(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [ERROR] %s", timestamp, message);
        System.err.println(formattedMessage);
        logger.severe(message);
    }

    public static void debug(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String formattedMessage = String.format("[%s] [DEBUG] %s", timestamp, message);
        System.out.println(formattedMessage);
        logger.log(Level.FINE, message);
    }
}