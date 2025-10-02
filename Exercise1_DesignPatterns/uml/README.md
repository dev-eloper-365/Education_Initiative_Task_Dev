# UML Diagrams for Exercise 1: Design Patterns

This directory contains PlantUML diagrams for all design patterns implemented in Exercise 1.

## Available Diagrams

### Individual Pattern Diagrams

1. **Observer Pattern** - `observer-pattern.puml`
   - Stock Market Notification System
   - Shows Subject-Observer relationship
   - Demonstrates loose coupling between StockMarket and StockTraders

2. **Strategy Pattern** - `strategy-pattern.puml`
   - Payment Processing System
   - Shows Context-Strategy relationship
   - Demonstrates runtime algorithm selection

3. **Factory Pattern** - `factory-pattern.puml`
   - Vehicle Manufacturing System
   - Shows Factory-Product relationship
   - Demonstrates object creation encapsulation

4. **Builder Pattern** - `builder-pattern.puml`
   - Computer Configuration System
   - Shows Builder-Product relationship
   - Demonstrates step-by-step object construction

5. **Adapter Pattern** - `adapter-pattern.puml`
   - Legacy Payment System Integration
   - Shows Adapter-Adaptee-Target relationship
   - Demonstrates interface compatibility solution

6. **Decorator Pattern** - `decorator-pattern.puml`
   - Coffee Ordering System
   - Shows Component-Decorator relationship
   - Demonstrates dynamic feature addition

### System Overview

7. **Exercise 1 Overview** - `exercise1-overview.puml`
   - Complete system architecture
   - Shows all patterns and their relationships
   - Demonstrates overall project structure

## How to View Diagrams

### Online PlantUML Viewer
1. Copy the content of any `.puml` file
2. Go to [PlantUML Online Server](http://www.plantuml.com/plantuml/uml/)
3. Paste the content and view the generated diagram

### VS Code Extension
1. Install "PlantUML" extension by jebbs
2. Open any `.puml` file
3. Press `Alt+D` to preview the diagram

### Local PlantUML Installation
```bash
# Install PlantUML (requires Java)
# Download plantuml.jar from http://plantuml.com/download

# Generate PNG from PUML file
java -jar plantuml.jar observer-pattern.puml

# Generate SVG from PUML file
java -jar plantuml.jar -tsvg observer-pattern.puml
```

## Diagram Features

### Design Elements
- **Clean Layout**: Professional appearance with clear relationships
- **Comprehensive Notes**: Explanatory notes for key concepts
- **Pattern Flow**: Step-by-step process explanations
- **Color Coding**: Consistent visual theme across all diagrams

### Technical Details
- **Class Relationships**: Proper UML relationship notation
- **Method Signatures**: Complete method definitions
- **Access Modifiers**: Public (+), Private (-), Protected (#)
- **Stereotypes**: Interface implementations and abstract classes

## Pattern Analysis

### Behavioral Patterns
- **Observer**: One-to-many dependency between objects
- **Strategy**: Family of algorithms with interchangeable implementations

### Creational Patterns
- **Factory**: Centralized object creation with type-based selection
- **Builder**: Complex object construction with optional parameters

### Structural Patterns
- **Adapter**: Interface compatibility between incompatible classes
- **Decorator**: Dynamic behavior addition without inheritance

## Integration with Code

Each UML diagram directly corresponds to the Java implementation in the respective package:

```
Exercise1_DesignPatterns/
├── behavioral/
│   ├── observer/     → observer-pattern.puml
│   └── strategy/     → strategy-pattern.puml
├── creational/
│   ├── factory/      → factory-pattern.puml
│   └── builder/      → builder-pattern.puml
├── structural/
│   ├── adapter/      → adapter-pattern.puml
│   └── decorator/    → decorator-pattern.puml
└── uml/             → All UML diagrams
```

## Educational Value

These diagrams serve as:
- **Visual Learning Aid**: Clear representation of pattern structures
- **Documentation**: Comprehensive system documentation
- **Design Reference**: Quick reference for pattern implementation
- **Code Review Tool**: Visual validation of implementation correctness

## Future Enhancements

Potential additions to the UML documentation:
- **Sequence Diagrams**: Show interaction flows over time
- **Activity Diagrams**: Show process flows and decision points
- **State Diagrams**: Show object state transitions
- **Component Diagrams**: Show system component relationships
