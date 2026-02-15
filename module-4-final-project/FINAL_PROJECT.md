# 🏦 DIGITAL BANKING SYSTEM - FINAL PROJECT

## Course: 01-java-introduction-to-software-development

---

## TABLE OF CONTENTS

1. Course Content Summary
2. Project Overview
3. Project Scope and Constraints
4. Project Architecture
5. Implementation Plan
6. Sample Code and Method Signatures
7. Testing Guidelines
8. Evaluation Criteria

---

## 1. COURSE CONTENT SUMMARY

### Module 1: Getting Started with Java
- Variables and Data Types: int, double, float, String
- Operators: Arithmetic, Relational, Logical, Assignment
- Strings: Immutable, methods like length(), charAt(), substring()
- Arrays: Fixed-size collections
- Basic I/O: System.out.println()

### Module 2: Control Flow
- Conditional Statements: if, else, else if, nested conditions
- Switch Statements: Multi-way branching
- Loops: for, while, do-while
- User Input: Scanner class
- String manipulation with loops

### Module 3: OOP Basics
- Classes and Objects
- Methods: signatures, parameters, return types
- Constructors
- Encapsulation: private fields, public getters/setters
- Inheritance: extends keyword
- Polymorphism: overloading and overriding
- Abstraction: abstract classes
- Interfaces: contracts for multiple inheritance

---

## 2. PROJECT OVERVIEW

### Project Name: Digital Banking System

### Description:
You will build a console-based Digital Banking System that demonstrates all the core Java concepts learned in this course. The system will allow users to create accounts, perform transactions, transfer money, and manage their banking activities through an interactive menu-driven interface.

### Core Features:
1. **Customer Management**: Create and manage customer information
2. **Account Management**: Support multiple account types (Savings, Checking)
3. **Transactions**: Deposit, withdraw, and view balance
4. **Money Transfers**: Transfer funds between accounts with daily limits
5. **Transaction History**: Track and display transaction records
6. **Interactive Menu**: User-friendly console interface using Scanner
7. **Validation**: Input validation and business rule enforcement

### Learning Objectives:
- Apply variables, data types, and operators in a real-world context
- Use control flow statements for decision-making and validation
- Implement loops for menu systems and transaction processing
- Design and implement classes with proper encapsulation
- Use inheritance to create specialized account types
- Apply polymorphism through method overloading and overriding
- Create abstract classes and interfaces for flexible design
- Integrate all concepts into a cohesive application

---

## 3. PROJECT SCOPE AND CONSTRAINTS

### WHAT TO INCLUDE (Based on Course Content):

#### From Module 1:
- Variables for storing account balances, customer names, account numbers
- Data types: int, double, String for banking data
- Arithmetic operators for calculations (balance updates, interest)
- String operations for customer name formatting and validation
- Arrays for storing multiple accounts and transaction history

#### From Module 2:
- if/else statements for validation (sufficient balance, valid input)
- Nested conditions for complex business rules
- switch statements for menu navigation
- for loops for processing multiple transactions or accounts
- while/do-while loops for interactive menu systems
- Scanner for user input

#### From Module 3:
- Customer class with encapsulated attributes
- Abstract Account class as base for all account types
- SavingsAccount and CheckingAccount as concrete subclasses
- Interface for transferable accounts
- Method overloading (multiple deposit/withdraw methods)
- Method overriding (different account behaviors)
- Constructors for object initialization
- Getters and setters for encapsulation

### WHAT NOT TO INCLUDE (Beyond Course Scope):

❌ **NO Advanced Collections**: No ArrayList, HashMap, LinkedList (use arrays only)
❌ **NO File I/O**: No reading/writing to files or databases
❌ **NO External Libraries**: Only use java.util.Scanner for input
❌ **NO Generics**: No parameterized types like `<T>`
❌ **NO Streams/Lambda**: No Java 8+ functional programming
❌ **NO Exception Handling**: Use simple if/else for validation
❌ **NO GUI**: Console-based only
❌ **NO Threads/Concurrency**: Single-threaded execution
❌ **NO Static Imports**: Use standard import statements
❌ **NO Enums**: Use String or int constants instead
❌ **NO Date/Time API**: Use simple String for date representation

### Design Principles:
✅ Keep it simple and beginner-friendly
✅ Focus on OOP fundamentals
✅ Use meaningful variable and method names
✅ Comment complex logic
✅ Validate all user inputs
✅ Keep methods small and focused (10-20 lines ideal)

---

## 4. PROJECT ARCHITECTURE

### Class Diagram Overview

```
┌─────────────────┐
│    Customer     │
└─────────────────┘
        ▲
        │ has
        │
┌───────────────────────┐
│   <<abstract>>        │
│      Account          │
└───────────────────────┘
        ▲
        │ extends
    ┌───┴───┐
    │       │
┌───────┐ ┌─────────┐
│Savings│ │Checking │
│Account│ │Account  │
└───────┘ └─────────┘
    │         │
    └────┬────┘
         │ implements
    ┌────────────┐
    │Transferable│
    │(interface) │
    └────────────┘

┌──────────────────┐
│ BankingSystem    │ (Main Menu & Orchestration)
└──────────────────┘
```

### 4.1 Customer Class

**Purpose**: Represent a bank customer with personal information

**Attributes**:
- `private String customerId` - Unique customer identifier
- `private String firstName` - Customer's first name
- `private String lastName` - Customer's last name
- `private String email` - Customer's email address
- `private String phoneNumber` - Customer's phone number

**Methods**:
- `Customer(String customerId, String firstName, String lastName, String email, String phoneNumber)` - Constructor
- `public String getFullName()` - Returns formatted full name
- `public void displayCustomerInfo()` - Displays customer details
- `public String getCustomerId()` - Getter for customerId
- `public String getFirstName()` - Getter for firstName
- `public String getLastName()` - Getter for lastName
- `public String getEmail()` - Getter for email
- `public String getPhoneNumber()` - Getter for phoneNumber
- `public void setEmail(String email)` - Setter for email
- `public void setPhoneNumber(String phoneNumber)` - Setter for phoneNumber

---

### 4.2 Abstract Account Class

**Purpose**: Base class for all account types with common banking operations

**Attributes**:
- `private String accountNumber` - Unique account identifier
- `private Customer accountHolder` - Customer who owns the account
- `private double balance` - Current account balance
- `private String[] transactionHistory` - Array to store transactions (max 100)
- `private int transactionCount` - Number of transactions recorded

**Constructors**:
- `Account(String accountNumber, Customer accountHolder, double initialBalance)` - Main constructor

**Methods**:
- `public abstract void deposit(double amount)` - Abstract method for deposits
- `public abstract boolean withdraw(double amount)` - Abstract method for withdrawals
- `public void displayBalance()` - Shows current balance
- `public void addTransaction(String transaction)` - Adds transaction to history
- `public void displayTransactionHistory()` - Shows all transactions
- `public String getAccountNumber()` - Getter for accountNumber
- `public Customer getAccountHolder()` - Getter for accountHolder
- `public double getBalance()` - Getter for balance
- `protected void setBalance(double balance)` - Protected setter for balance

---

### 4.3 SavingsAccount Class

**Purpose**: Savings account with interest calculation

**Extends**: Account

**Additional Attributes**:
- `private double interestRate` - Annual interest rate (e.g., 0.03 for 3%)
- `private int withdrawalsThisMonth` - Track monthly withdrawals
- `private static final int MAX_FREE_WITHDRAWALS = 3` - Free withdrawal limit

**Constructors**:
- `SavingsAccount(String accountNumber, Customer accountHolder, double initialBalance, double interestRate)`

**Methods**:
- `@Override public void deposit(double amount)` - Deposits with validation
- `@Override public boolean withdraw(double amount)` - Withdrawals with fee after limit
- `public void applyInterest()` - Calculates and adds monthly interest
- `public double calculateInterest()` - Returns interest amount
- `public void resetMonthlyWithdrawals()` - Resets withdrawal counter
- `public double getInterestRate()` - Getter for interestRate
- `public int getWithdrawalsThisMonth()` - Getter for withdrawalsThisMonth

---

### 4.4 CheckingAccount Class

**Purpose**: Checking account with overdraft protection

**Extends**: Account

**Additional Attributes**:
- `private double overdraftLimit` - Maximum negative balance allowed
- `private double overdraftFee` - Fee charged when using overdraft

**Constructors**:
- `CheckingAccount(String accountNumber, Customer accountHolder, double initialBalance, double overdraftLimit)`

**Methods**:
- `@Override public void deposit(double amount)` - Standard deposit
- `@Override public boolean withdraw(double amount)` - Withdraw with overdraft support
- `public boolean hasOverdraftProtection()` - Check if overdraft is available
- `public double getAvailableBalance()` - Balance + overdraft limit
- `public double getOverdraftLimit()` - Getter for overdraftLimit
- `public void setOverdraftLimit(double limit)` - Setter for overdraftLimit

---

### 4.5 Transferable Interface

**Purpose**: Contract for accounts that support money transfers

**Methods**:
- `boolean transferTo(Account destination, double amount)` - Transfer money to another account
- `boolean canTransfer(double amount)` - Check if transfer is allowed
- `double getDailyTransferLimit()` - Get the daily transfer limit
- `void setDailyTransferLimit(double limit)` - Set the daily transfer limit

**Implementing Classes**: SavingsAccount, CheckingAccount

---

### 4.6 BankingSystem Class (Main)

**Purpose**: Main application class with menu system and orchestration

**Attributes**:
- `private static Account[] accounts` - Array to store all accounts (max 50)
- `private static Customer[] customers` - Array to store all customers (max 50)
- `private static int accountCount` - Current number of accounts
- `private static int customerCount` - Current number of customers
- `private static Scanner scanner` - Scanner for user input

**Methods**:
- `public static void main(String[] args)` - Entry point
- `private static void displayMainMenu()` - Show main menu options
- `private static void createCustomer()` - Create new customer
- `private static void createAccount()` - Create new account
- `private static void performDeposit()` - Handle deposit transaction
- `private static void performWithdrawal()` - Handle withdrawal transaction
- `private static void performTransfer()` - Handle transfer between accounts
- `private static void viewAccountDetails()` - Display account information
- `private static void viewAllAccounts()` - List all accounts
- `private static Account findAccount(String accountNumber)` - Search for account
- `private static Customer findCustomer(String customerId)` - Search for customer
- `private static String generateAccountNumber()` - Auto-generate account number
- `private static String generateCustomerId()` - Auto-generate customer ID
- `private static boolean validateAmount(double amount)` - Validate transaction amount

---

## 5. IMPLEMENTATION PLAN

### Step-by-Step Implementation Guide

#### **Phase 1: Foundation (Module 1 Concepts)**

**Step 1: Create Customer Class**
- Create `Customer.java` with private attributes
- Implement constructor with all parameters
- Add getter methods for all attributes
- Add setter methods for email and phoneNumber
- Implement `getFullName()` method using string concatenation
- Implement `displayCustomerInfo()` method using System.out.println()

**Step 2: Create Abstract Account Class**
- Create `Account.java` as abstract class
- Declare private attributes (accountNumber, accountHolder, balance)
- Create String array for transactionHistory (size 100)
- Add int variable for transactionCount
- Implement constructor to initialize all fields
- Add abstract methods: deposit() and withdraw()
- Implement concrete methods: displayBalance(), addTransaction(), displayTransactionHistory()
- Add getter methods and protected setBalance()

#### **Phase 2: Inheritance and Polymorphism (Module 3 Concepts)**

**Step 3: Create SavingsAccount Class**
- Extend Account class
- Add private attributes: interestRate, withdrawalsThisMonth
- Add static constant MAX_FREE_WITHDRAWALS = 3
- Implement constructor calling super()
- Override deposit() method with validation (amount > 0)
- Override withdraw() method with:
  - Balance check
  - Withdrawal limit check
  - Fee calculation after free withdrawals
- Implement applyInterest() and calculateInterest() methods
- Add resetMonthlyWithdrawals() method
- Add getters for new attributes

**Step 4: Create CheckingAccount Class**
- Extend Account class
- Add private attributes: overdraftLimit, overdraftFee
- Implement constructor calling super()
- Override deposit() method with validation
- Override withdraw() method with overdraft logic
- Implement hasOverdraftProtection() returning boolean
- Implement getAvailableBalance() (balance + overdraftLimit)
- Add getters and setters

#### **Phase 3: Interfaces (Module 3 Advanced)**

**Step 5: Create Transferable Interface**
- Create `Transferable.java` interface
- Declare method signatures (no implementation):
  - boolean transferTo(Account destination, double amount)
  - boolean canTransfer(double amount)
  - double getDailyTransferLimit()
  - void setDailyTransferLimit(double limit)

**Step 6: Implement Transferable in Account Classes**
- Modify SavingsAccount to implement Transferable
- Add dailyTransferLimit and transferredToday attributes
- Implement all interface methods
- Modify CheckingAccount to implement Transferable
- Implement all interface methods

#### **Phase 4: Main Application (Module 2 Control Flow)**

**Step 7: Create BankingSystem Class Structure**
- Create `BankingSystem.java` with main method
- Declare static arrays for accounts and customers (size 50)
- Declare static counters: accountCount, customerCount
- Create static Scanner object
- Initialize arrays in main method

**Step 8: Implement Menu System**
- Create displayMainMenu() method using System.out.println()
- Use do-while loop in main() for continuous menu
- Use switch statement for menu options:
  - Case 1: Create Customer
  - Case 2: Create Account
  - Case 3: Deposit
  - Case 4: Withdraw
  - Case 5: Transfer
  - Case 6: View Account Details
  - Case 7: View All Accounts
  - Case 0: Exit
- Use Scanner to get user choice

**Step 9: Implement Customer Creation**
- Create createCustomer() method
- Use Scanner to get input: firstName, lastName, email, phoneNumber
- Use if statements to validate input (not empty)
- Call generateCustomerId() to create unique ID
- Create Customer object
- Add to customers array
- Increment customerCount

**Step 10: Implement Account Creation**
- Create createAccount() method
- Display list of customers using for loop
- Get customer selection using Scanner
- Use findCustomer() to locate Customer object
- Ask for account type using switch (1=Savings, 2=Checking)
- Get initial balance using Scanner
- Validate balance > 0 using if statement
- Generate account number
- Create appropriate account object (polymorphism)
- Add to accounts array
- Increment accountCount

**Step 11: Implement Transactions**
- Create performDeposit() method:
  - Get account number from user
  - Use findAccount() to locate account
  - Use if/else to check if account exists
  - Get deposit amount
  - Validate amount > 0
  - Call account.deposit(amount)
  - Display success message

- Create performWithdrawal() method:
  - Get account number from user
  - Find account
  - Get withdrawal amount
  - Validate amount
  - Call account.withdraw(amount)
  - Check return value and display appropriate message

- Create performTransfer() method:
  - Get source account number
  - Get destination account number
  - Find both accounts using findAccount()
  - Validate both exist using if statements
  - Get transfer amount
  - Check if source implements Transferable using instanceof
  - Call transferTo() method
  - Display result

**Step 12: Implement Helper Methods**
- Create findAccount(String accountNumber):
  - Use for loop to iterate through accounts array
  - Use if statement to compare account numbers
  - Return Account or null

- Create findCustomer(String customerId):
  - Use for loop to iterate through customers array
  - Use if statement to compare customer IDs
  - Return Customer or null

- Create generateAccountNumber():
  - Use string concatenation
  - Format: "ACC" + (accountCount + 1)
  - Example: ACC1, ACC2, ACC3

- Create generateCustomerId():
  - Use string concatenation
  - Format: "CUST" + (customerCount + 1)
  - Example: CUST1, CUST2, CUST3

- Create validateAmount(double amount):
  - Return true if amount > 0
  - Return false otherwise

**Step 13: Implement Display Methods**
- Create viewAccountDetails():
  - Get account number from user
  - Find account
  - Use if/else to check if exists
  - Call account.displayBalance()
  - Call accountHolder.displayCustomerInfo()
  - Call account.displayTransactionHistory()

- Create viewAllAccounts():
  - Use for loop from 0 to accountCount
  - Display each account's basic info
  - Use System.out.println() with formatted output

#### **Phase 5: Testing and Refinement**

**Step 14: Test Basic Functionality**
- Create test customers
- Create test accounts (both types)
- Test deposits
- Test withdrawals
- Test balance display

**Step 15: Test Advanced Features**
- Test transfers between accounts
- Test overdraft on checking accounts
- Test withdrawal limits on savings accounts
- Test interest calculation
- Test transaction history

**Step 16: Test Edge Cases**
- Test negative amounts
- Test withdrawing more than balance
- Test transferring to non-existent account
- Test array bounds (max 50 accounts/customers)
- Test invalid menu options

**Step 17: Add Input Validation**
- Add validation for all user inputs
- Handle invalid numbers using if/else
- Prevent negative amounts
- Check for empty strings
- Display helpful error messages

**Step 18: Polish and Documentation**
- Add comments to explain complex logic
- Format output for better readability
- Add separators (lines, spaces) in console output
- Test complete user flow
- Create sample usage documentation

---

## 6. TESTING GUIDELINES

### 6.1 Manual Testing Checklist

#### Test Scenario 1: Customer Creation
**Steps:**
1. Run the application
2. Select option 1 (Create Customer)
3. Enter customer details
4. Verify customer ID is auto-generated

**Expected Result:**
- Customer created with unique ID (CUST1, CUST2, etc.)
- All information displayed correctly

#### Test Scenario 2: Account Creation & Transactions
**Steps:**
1. Create Savings Account with balance 1000.00
2. Perform 3 withdrawals of 100.00 each
3. Perform 4th withdrawal of 100.00

**Expected Result:**
- First 3 withdrawals: No fee
- 4th withdrawal: Fee of $2.00 applied

#### Test Scenario 3: Transfer Between Accounts
**Steps:**
1. Create two accounts (ACC1 with 1000.00, ACC2 with 500.00)
2. Transfer 300.00 from ACC1 to ACC2

**Expected Result:**
- ACC1 balance: 700.00
- ACC2 balance: 800.00

### 7.2 Edge Cases to Test
1. Array Capacity (50 max)
2. Invalid Input
3. Transaction History Overflow (100 max)
4. Account Not Found
5. Daily Transfer Limit

---

## 7. EVALUATION CRITERIA

### Total: 100 Points

| Category | Points | Key Criteria |
|----------|--------|--------------|
| Functionality | 40 | All features work correctly |
| OOP Principles | 30 | Encapsulation, inheritance, polymorphism, abstraction, interfaces |
| Control Flow | 15 | Menu system, validation, loops |
| Code Quality | 10 | Naming, organization, comments |
| Creativity | 5 | Bonus features (optional) |

### Grading Scale
- 90-100: A (Excellent)
- 80-89: B (Good)
- 70-79: C (Satisfactory)
- 60-69: D (Needs Improvement)
- Below 60: F (Insufficient)

---

## 8. SUBMISSION GUIDELINES

### Required Files:
1. Customer.java
2. Account.java (abstract)
3. SavingsAccount.java
4. CheckingAccount.java
5. Transferable.java (interface)
6. BankingSystem.java (main)

---

## 9. COMMON MISTAKES TO AVOID

1. Forgetting to call super() in subclass constructors
2. Not implementing all interface methods
3. Making attributes public instead of private
4. Not validating user input
5. Array index out of bounds
6. Forgetting to increment counters
7. Not using polymorphism
8. Infinite loops
9. Scanner issues (nextLine() after nextInt())
10. Not closing Scanner

---

## 10. FINAL CHECKLIST

- [ ] All 6 required Java files created
- [ ] Program compiles without errors
- [ ] All menu options work correctly
- [ ] Customer creation works
- [ ] Both account types can be created
- [ ] Deposits work with validation
- [ ] Withdrawals work with different logic per account type
- [ ] Transfers work between accounts
- [ ] Transaction history displays correctly
- [ ] Proper encapsulation implemented
- [ ] Inheritance properly implemented
- [ ] Polymorphism demonstrated
- [ ] Interface implemented correctly
- [ ] Comments added to complex logic
- [ ] Tested with various scenarios

---

## 11. CONCLUSION

This Digital Banking System project integrates all fundamental Java concepts:

- **Module 1**: Variables, data types, operators, strings, arrays
- **Module 2**: Control flow (if/else, switch, loops), Scanner
- **Module 3**: OOP principles (encapsulation, inheritance, polymorphism, abstraction, interfaces)

### You Will Demonstrate:
1. Design a class hierarchy
2. Implement business logic
3. Create interactive console applications
4. Apply OOP principles in real-world scenarios
5. Write clean, organized, well-documented code

**Good luck, and happy coding!** ??

---

**End of Final Project Specification**
