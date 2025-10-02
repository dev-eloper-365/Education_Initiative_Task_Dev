![Education Initiative](../image.png)

# Task 1: Design Patterns Demo

## Introduction

This project serves as a comprehensive demonstration of several software design patterns implemented in Java. It aims to provide a clear and concise understanding of how these design patterns can be applied to real-world scenarios, showcasing their benefits and practical usage.

## Design Patterns Implemented

The project covers the following design patterns:

1. **Behavioral Patterns**:
   - **Observer Pattern**: Implemented in the `com.designpatterns.behavioral.observer` package. The use case is a Stock Market Notification System.
     
    ![Class Diagram](uml/Observer%20Pattern%20-%20Stock%20Market%20Notification%20System.png)
   
   - **Strategy Pattern**: Implemented in the `com.designpatterns.behavioral.strategy` package. The use case is a Payment Processing System.
     
     ![Class Diagram](uml/Strategy%20Pattern%20-%20Payment%20Processing.png)
     

2. **Creational Patterns**:
   - **Factory Pattern**: Implemented in the `com.designpatterns.creational.factory` package. The use case is a Vehicle Manufacturing System.
     
     ![Class Diagram](uml/Factory%20Pattern%20-%20Vehicle%20Manufacturing.png)
     
   - **Builder Pattern**: Implemented in the `com.designpatterns.creational.builder` package. The use case is a Custom Computer Configuration System.
     
     ![Class Diagram](uml/Builder%20Pattern%20-%20Computer%20Configuration.png)
     

3. **Structural Patterns**:
   - **Adapter Pattern**: Implemented in the `com.designpatterns.structural.adapter` package. The use case is a Legacy Payment System Integration.
     
     ![Class Diagram](uml/Adapter%20Pattern%20-%20Legacy%20Payment%20System.png)
     
   - **Decorator Pattern**: Implemented in the `com.designpatterns.structural.decorator` package. The use case is a Coffee Ordering System.
     
     ![Class Diagram](uml/Decorator%20Pattern%20-%20Coffee%20Ordering.png)
     

## Features

- Comprehensive implementation of six design patterns in Java
- Real-world use cases for each design pattern
- Well-structured and modular code organization
- Intuitive command-line interface for demonstrating the patterns
- Professional logging mechanism with multiple levels
- Extensible and customizable design to allow for future additions

## Getting Started

To run the Design Patterns Demo project, follow these steps:

1. Ensure you have Java Development Kit (JDK) version 8 or higher installed on your system.
2. Clone the repository or download the source code.
3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).
4. Build the project and resolve any dependencies.
5. Run the `Main.java` file located in the `com.designpatterns` package.
6. The console will display a menu with options to choose from. Enter the corresponding number to run the demo for each design pattern.

## Getting Started (Command Line)

Prerequisites: Java 8+ (JDK)

1. Navigate to the project directory:
   ```
   cd Exercise1_DesignPatterns
   ```
2. Compile the Java files:
   ```
   javac -d out *.java */*.java */*/*.java
   ```
3. Run the main class:
   ```
   java -cp out com.designpatterns.Main
   ```

## Usage

When running the project, the console will display a menu with the following options:

1. Observer Pattern (Stock Market)
2. Strategy Pattern (Payment Processing)
3. Factory Pattern (Vehicle Manufacturing)
4. Builder Pattern (Computer Configuration)
5. Adapter Pattern (Legacy Payment System)
6. Decorator Pattern (Coffee Ordering)
0. Exit

Select the desired option by entering the corresponding number. The selected design pattern demo will be executed, and you can observe the output in the console. After each demo, press Enter to return to the main menu.

## Architecture

```
Exercise1_DesignPatterns/
├── behavioral/
│   ├── observer/
│   │   ├── StockMarket.java
│   │   ├── StockObserver.java
│   │   ├── StockTrader.java
│   │   └── StockMarketDemo.java
│   └── strategy/
│       ├── PaymentStrategy.java
│       ├── CreditCardPayment.java
│       ├── PayPalPayment.java
│       ├── ShoppingCart.java
│       └── PaymentDemo.java
├── creational/
│   ├── factory/
│   │   ├── Vehicle.java
│   │   ├── Car.java
│   │   ├── Motorcycle.java
│   │   ├── Truck.java
│   │   ├── VehicleFactory.java
│   │   └── VehicleManufacturingDemo.java
│   └── builder/
│       ├── Computer.java
│       └── ComputerConfigurationDemo.java
├── structural/
│   ├── adapter/
│   │   ├── ModernPaymentGateway.java
│   │   ├── LegacyPaymentSystem.java
│   │   ├── LegacyPaymentAdapter.java
│   │   ├── ModernPaymentProcessor.java
│   │   └── PaymentSystemIntegrationDemo.java
│   └── decorator/
│       ├── Coffee.java
│       ├── SimpleCoffee.java
│       ├── CoffeeDecorator.java
│       ├── MilkDecorator.java
│       ├── SugarDecorator.java
│       └── CoffeeOrderingDemo.java
├── util/
│   └── LoggerUtil.java
├── uml/
│   ├── *.puml files
│   ├── *.png files
│   └── README.md
└── Main.java
```

## Gold Standards Implementation

- **Professional Logging**: Multi-level logging with timestamps and proper formatting
- **Exception Handling**: Comprehensive error management with graceful degradation
- **Input Validation**: Robust input validation and user-friendly error messages
- **Code Quality**: SOLID principles, clean architecture, and consistent naming conventions
- **Performance**: Efficient data structures and optimized resource management

## Notes & Future Work

- Add more design patterns (Command, State, Template Method)
- Implement GUI interface using JavaFX or Swing
- Add configuration file support for pattern parameters
- Extend logging capabilities with file output
- Add comprehensive unit test suite
