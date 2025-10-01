package com.smarthome.core;

/**
 * Minimal test runner that can be executed with the JDK only (no JUnit).
 * Usage:
 *   javac -d out src/test/java/com/smarthome/core/SmartHomeHubTest.java (after compiling main sources)
 *   java -cp out com.smarthome.core.SmartHomeHubTest
 */
public class SmartHomeHubTest {

    public static void main(String[] args) throws Exception {
        SmartHomeHub hub = SmartHomeHub.getInstance();
        Device light = DeviceFactory.buildDevice(100, DeviceType.LIGHT, "off");
        hub.addDevice(light);
        hub.turnOn(100);
        String report = hub.getStatusReport();
        if (!report.toLowerCase().contains("light 100 is on")) {
            throw new AssertionError("Expected light 100 to be On, got: " + report);
        }
        System.out.println("SmartHomeHubTest: OK");
    }
}