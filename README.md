# 🎓 Java Introduction to Software Development

[![Java](https://img.shields.io/badge/Java-SE_17+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Educational-blue.svg)]()
[![Status](https://img.shields.io/badge/Status-Complete-success.svg)]()

> A comprehensive foundational course covering core Java programming concepts, from basic syntax to object-oriented design principles, culminating in a fully functional digital banking system.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Course Structure](#course-structure)
- [Learning Objectives](#learning-objectives)
- [Prerequisites](#prerequisites)
- [Setup & Installation](#setup--installation)
- [Module Breakdown](#module-breakdown)
- [Final Project](#final-project)
- [Running the Applications](#running-the-applications)
- [Key Concepts Covered](#key-concepts-covered)
- [Project Structure](#project-structure)
- [Best Practices Demonstrated](#best-practices-demonstrated)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Overview

This repository contains a complete curriculum for learning Java from the ground up. The course follows a progressive learning path, building from fundamental programming concepts to advanced object-oriented design patterns. Each module contains hands-on exercises that simulate real-world banking scenarios, providing practical context for theoretical concepts.

**Course Duration**: Self-paced  
**Skill Level**: Beginner to Intermediate  
**Language**: Java SE 17+  
**IDE**: IntelliJ IDEA (recommended)

---

## 📚 Course Structure

The course is divided into four progressive modules, each building upon the previous:

```
01-java-introduction-to-software-development/
├── module-1-getting-started/          # Java fundamentals & syntax
├── module-2-control-flow/             # Decision-making & iteration
├── module-3-oop-basics/               # Object-oriented programming
└── module-4-final-project/            # Capstone banking system
```

---

## 🎓 Learning Objectives

By completing this course, you will:

- ✅ Understand the **Software Development Life Cycle (SDLC)** and developer roles
- ✅ Master Java **syntax, data types, operators, and control structures**
- ✅ Write clean, maintainable code using **object-oriented principles**
- ✅ Implement **inheritance, polymorphism, encapsulation, and abstraction**
- ✅ Design and build a **multi-class application** with proper architecture
- ✅ Apply **best practices** for code organization and documentation
- ✅ Develop **problem-solving skills** through real-world scenarios

---

## 🔧 Prerequisites

### Required
- **Java Development Kit (JDK)**: Version 17 or higher
- **IDE**: IntelliJ IDEA Community Edition (or Eclipse/VS Code)
- **Basic Computer Skills**: File navigation, text editing

### Recommended
- Understanding of basic computer science concepts
- Familiarity with command-line interfaces
- Logical thinking and problem-solving mindset

---

## 🚀 Setup & Installation

### 1. Install Java JDK

**Windows/macOS/Linux:**
```bash
# Verify Java installation
java -version

# Should output: java version "17.x.x" or higher
```

Download from: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)

### 2. Clone the Repository

```bash
git clone <repository-url>
cd 01-java-introduction-to-software-development
```

### 3. Open in IDE

**IntelliJ IDEA:**
1. `File → Open`
2. Navigate to `01-java-introduction-to-software-development`
3. Select the folder and click `Open`
4. Trust the project when prompted

### 4. Verify Setup

```bash
# Compile a sample module
cd module-1-getting-started/src
javac gettingstarted/Main.java
java gettingstarted.Main
```

---

## 📖 Module Breakdown

### **Module 1: Getting Started with Java** 🌱

**Focus**: Java fundamentals, syntax, and basic operations

**Topics Covered:**
- Software development roles and SDLC phases
- Variables, data types, and type casting
- Arithmetic, relational, and logical operators
- String manipulation and concatenation
- Arrays and collections basics
- Input/Output operations

**Key Exercises:**
- `Exercise1AccountBalance.java` - Variable declarations and calculations
- `Exercise2CurrencyConversion.java` - Type conversion and arithmetic
- `Exercise3CustomerStringOperations.java` - String methods and formatting

**Skills Acquired:**
- Writing syntactically correct Java programs
- Working with primitive and reference types
- Performing mathematical and logical operations
- Manipulating text data effectively

📄 [Module 1 Summary](./module-1-getting-started/MODULESUMMARY.md)

---

### **Module 2: Control Flow Statements** 🔀

**Focus**: Decision-making, loops, and program flow control

**Topics Covered:**
- Conditional statements (`if`, `else if`, `else`)
- Switch statements for multi-way branching
- For loops (definite iteration)
- While and do-while loops (indefinite iteration)
- Nested control structures
- Scanner class for user interaction
- Break and continue statements

**Key Exercises:**
- `Exercise1AccountStatusValidation.java` - Conditional logic
- `Exercise2LoanEligibilityCheck.java` - Complex decision trees
- `Exercise3TransactionTypeProcessing.java` - Switch statements
- `Exercise4DailyTransactionProcessing.java` - For loops
- `Exercise5AccountBalanceMonitoring.java` - While loops
- `Exercise6AtmWithdrawalSimulation.java` - Do-while loops
- `Exercise7ChoosingRightLoop.java` - Loop selection criteria
- `Exercise8AtmUserInteraction.java` - Interactive menus

**Skills Acquired:**
- Building responsive, decision-driven applications
- Implementing repetitive tasks efficiently
- Creating interactive command-line interfaces
- Validating user input programmatically

📄 [Module 2 Summary](./module-2-control-flow/MODULESUMMARY.md)

---

### **Module 3: Object-Oriented Programming Basics** 🏗️

**Focus**: OOP principles, class design, and code reusability

**Topics Covered:**
- Classes and objects (blueprints vs instances)
- Constructors and method overloading
- Inheritance and method overriding
- Polymorphism (compile-time and runtime)
- Encapsulation (access modifiers, getters/setters)
- Abstraction (abstract classes and methods)
- Interfaces and multiple inheritance
- The `super` and `this` keywords

**Key Exercises:**
- `Exercise01/BankAccount.java` - Class creation and encapsulation
- `Exercise02/SavingsAccount.java` - Inheritance basics
- `Exercise03/CheckingAccount.java` - Polymorphism
- `Exercise05/AbstractionDemo.java` - Abstract classes
- `Exercise06/InterfaceDemo.java` - Interface implementation
- `Exercise07/TransferService.java` - Service layer pattern
- `Exercise08/OnlineCheckingAccount.java` - Multiple inheritance
- `Exercise09/BankingSystemDemo.java` - Full OOP integration

**Skills Acquired:**
- Designing scalable, maintainable class hierarchies
- Applying SOLID principles in practice
- Writing reusable, modular code
- Understanding object relationships and dependencies

📄 [Module 3 Summary](./module-3-oop-basics/MODULESUMMARY.md)

---

### **Module 4: Final Project - Digital Banking System** 🏦

**Focus**: Comprehensive application demonstrating all learned concepts

**Project Overview:**

A fully functional command-line banking application that simulates real-world banking operations with multiple account types, customer management, and transaction processing.

**Core Features:**
- ✅ Customer registration and management
- ✅ Multiple account types (Savings, Checking)
- ✅ Deposit and withdrawal operations
- ✅ Inter-account transfers with daily limits
- ✅ Transaction history tracking
- ✅ Overdraft protection (Checking accounts)
- ✅ Interest calculation (Savings accounts)
- ✅ Input validation and error handling
- ✅ Professional logging system

**Architecture:**

```
finalproject/
├── Account.java              # Abstract base class
├── SavingsAccount.java       # Concrete account with interest
├── CheckingAccount.java      # Concrete account with overdraft
├── Customer.java             # Customer entity
├── Transferable.java         # Transfer capability interface
├── BankingSystem.java        # Main application controller
└── Main.java                 # Entry point
```

**Design Patterns:**
- **Template Method**: Abstract `Account` class
- **Strategy Pattern**: `Transferable` interface
- **Service Layer**: `BankingSystem` manages business logic
- **Entity Pattern**: `Customer` as data model

**Technical Highlights:**
- Uses `java.util.logging` for professional output
- Implements daily transfer limits with state tracking
- Applies withdrawal fees after free limit exceeded
- Calculates monthly interest for savings accounts
- Maintains complete transaction audit trail

📄 [Final Project Requirements](./module-4-final-project/FINAL_PROJECT.md)  
📄 [Course Summary](./module-4-final-project/src/finalproject/CourseSUMMARY.md)

---

## 💻 Running the Applications

### Module Exercises

```bash
# Navigate to module source
cd module-<number>-<name>/src

# Compile Java files
javac <package>/*.java

# Run specific exercise
java <package>.<ClassName>

# Example: Run Module 1 Exercise 1
cd module-1-getting-started/src
javac gettingstarted/*.java
java gettingstarted.Exercise1AccountBalance
```

### Final Project

```bash
# Navigate to final project
cd module-4-final-project/src

# Compile all classes
javac finalproject/*.java

# Run the banking system
java finalproject.Main
```

**Expected Output:**
```
🏦 Welcome to Digital Banking System!
=====================================

═══════════════════════════════════
        BANKING SYSTEM MENU        
═══════════════════════════════════
1. Create Customer
2. Create Account
3. Deposit
4. Withdraw
5. Transfer
6. View Account Details
7. View All Accounts
0. Exit
═══════════════════════════════════
Enter your choice:
```

### Using IntelliJ IDEA

1. Navigate to the desired class in Project Explorer
2. Right-click on the file with `main()` method
3. Select **Run '<ClassName>.main()'**
4. View output in the integrated console

---

## 🔑 Key Concepts Covered

### Programming Fundamentals
- [x] Variables and data types (primitive & reference)
- [x] Type casting and conversion
- [x] Operators (arithmetic, relational, logical, assignment)
- [x] String manipulation and formatting
- [x] Arrays and array operations

### Control Structures
- [x] If-else conditional statements
- [x] Switch-case statements
- [x] For loops (indexed iteration)
- [x] While loops (conditional iteration)
- [x] Do-while loops (post-test iteration)
- [x] Nested loops and conditions

### Object-Oriented Programming
- [x] Classes and objects
- [x] Constructors (default and parameterized)
- [x] Methods (instance and static)
- [x] Encapsulation (private fields, public methods)
- [x] Inheritance (extends keyword)
- [x] Polymorphism (overloading and overriding)
- [x] Abstraction (abstract classes)
- [x] Interfaces (implements keyword)
- [x] Access modifiers (private, protected, public)

### Software Design Principles
- [x] Single Responsibility Principle
- [x] Separation of concerns
- [x] Code reusability through inheritance
- [x] Interface segregation
- [x] Dependency management

---

## 📁 Project Structure

```
01-java-introduction-to-software-development/
│
├── 01-java-introduction-to-software-development.iml
├── README.md                                    # This file
│
├── module-1-getting-started/
│   ├── module-1-getting-started.iml
│   ├── MODULESUMMARY.md
│   ├── README.md
│   └── src/
│       └── gettingstarted/
│           ├── Exercise1AccountBalance.java
│           ├── Exercise2CurrencyConversion.java
│           ├── Exercise3CustomerStringOperations.java
│           └── Main.java
│
├── module-2-control-flow/
│   ├── module-2-control-flow.iml
│   ├── MODULESUMMARY.md
│   ├── README.md
│   └── src/
│       └── controlflow/
│           ├── Exercise1AccountStatusValidation.java
│           ├── Exercise2LoanEligibilityCheck.java
│           ├── Exercise3TransactionTypeProcessing.java
│           ├── Exercise4DailyTransactionProcessing.java
│           ├── Exercise5AccountBalanceMonitoring.java
│           ├── Exercise6AtmWithdrawalSimulation.java
│           ├── Exercise7ChoosingRightLoop.java
│           └── Exercise8AtmUserInteraction.java
│
├── module-3-oop-basics/
│   ├── module-3-oop-basics.iml
│   ├── MODULESUMMARY.md
│   ├── README.md
│   └── src/
│       └── oopbasics/
│           ├── exercise01/BankAccount.java
│           ├── exercise02/SavingsAccount.java
│           ├── exercise03/CheckingAccount.java
│           ├── exercise03/Main.java
│           ├── exercise05/AbstractionDemo.java
│           ├── exercise06/CreditEligible.java
│           ├── exercise06/InterfaceDemo.java
│           ├── exercise06/Notifiable.java
│           ├── exercise06/VIPAccount.java
│           ├── exercise07/TransferDemo.java
│           ├── exercise07/TransferService.java
│           ├── exercise08/EXERCISE8_SUMMARY.md
│           ├── exercise08/OnlineCheckingAccount.java
│           ├── exercise08/OnlineService.java
│           ├── exercise08/TransactionHistoryDemo.java
│           └── exercise09/BankingSystemDemo.java
│               └── EnhancedTransferService.java
│               └── PremiumAccount.java
│
├── module-4-final-project/
│   ├── module-4-final-project.iml
│   ├── FINAL_PROJECT.md
│   └── src/
│       └── finalproject/
│           ├── Account.java
│           ├── SavingsAccount.java
│           ├── CheckingAccount.java
│           ├── Customer.java
│           ├── Transferable.java
│           ├── BankingSystem.java
│           ├── Main.java
│           └── CourseSUMMARY.md
│
└── out/                                         # Compiled .class files
    └── production/
```

---

## ⭐ Best Practices Demonstrated

### Code Quality
- **Meaningful Naming**: Descriptive variable, method, and class names
- **Consistent Formatting**: Proper indentation and spacing
- **Modular Design**: Single-purpose methods and classes
- **DRY Principle**: No code duplication

### Object-Oriented Design
- **Encapsulation**: Private fields with controlled access
- **Abstraction**: Hide implementation details
- **Inheritance**: Logical parent-child relationships
- **Polymorphism**: Flexible, extensible code

### Error Handling
- **Input Validation**: Check user input before processing
- **Boundary Checks**: Prevent array index errors
- **Graceful Failures**: Informative error messages
- **State Validation**: Ensure object integrity

### Documentation
- **Inline Comments**: Explain complex logic
- **Module Summaries**: High-level overviews
- **README Files**: Setup and usage instructions
- **Code Examples**: Practical demonstrations

---

## 🚀 Future Enhancements

Potential extensions for advanced learning:

### Technical Improvements
- [ ] Add unit tests using JUnit 5
- [ ] Implement file-based persistence (save/load data)
- [ ] Add database integration (JDBC/Hibernate)
- [ ] Create REST API using Spring Boot
- [ ] Build GUI using JavaFX or Swing

### Feature Additions
- [ ] Multi-currency support
- [ ] Loan management system
- [ ] Credit card accounts
- [ ] Statement generation (PDF)
- [ ] Transaction search and filtering
- [ ] Account closure functionality
- [ ] User authentication and authorization
- [ ] Audit logging

### Architecture Upgrades
- [ ] Implement Repository pattern
- [ ] Add Dependency Injection
- [ ] Use Builder pattern for object creation
- [ ] Apply Factory pattern for account types
- [ ] Implement Observer pattern for notifications

---

## 🤝 Contributing

This is an educational repository. Contributions for improvements are welcome:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/improvement`)
3. Commit your changes (`git commit -m 'Add improvement'`)
4. Push to the branch (`git push origin feature/improvement`)
5. Open a Pull Request

**Guidelines:**
- Maintain code quality and consistency
- Add comments for complex logic
- Update documentation as needed
- Follow existing naming conventions

---

## 📝 License

This project is licensed for **Educational Purposes**. Feel free to use this material for learning and teaching Java programming.

---

## 📞 Contact & Support

For questions, suggestions, or issues:

- **Issues**: Use GitHub Issues for bug reports
- **Discussions**: Use GitHub Discussions for questions
- **Documentation**: Check module-specific README files

---

## 🎖️ Acknowledgments

This course curriculum is designed to provide a solid foundation in Java programming, following industry best practices and real-world application patterns. Special thanks to the Java community for continuous innovation and knowledge sharing.

---

## 📊 Progress Tracking

Track your learning journey:

- [ ] Complete Module 1: Getting Started
- [ ] Complete Module 2: Control Flow
- [ ] Complete Module 3: OOP Basics
- [ ] Complete Module 4: Final Project
- [ ] Build and run the Digital Banking System
- [ ] Customize the banking system with additional features
- [ ] Share your implementation

---

<div align="center">

**Happy Coding! 🚀**

*Building the foundation for your Java development career*

[⬆ Back to Top](#-java-introduction-to-software-development)

</div>
