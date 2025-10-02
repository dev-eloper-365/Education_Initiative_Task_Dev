# Exercise 2: Smart Home System

## Overview
A comprehensive Smart Home System simulation that demonstrates the integration of multiple design patterns in a real-world scenario. The system allows users to control smart devices, set schedules, create automation triggers, and manage device access through a central hub.

## Project Architecture

### Design Patterns Implementation

#### 1. Behavioral Pattern - Observer Pattern
- **Implementation**: `Subject` interface and `DeviceObserver` interface
- **Usage**: SmartHomeHub notifies all devices when system changes occur
- **Benefits**: Loose coupling between hub and devices, easy to add new observers

#### 2. Creational Pattern - Factory Method
- **Implementation**: `DeviceFactory` class
- **Usage**: Creates different types of smart devices (Light, Thermostat, Door)
- **Benefits**: Centralized device creation, easy to add new device types

#### 3. Structural Pattern - Proxy Pattern
- **Implementation**: `DeviceProxy` class
- **Usage**: Controls access to devices based on user authorization
- **Benefits**: Security layer, access control without modifying device classes

#### 4. Singleton Pattern
- **Implementation**: `SmartHomeHub` class
- **Usage**: Ensures single instance of the central hub
- **Benefits**: Centralized control, consistent state management

## Project Structure
```
Exercise2_SmartHomeSystem/
├── src/
│   ├── main/java/com/smarthome/core/
│   │   ├── devices/
│   │   │   ├── Light.java           # Smart light implementation
│   │   │   ├── Thermostat.java      # Smart thermostat implementation
│   │   │   └── Door.java            # Smart door lock implementation
│   │   ├── exceptions/
│   │   │   ├── InvalidTriggerException.java
│   │   │   ├── UnauthorizedAccessException.java
│   │   │   └── UnsupportedActionException.java
│   │   ├── Device.java              # Device interface
│   │   ├── DeviceFactory.java       # Factory for device creation
│   │   ├── DeviceObserver.java      # Observer interface
│   │   ├── DeviceProxy.java         # Proxy for device access control
│   │   ├── DeviceType.java          # Device type enumeration
│   │   ├── Main.java                # Application entry point
│   │   ├── Schedule.java            # Scheduling functionality
│   │   ├── SmartHomeHub.java        # Central hub (Singleton + Subject)
│   │   ├── Subject.java             # Observer pattern subject interface
│   │   └── Trigger.java             # Automation trigger implementation
│   └── test/java/com/smarthome/core/
│       └── SmartHomeHubTest.java    # Basic functionality tests
├── classdiagramimages/              # UML diagrams
├── target/                          # Compiled classes and JAR
└── README.md                        # This file
```

## Key Features

### 1. Device Management
- **Initialize System**: Add different smart devices with unique IDs
- **Device Types**: Light, Thermostat, Door Lock
- **Dynamic Management**: Add/remove devices at runtime
- **Status Reporting**: Get comprehensive status of all devices

### 2. Device Control
- **Turn On/Off**: Control device states
- **Type-Specific Actions**: Temperature control for thermostats, lock/unlock for doors
- **Proxy Access**: Secure device access through authorization

### 3. Scheduling System
- **Time-Based Scheduling**: Schedule device actions for specific times
- **Flexible Commands**: Support for various device commands
- **Automatic Execution**: Self-scheduling timer-based execution

### 4. Automation Triggers
- **Condition-Based**: Create triggers based on device conditions
- **Automatic Actions**: Execute actions when conditions are met
- **Complex Logic**: Support for temperature thresholds and other conditions

## Gold Standards Implementation

### 1. Logging Mechanism
- **Java Logging**: Comprehensive logging using `java.util.logging`
- **Log Levels**: INFO, WARNING, ERROR levels appropriately used
- **Contextual Logging**: Detailed logging for debugging and monitoring

### 2. Exception Handling
- **Custom Exceptions**: Domain-specific exception types
- **Graceful Degradation**: System continues operation despite errors
- **Comprehensive Coverage**: All potential failure points handled

### 3. Thread Safety
- **Concurrent Collections**: `ConcurrentHashMap` for device storage
- **Synchronized Lists**: Thread-safe collections for observers and triggers
- **Singleton Thread Safety**: Double-checked locking pattern

### 4. Defensive Programming
- **Input Validation**: Comprehensive validation of all inputs
- **Null Checks**: Proper null checking throughout the codebase
- **Boundary Conditions**: Edge cases properly handled

### 5. Performance Optimization
- **Efficient Data Structures**: Optimal collection choices
- **Minimal Object Creation**: Reuse of objects where possible
- **Lazy Initialization**: Resources created only when needed

## Device Types and Capabilities

### Light Device
- **States**: On/Off
- **Operations**: Turn on, turn off, status reporting
- **Integration**: Observer pattern for state change notifications

### Thermostat Device
- **Properties**: Temperature setting
- **Operations**: Temperature adjustment, status reporting
- **Triggers**: Temperature-based automation triggers

### Door Device
- **States**: Locked/Unlocked
- **Operations**: Lock, unlock, status reporting
- **Security**: Proxy pattern for access control

## Usage Examples

### Basic Device Control
```java
SmartHomeHub hub = SmartHomeHub.getInstance();

// Create devices using Factory pattern
Device light = DeviceFactory.buildDevice(1, DeviceType.LIGHT, "off");
Device thermostat = DeviceFactory.buildDevice(2, DeviceType.THERMOSTAT, "70");
Device door = DeviceFactory.buildDevice(3, DeviceType.DOOR, "locked");

// Add devices to hub
hub.addDevice(light);
hub.addDevice(thermostat);
hub.addDevice(door);

// Control devices
hub.turnOn(1);  // Turn on light
```

### Scheduling
```java
// Schedule device to turn on at specific time
hub.setSchedule(1, "19:00", "turnOn");
```

### Automation Triggers
```java
// Create trigger: turn off light when temperature > 75
hub.addTrigger("temperature > 75", "turnOff(1)");
```

### Proxy Access Control
```java
// Secure device access
DeviceProxy proxy = new DeviceProxy(light, "admin");
proxy.turnOn();  // Only authorized users can control
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Maven (optional, for dependency management)

### Compilation and Execution

#### Using Maven
```bash
cd Exercise2_SmartHomeSystem
mvn clean compile
mvn exec:java -Dexec.mainClass="com.smarthome.core.Main"
```

#### Using Command Line
```bash
cd Exercise2_SmartHomeSystem/src/main/java
javac -d ../../../target/classes com/smarthome/core/*.java com/smarthome/core/devices/*.java com/smarthome/core/exceptions/*.java
java -cp ../../../target/classes com.smarthome.core.Main
```

### Running Tests
```bash
# Compile test classes
javac -d target/test-classes -cp target/classes src/test/java/com/smarthome/core/SmartHomeHubTest.java

# Run tests
java -cp target/classes:target/test-classes com.smarthome.core.SmartHomeHubTest
```

## Sample Input/Output

### Input Devices
```json
[
  {"id": 1, "type": "light", "status": "off"},
  {"id": 2, "type": "thermostat", "temperature": 70},
  {"id": 3, "type": "door", "status": "locked"}
]
```

### Commands
```
turnOn(1)
setSchedule(2, "06:00", "Turn On")
addTrigger("temperature > 75", "turnOff(1)")
```

### Output
```
Status Report: Light 1 is On. Thermostat 2 is set to 70 degrees. Door 3 is Locked.
Scheduled Tasks: [device: thermostat, time: 06:00, command: turnOn]
Automated Triggers: [condition: temperature > 75, action: turnOff(1)]
```

## Design Decisions

### 1. Architecture Choices
- **Singleton Hub**: Ensures centralized control and state consistency
- **Factory Pattern**: Provides flexibility for adding new device types
- **Observer Pattern**: Enables loose coupling between hub and devices
- **Proxy Pattern**: Adds security layer without modifying core device logic

### 2. Error Handling Strategy
- **Custom Exceptions**: Domain-specific error types for better error handling
- **Graceful Degradation**: System continues operation despite individual failures
- **Comprehensive Logging**: Detailed logging for debugging and monitoring

### 3. Thread Safety
- **Concurrent Collections**: Thread-safe data structures for multi-threaded access
- **Synchronized Methods**: Critical sections properly synchronized
- **Immutable Objects**: Where possible, objects are designed to be immutable

### 4. Extensibility
- **Plugin Architecture**: Easy to add new device types
- **Configurable Triggers**: Flexible trigger system for automation
- **Modular Design**: Clear separation of concerns for maintainability

## Testing Strategy

### 1. Unit Testing
- **Basic Functionality**: Core operations tested
- **Edge Cases**: Boundary conditions and error scenarios
- **Integration Testing**: Component interaction validation

### 2. Manual Testing
- **User Scenarios**: Real-world usage patterns tested
- **Error Conditions**: Exception handling validation
- **Performance Testing**: System behavior under load

## Future Enhancements

### 1. Additional Features
- **Web Interface**: REST API for remote control
- **Mobile App**: Smartphone integration
- **Voice Control**: Integration with voice assistants
- **Energy Monitoring**: Power consumption tracking

### 2. Advanced Automation
- **Machine Learning**: Predictive automation based on usage patterns
- **Geofencing**: Location-based automation
- **Weather Integration**: Weather-based device control
- **Scene Management**: Predefined device configurations

### 3. Security Enhancements
- **Encryption**: Secure communication protocols
- **Multi-Factor Authentication**: Enhanced user verification
- **Audit Logging**: Comprehensive security event logging
- **Role-Based Access**: Granular permission system

## Class Diagrams

The project includes UML class diagrams in the `classdiagramimages/` directory:
- **Factory Pattern**: Device creation architecture
- **Observer Pattern**: Notification system design
- **Proxy Pattern**: Access control implementation
- **Singleton Pattern**: Hub management structure
- **System Overview**: Complete system architecture

## Conclusion

This Smart Home System demonstrates the practical application of multiple design patterns in a cohesive, real-world scenario. The implementation follows industry best practices for logging, exception handling, thread safety, and performance optimization. The system is designed to be extensible, maintainable, and scalable, providing a solid foundation for a production-ready smart home solution.

The project showcases:
- **Design Pattern Mastery**: Proper implementation of Observer, Factory, Proxy, and Singleton patterns
- **Professional Code Quality**: Gold standard practices for logging, error handling, and performance
- **Real-World Applicability**: Practical smart home automation scenarios
- **Extensible Architecture**: Easy to add new features and device types
- **Comprehensive Documentation**: Thorough documentation for maintainability
