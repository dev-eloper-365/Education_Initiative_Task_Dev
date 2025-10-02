# Exercise 1: Design Patterns Implementation

## Overview
This project demonstrates the implementation of six different software design patterns in Java, showcasing real-world use cases and best practices. The implementation follows gold standards for logging, exception handling, and defensive programming.

## Project Structure
```
Exercise1_DesignPatterns/
├── behavioral/
│   ├── observer/          # Stock Market Notification System
│   └── strategy/          # Payment Processing System
├── creational/
│   ├── builder/           # Computer Configuration System
│   └── factory/           # Vehicle Manufacturing System
├── structural/
│   ├── adapter/           # Legacy Payment System Integration
│   └── decorator/         # Coffee Ordering System
├── util/
│   └── LoggerUtil.java    # Gold standard logging utility
└── Main.java              # Interactive menu system
```

## Design Patterns Implemented

### 1. Behavioral Patterns

#### Observer Pattern - Stock Market Notification System
- **Location**: `behavioral/observer/`
- **Use Case**: Real-time stock price notifications to multiple traders
- **Key Classes**:
  - `StockMarket`: Subject that maintains stock prices
  - `StockObserver`: Observer interface for notifications
  - `StockTrader`: Concrete observer receiving price updates
- **Benefits**: Loose coupling between stock market and traders, easy to add/remove observers

#### Strategy Pattern - Payment Processing System
- **Location**: `behavioral/strategy/`
- **Use Case**: Multiple payment methods in an e-commerce system
- **Key Classes**:
  - `PaymentStrategy`: Strategy interface
  - `CreditCardPayment`, `PayPalPayment`: Concrete strategies
  - `ShoppingCart`: Context that uses payment strategies
- **Benefits**: Runtime algorithm selection, easy to add new payment methods

### 2. Creational Patterns

#### Factory Pattern - Vehicle Manufacturing System
- **Location**: `creational/factory/`
- **Use Case**: Manufacturing different types of vehicles
- **Key Classes**:
  - `Vehicle`: Product interface
  - `Car`, `Motorcycle`, `Truck`: Concrete products
  - `VehicleFactory`: Factory for creating vehicles
- **Benefits**: Encapsulates object creation, easy to add new vehicle types

#### Builder Pattern - Computer Configuration System
- **Location**: `creational/builder/`
- **Use Case**: Building custom computer configurations
- **Key Classes**:
  - `Computer`: Complex product with multiple components
  - `ComputerBuilder`: Builder for step-by-step construction
- **Benefits**: Flexible object construction, readable code for complex objects

### 3. Structural Patterns

#### Adapter Pattern - Legacy Payment System Integration
- **Location**: `structural/adapter/`
- **Use Case**: Integrating legacy payment systems with modern interfaces
- **Key Classes**:
  - `ModernPaymentGateway`: Target interface
  - `LegacyPaymentSystem`: Existing system with incompatible interface
  - `LegacyPaymentAdapter`: Adapter bridging the gap
- **Benefits**: Reuse existing code, integrate incompatible interfaces

#### Decorator Pattern - Coffee Ordering System
- **Location**: `structural/decorator/`
- **Use Case**: Adding features to coffee orders dynamically
- **Key Classes**:
  - `Coffee`: Component interface
  - `SimpleCoffee`: Base concrete component
  - `MilkDecorator`, `SugarDecorator`: Concrete decorators
- **Benefits**: Dynamic feature addition, flexible composition

## Gold Standards Implementation

### 1. Logging Mechanism
- **Class**: `LoggerUtil`
- **Features**:
  - Multiple log levels (INFO, WARNING, ERROR, DEBUG)
  - Timestamp formatting
  - Both console and Java logging integration
  - Proper error stream usage for errors

### 2. Exception Handling
- Comprehensive try-catch blocks in main application
- Input validation with `InputMismatchException` handling
- Graceful error recovery and user feedback
- Defensive programming practices

### 3. Performance Optimization
- Efficient data structures usage
- Minimal object creation in loops
- Proper resource management (Scanner closing)
- Thread-safe implementations where applicable

### 4. Code Quality
- **SOLID Principles**: Each pattern demonstrates specific SOLID principles
- **Separation of Concerns**: Clear package structure and class responsibilities
- **Naming Conventions**: Consistent Java naming conventions
- **Documentation**: Comprehensive JavaDoc and comments

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Compilation and Execution
```bash
# Navigate to the project directory
cd Exercise1_DesignPatterns

# Compile all Java files
javac -d out *.java */*.java */*/*.java

# Run the main application
java -cp out com.designpatterns.Main
```

### Interactive Menu
The application provides an interactive menu with the following options:
1. Observer Pattern (Stock Market)
2. Strategy Pattern (Payment Processing)
3. Factory Pattern (Vehicle Manufacturing)
4. Builder Pattern (Computer Configuration)
5. Adapter Pattern (Legacy Payment System)
6. Decorator Pattern (Coffee Ordering)
0. Exit

## Key Features

### 1. User Experience
- Interactive command-line interface
- Clear menu navigation
- Graceful error handling
- Informative output messages

### 2. Code Architecture
- Modular design with clear separation
- Extensible structure for adding new patterns
- Consistent error handling across all patterns
- Professional logging implementation

### 3. Educational Value
- Real-world use cases for each pattern
- Clear demonstration of pattern benefits
- Well-documented code with explanations
- Easy to understand and modify

## Design Decisions

### 1. Package Structure
- Organized by pattern category (behavioral, creational, structural)
- Each pattern in its own package for clear separation
- Utility classes in dedicated util package

### 2. Error Handling Strategy
- Centralized logging utility
- Consistent exception handling patterns
- User-friendly error messages
- Graceful degradation on errors

### 3. Extensibility
- Easy to add new design patterns
- Modular structure supports independent pattern development
- Clear interfaces for extending functionality

## Testing and Quality Assurance

### 1. Manual Testing
- Each pattern thoroughly tested with various inputs
- Edge cases considered and handled
- User interaction scenarios validated

### 2. Code Quality
- Consistent formatting and style
- Comprehensive error handling
- Performance considerations implemented
- Memory management best practices

## Future Enhancements

1. **Additional Patterns**: Command, State, Template Method patterns
2. **Configuration**: External configuration for pattern parameters
3. **Persistence**: Save and load pattern execution results
4. **GUI Interface**: Swing or JavaFX interface for better user experience
5. **Unit Tests**: Comprehensive JUnit test suite

## Conclusion

This implementation demonstrates a thorough understanding of design patterns, their practical applications, and professional Java development practices. The code follows industry standards and provides a solid foundation for understanding and applying design patterns in real-world scenarios.
