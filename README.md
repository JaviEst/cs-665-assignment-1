
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Javier Esteban de Celis    |
| Date         | 09/05/2025 | 12/01/2025    |
| Course       | CS665                      |
| Assignment # | 1 and 6                    |

# Assignment Overview
This project implements a simple beverage machine using clean and extensible object-oriented design.

**Assignment #6 Update**: This codebase has been refactored to incorporate three design patterns that significantly improve code quality, maintainability, and extensibility. All legacy code has been removed in favor of the new pattern-based implementations.

## Quick Summary of Changes

**Three Design Patterns Implemented:**
1. **Decorator Pattern** - Condiments (milk, sugar) are now decorators that wrap beverages
2. **Builder Pattern** - Orders are created using a fluent builder interface  
3. **Registry Factory Pattern** - Beverage creation uses a map-based registry instead of switch statements

**How to Use the New API:**
```java
BeverageOrder order = new BeverageOrderBuilder()
    .beverageType(BeverageTypes.ESPRESSO)
    .withMilk(2)
    .withSugar(1)
    .build();
```


# GitHub Repository Link:
https://github.com/JaviEst/cs-665-assignment-1


# Assignment #6: Code Improvements and Design Patterns

## Three Areas of Improvement Identified and Implemented

### 1. **Decorator Pattern for Condiments**

#### Problem Identified:
The original implementation stored condiments (milk and sugar) as primitive properties within the `Beverage` class. This approach had several limitations:
- **Lack of Extensibility**: Adding new condiment types (e.g., whipped cream, vanilla syrup) would require modifying the base `Beverage` class, violating the Open/Closed Principle
- **Inflexible Pricing**: All condiments had the same price, making it difficult to have different pricing for different condiments
- **Tight Coupling**: The condiment logic was tightly coupled with the base beverage class

#### Solution Implemented:
Implemented the **Decorator Pattern** to dynamically add condiments to beverages:
- Created an abstract `BeverageDecorator` class that wraps a `Beverage` object
- Implemented concrete decorators: `MilkDecorator` and `SugarDecorator`
- Each decorator adds its functionality (price, description) without modifying the base beverage

#### Benefits:
- **Open/Closed Principle**: New condiments can be added by creating new decorator classes without modifying existing code
- **Single Responsibility**: Each decorator is responsible for one condiment type
- **Flexible Composition**: Condiments can be combined in any order and quantity
- **Independent Pricing**: Each condiment can have its own price

#### Code Changes:
- **New Files**:
  - `decorators/BeverageDecorator.java` - Abstract decorator base class
  - `decorators/MilkDecorator.java` - Adds milk concrete decorator
  - `decorators/SugarDecorator.java` - Adds sugar concrete decorator

#### Example Usage:
```java
Beverage beverage = new Espresso();

beverage = new MilkDecorator(beverage);
beverage = new MilkDecorator(beverage);
beverage = new SugarDecorator(beverage);

beverage.prepare();
```

---

### 2. **Builder Pattern for Order Construction**

#### Problem Identified:
The original `BeverageOrder` constructor required all parameters at once:
```java
new BeverageOrder(BeverageTypes.ESPRESSO, 2, 1);
```

This approach had issues:
- **Poor Readability**: It's unclear what the numbers `2` and `1` represent without reading documentation
- **Parameter Confusion**: Easy to accidentally swap milk and sugar values
- **Limited Flexibility**: Difficult to add optional parameters (e.g., temperature preference, size)
- **Validation Scattered**: Parameter validation occurred in multiple places

#### Solution Implemented:
Implemented the **Builder Pattern** to construct beverage orders:
- Created `BeverageOrderBuilder` class with a fluent interface
- Each method clearly indicates what parameter is being set
- Validation is centralized in the builder
- Supports both decorated (new) and legacy (old) beverage creation

#### Benefits:
- **Improved Readability**: Self-documenting code through method names
- **Flexible Construction**: Optional parameters can be omitted
- **Centralized Validation**: All validation logic in one place
- **Type Safety**: Method names prevent parameter confusion
- **Backward Compatibility**: Legacy constructor still available

#### Code Changes:
- **New Files**:
  - `machine/BeverageOrderBuilder.java` - Builder for creating orders
- **Modified Files**:
  - `machine/BeverageOrder.java` - Added constructor accepting pre-built `Beverage`

#### Example Usage:
```java
BeverageOrder order = new BeverageOrderBuilder()
    .beverageType(BeverageTypes.ESPRESSO)
    .withMilk(2)
    .withSugar(1)
    .build();
```

---

### 3. **Registry-Based Factory Pattern**

#### Problem Identified:
The original `BeverageFactory` used a large switch statement:
```java
switch (type) {
    case ESPRESSO:
        beverage = new Espresso();
        break;
    case AMERICANO:
        beverage = new Americano();
        break;
    // ... more cases
}
```

Issues with this approach:
- **Violates Open/Closed Principle**: Adding new beverages requires modifying the factory class
- **Code Duplication**: Each case follows the same pattern
- **Maintenance Burden**: Switch statement grows with each new beverage type
- **No Runtime Extensibility**: Cannot add beverages dynamically

#### Solution Implemented:
Refactored to a **Registry-Based Factory Pattern** using a `HashMap` and Java 8 method references:
- Created a static registry mapping `BeverageTypes` to `Supplier<Beverage>`
- Used method references (e.g., `Espresso::new`) for clean registration
- Eliminated the switch statement entirely
- Added ability to register beverages at runtime

#### Benefits:
- **Open/Closed Principle**: New beverages registered without modifying factory code
- **Cleaner Code**: No repetitive switch cases
- **Runtime Extensibility**: `registerBeverage()` method allows dynamic registration
- **Better Testability**: Easy to mock or substitute beverage suppliers
- **Reduced Complexity**: Lookup is O(1) instead of sequential case checking

#### Code Changes:
- **Modified Files**:
  - `machine/BeverageFactory.java` - Replaced switch with registry pattern

#### Example - Adding a New Beverage:
```java
BeverageFactory.registerBeverage(BeverageTypes.CAPPUCCINO, Cappuccino::new);
```

---

## UML Class Diagrams

### Decorator Pattern - Class Diagram
```
┌─────────────────────┐
│     Beverage        │ (Abstract)
├─────────────────────┤
│ - name: String      │
│ - milkUnits: int    │
│ - sugarUnits: int   │
├─────────────────────┤
│ + prepare(): void   │
│ + getPrice(): double│
│ + getName(): String │
│ # brew(): void      │
└──────────▲──────────┘
           │
           │ extends
           │
    ┌──────┴──────┬──────────────────────────────┐
    │             │                              │
┌───┴────────┐ ┌──┴────────────────┐   ┌─────────┴────────┐
│  Espresso  │ │ BeverageDecorator │   │   Americano      │
│            │ │    (Abstract)     │   │   (and others)   │
└────────────┘ │─────────────────  │   └──────────────────┘
               │- wrappedBeverage  │
               │     : Beverage    │
               └─────────▲─────────┘
                         │
                         │ extends
                    ┌────┴────┐
                    │         │
          ┌─────────┴───┐  ┌──┴───────────┐
          │MilkDecorator│  │SugarDecorator│
          └─────────────┘  └──────────────┘
```

### Builder Pattern - Class Diagram
```
┌──────────────────────────┐
│  BeverageOrderBuilder    │
├──────────────────────────┤
│ - beverageType           │
│ - milkUnits: int         │
│ - sugarUnits: int        │
├──────────────────────────┤
│ + beverageType(type)     │
│ + withMilk(units)        │
│ + withSugar(units)       │
│ + build(): BeverageOrder │
└────────┬─────────────────┘
         │ creates
         ▼
┌──────────────────────────┐
│    BeverageOrder         │
├──────────────────────────┤
│ - beverage: Beverage     │
├──────────────────────────┤
│ + getCost(): double      │
│ + printOrderSummary()    │
└──────────────────────────┘
```

### Factory Pattern - Class Diagram
```
┌───────────────────────────────────────────────┐
│         BeverageFactory                       │
├───────────────────────────────────────────────┤
│ - beverageRegistry:                           │
│   Map<BeverageTypes, Supplier<Beverage>>      │
├───────────────────────────────────────────────┤
│ + createBaseBeverage(type): Beverage          │
│ + createBeverage(type, milk, sugar): Beverage │
│ + registerBeverage(type, supplier): void      │
└──────────────┬────────────────────────────────┘
               │ creates
               ▼
         ┌─────────────┐
         │  Beverage   │
         └─────────────┘
```

---

## Design Pattern Summary

| Pattern | Purpose | Key Benefit |
|---------|---------|-------------|
| **Decorator** | Add condiments dynamically | Flexibility in composing beverages with condiments |
| **Builder** | Construct complex orders | Improved readability and maintainable parameter passing |
| **Registry Factory** | Create beverages from types | Extensibility without modifying factory code |

---

# Implementation Description (Original)
- Flexibility: Adding a new drink requires only:
  1) creating a new class that extends `beverages.Beverage` and overrides `brew()`,
  2) adding a new value to `types.BeverageTypes`, and
  3) adding a corresponding case in `machine.BeverageFactory`.
  No other code needs to change. Removing a drink is symmetric: delete its class and its factory/enum entries.
- Simplicity & Understandability: Responsibilities are small and clear. `Beverage` encapsulates common behavior and pricing; each concrete beverage contains only its brew specifics; `BeverageFactory` centralizes creation; `BeverageOrder` models a user order and delegates creation. Names are explicit, state is minimal, and the preparation pipeline is linear and easy to read.
- Avoiding Duplication: Shared logic (validation of condiment units, pricing formula, and the preparation template) lives in `Beverage`. Concrete classes override only `brew()`, preventing copy/paste of common steps. The type-to-class mapping is defined once in `BeverageFactory`. Constants (base price, condiment price, limits) are centralized in `Beverage` to avoid scattering literals.

# Use Beverage Machine
To use the beverage machine and get your beverage you will first need to compile the code by running the following command:
```bash
mvn clean compile
```

Once the above is successfully ran, you can order your drink by running the following command:
```bash
java -cp target/classes Main
```


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
