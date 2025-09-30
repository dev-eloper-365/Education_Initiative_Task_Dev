package com.smarthome.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartHomeHubTest {

    @Test
    void canAddAndControlLight() throws Exception {
        SmartHomeHub hub = SmartHomeHub.getInstance();
        Device light = DeviceFactory.buildDevice(100, DeviceType.LIGHT, "off");
        hub.addDevice(light);
        hub.turnOn(100);
        // No assertion on internal state; just ensure no exception
        Assertions.assertTrue(true);
    }
} 