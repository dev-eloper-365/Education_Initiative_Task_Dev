# Education Initiative Task - Software Development Exercises

## Project Overview

This repository contains two comprehensive software development exercises demonstrating advanced Java programming skills, design pattern implementation, and professional software development practices.

## 📁 Project Structure

```
Education_Initiative_Task_Dev/
├── Exercise1_DesignPatterns/          # Design Patterns Implementation
│   ├── behavioral/                    # Observer & Strategy patterns
│   ├── creational/                    # Factory & Builder patterns  
│   ├── structural/                    # Adapter & Decorator patterns
│   ├── uml/                          # UML diagrams and documentation
│   └── README.md                     # Detailed exercise documentation
├── Exercise2_SmartHomeSystem/         # Smart Home System Implementation
│   ├── src/main/java/                # Main application source
│   ├── classdiagramimages/           # UML class diagrams
│   └── README.md                     # Detailed exercise documentation
└── README.md                         # This file
```

## 🎯 Exercise 1: Design Patterns Implementation

### Overview
A comprehensive demonstration of six software design patterns through real-world use cases.

### Design Patterns Implemented
- **Observer Pattern**: Stock Market notification system
- **Strategy Pattern**: Payment processing system
- **Factory Pattern**: Vehicle manufacturing system
- **Builder Pattern**: Computer configuration system
- **Adapter Pattern**: Legacy payment system integration
- **Decorator Pattern**: Coffee ordering system

### Key Features
- ✅ Interactive command-line interface
- ✅ Professional logging with timestamps
- ✅ UML diagrams with PNG visualizations
- ✅ SOLID principles implementation

## 🏠 Exercise 2: Smart Home System

### Overview
A sophisticated smart home automation system demonstrating multiple design patterns integration.

### Design Patterns Implemented
- **Observer Pattern**: Hub notifies devices of changes
- **Factory Method**: Creates different smart device types
- **Proxy Pattern**: Controls device access with authorization
- **Singleton Pattern**: Thread-safe hub implementation

### Key Features
- ✅ Device Management: Add/remove devices dynamically
- ✅ Scheduling System: Time-based automation
- ✅ Trigger Automation: Condition-based actions
- ✅ Thread Safety: Concurrent collections

## 🛠️ Technical Requirements Compliance

### Gold Standards Implementation
- **Logging**: Multi-level logging with timestamps
- **Exception Handling**: Comprehensive error management
- **Performance**: Efficient data structures and algorithms
- **Thread Safety**: Concurrent programming best practices

## 🚀 How to Run

### Exercise 1
```bash
cd Exercise1_DesignPatterns
javac -d out *.java */*.java */*/*.java
java -cp out com.designpatterns.Main
```

### Exercise 2
```bash
cd Exercise2_SmartHomeSystem
mvn clean compile exec:java -Dexec.mainClass="com.smarthome.core.Main"
```

## 🎓 Educational Value

This project demonstrates:
- Design Pattern Mastery
- Professional Development Practices
- System Architecture Skills
- Java Expertise
- Comprehensive Documentation

---

*Developed for Education Initiative coding assessment, showcasing advanced Java programming and design pattern expertise.*