# 🏦 Module 3 — OOP Basics (Banking Context)

## 🎯 Module Objective

Master Object-Oriented Programming fundamentals:
- Classes & Objects
- Inheritance
- Polymorphism (Method Overloading & Overriding)
- Encapsulation
- Abstraction
- Interfaces
- Static Methods

---

### **Exercise 1: Foundations (Classes, Objects, Methods)**
**Context:** Create the core system for a bank account.

**Task:**
1. Create a class named `BankAccount`.
2. It should have the following attributes (choose appropriate types): `accountNumber`, `accountHolder`, `balance`.
3. Create a **constructor** that initializes `accountNumber`, `accountHolder`, and `balance` (the latter can default to 0.0).
4. Implement the following methods:
  *   `void deposit(double amount)`: Increases the balance.
  *   `boolean withdraw(double amount)`: Decreases the balance if funds are sufficient. Returns `true` if the withdrawal was successful, `false` otherwise.
  *   `void displayBalance()`: Displays the account information (holder, number, balance).

**Objective:** Understand class definition, object creation (`new BankAccount(...)`), and method calling.

---

### **Exercise 2: Inheritance**
**Context:** Our bank now offers different types of accounts.

**Task:**
1. Create a new class `SavingsAccount` that **inherits** from `BankAccount`.
2. Add a specific attribute: `interestRate` (e.g., 0.03 for 3%).
3. **Override** the `displayBalance()` method so it also displays the interest rate.
4. Add a specific method `void applyInterest()` that calculates the interest (`balance * interestRate`) and adds it to the balance.

**Objective:** Practice inheritance (`extends`), adding specific attributes/methods, and method overriding.

---

### **Exercise 3: Polymorphism (Overloading & Overriding)**
**Context:** Let's improve the flexibility of our operations.

**Part A - Overloading in `BankAccount`:**
1. Overload the `deposit` method so it can also accept an `int` (`void deposit(int amount)`). It should convert the `amount` to `double`.

**Part B - Polymorphism via Overriding:**
1. Create another class `CheckingAccount` that also inherits from `BankAccount`.
2. Add an attribute `overdraftLimit`.
3. **Override** the `withdraw(double amount)` method to allow the withdrawal even if the balance is insufficient, as long as it does not exceed `balance + overdraftLimit`.
4. In a `Main` class with a `main` method:
  *   Create an array or a list of type `BankAccount`.
  *   Add a `SavingsAccount` object and a `CheckingAccount` object to it.
  *   Use a loop to call `withdraw(150)` on each account. Observe how the behavior **differs** based on the actual object type, even though they are treated as `BankAccount` objects. This is polymorphism in action!

**Objective:** Distinguish overloading (same class, different signatures) from overriding (inheritance, same signature) and experience polymorphism via parent-type references.

---

### **Exercise 4: Encapsulation**
**Context:** The attributes of our classes are currently `public`. We need to protect them.

**Task:**
1. In all created classes (`BankAccount`, `SavingsAccount`, `CheckingAccount`), make all attributes **`private`**.
2. For each private attribute that needs to be accessible from outside (e.g., `balance` for read-only, `interestRate` for read/write), create **getter** (and **setter** if necessary) methods.
  *   Example: `public double getBalance() { return balance; }`
3. Modify all methods within the classes (like `withdraw`, `deposit`) so they use the `private` attributes directly (this is allowed within the same class).
4. In the `main` method, try to access `account.balance` directly. It should no longer compile. Use `account.getBalance()` instead.

**Objective:** Apply encapsulation with `private` and control access via getters/setters.

---

### **Exercise 5: Abstraction and Abstract Classes**
**Context:** We want to guarantee that all accounts have certain behavior, but `BankAccount` is too generic to be instantiated on its own.

**Task:**
1. Transform the `BankAccount` class into an **abstract class**.
  *   Add the `abstract` keyword to its declaration.
2. Declare an abstract method `void displayAccountType()` in `BankAccount`.
3. The `SavingsAccount` and `CheckingAccount` classes must now **implement** (`@Override`) this method to display their type ("Savings Account", "Checking Account").
4. Try to create an object `new BankAccount(...)` in `main`. It should no longer compile. The class now serves as an abstract template.

**Objective:** Understand the role of an abstract class as a partial contract and the use of abstract methods to force implementation.

---

### **Exercise 6: Interfaces**
**Context:** The bank wants to offer optional features to certain accounts.

**Task:**
1. Create an interface `CreditEligible` that declares a method `boolean checkCreditEligibility()`.
2. Create an interface `Notifiable` that declares a method `void sendAlert(String message)`.
3. Make the `CheckingAccount` class **implement** the `CreditEligible` interface. Its verification logic could be: `return (balance > -overdraftLimit * 0.5);` (simplistic example).
4. Make the `SavingsAccount` class **implement** the `Notifiable` interface. Its `sendAlert` method could simply print "Savings Alert: [message]".
5. In the `main` method:
  *   Create a `CheckingAccount` and use a reference of type `CreditEligible` to call `checkCreditEligibility()`.
  *   Create a `SavingsAccount` and use a reference of type `Notifiable` to call `sendAlert("Interest rate changed")`.
  *   **Challenge:** Can you create a `VIPAccount` class that inherits from `CheckingAccount` and implements **both** `CreditEligible` and `Notifiable`?

**Objective:** Understand interface definition (`interface`), their implementation (`implements`), and how they allow adding cross-cutting behaviors without relying on class inheritance.

## 🧩 Exercise 8: Simple Transfer System

### 🎯 Objective
Introduce transfer operations using basic OOP concepts:
- Static methods for utility operations
- Object references for account interactions
- Method parameters and return values

### 📘 Context
Customers need to transfer money between accounts.

### 📝 Requirements

**Create `TransferService` class with static methods:**
- `static boolean transfer(BankAccount from, BankAccount to, double amount)`
- `static boolean transfer(BankAccount from, BankAccount to, double amount, String description)`
- `static boolean transferWithFee(BankAccount from, BankAccount to, double amount, double fee)`

**Transfer Logic:**
- Check if source account has sufficient funds (including fees)
- Withdraw from source account
- Deposit to destination account
- Return true if successful, false otherwise
- Print transfer details when description is provided

**Add to `BankAccount`:**
- `private double dailyTransferLimit` - daily transfer limit
- `private double transferredToday` - amount transferred today
- `public boolean canTransfer(double amount)` - check daily limit
- `public void addToTransferredToday(double amount)` - update daily total
- Getters and setters for transfer limits

**Override in subclasses:**
- `SavingsAccount`: $1,000 daily limit
- `CheckingAccount`: $5,000 daily limit

**Main Method Testing:**
- Create multiple accounts
- Perform transfers between them
- Test daily transfer limits
- Use all transfer method variations

**Expected Output Example:**
```
=== Transfer Test ===
Transfer: $500.00 from John's Savings to Jane's Checking
Description: Loan repayment
Transfer successful!

John's Account - Balance: $1,500.00 | Transferred today: $500.00
Jane's Account - Balance: $2,500.00
```

---

## 🧩 Exercise 9: Transaction History with Arrays

### 🎯 Objective
Implement basic transaction tracking using:
- Arrays for data storage
- String manipulation for transaction records
- Method overloading for different transaction types

### 📘 Context
Every banking operation should be recorded for customer statements.

### 📝 Requirements

**Add to `BankAccount`:**
- `private String[] transactionHistory` - array to store transaction records (size 100)
- `private int transactionCount` - current number of transactions
- `private void addTransaction(String transactionRecord)` - helper method
- `public void displayTransactionHistory()` - show all transactions
- `public int getTransactionCount()` - getter method

**Update existing methods to record transactions:**
- `deposit()` methods - record "DEPOSIT: +$X.XX"
- `withdraw()` methods - record "WITHDRAWAL: -$X.XX"
- Update `TransferService.transfer()` methods to record:
    - Source account: "TRANSFER OUT: -$X.XX to [AccountNumber]"
    - Destination account: "TRANSFER IN: +$X.XX from [AccountNumber]"

**Add transaction-specific methods:**
- `public void recordInterest(double amount)` - for interest payments
- `public void recordFee(double amount)` - for fee charges
- `public void recordBillPayment(String billType, double amount)` - for bill payments

**Enhance `OnlineService` interface:**
```java
public interface OnlineService {
    boolean payBill(String billType, double amount);
    void generateStatement();
    void displayLastTransactions(int count); // show last N transactions
}
```

**Main Method Testing:**
- Create accounts and perform various operations
- Display transaction history for each account
- Test array bounds (what happens after 100 transactions?)

**Expected Output:**
```
=== Transaction History - Account SA001 ===
1. DEPOSIT: +$1000.00
2. WITHDRAWAL: -$150.00
3. INTEREST: +$25.50
4. TRANSFER OUT: -$500.00 to CA002
5. BILL PAYMENT (Utilities): -$85.00
Total Transactions: 5
```

---

## 🧩 Exercise 10: Complete Banking System Integration

### 🎯 Objective
Integrate all OOP concepts into a comprehensive system:
- All inheritance, polymorphism, encapsulation, abstraction, and interface concepts
- Transfer capabilities with transaction tracking
- Method overloading throughout the system

### 📝 Requirements

**Create comprehensive account system:**

**Add `PremiumAccount` extends `CheckingAccount` implements `OnlineService`:**
- Additional attribute: `double rewardPoints`
- Override `calculateMonthlyFee()` - reduced fee: $1.00
- Override `withdraw()` - earn reward points (1 point per $10 withdrawn)
- Add `void redeemRewards(double pointsToRedeem)` - convert points to cash (100 points = $1)

**Enhanced `TransferService` with overloaded methods:**
- `transfer(BankAccount from, BankAccount to, double amount)`
- `transfer(BankAccount from, BankAccount to, double amount, String description)`
- `transfer(BankAccount from, BankAccount to, double amount, double fee, String description)`
- `bulkTransfer(BankAccount source, BankAccount[] destinations, double[] amounts)` - transfer to multiple accounts

**Create `BankingSystemDemo` class:**
- Method `public static void simulateDay(BankAccount[] accounts)` - simulate daily operations
- Method `public static void generateSystemReport(BankAccount[] accounts)` - system-wide statistics
- Method `public static double calculateTotalSystemBalance(BankAccount[] accounts)` - polymorphic balance calculation

**Comprehensive Main Method:**
- Create array with different account types: `BankAccount[] accounts = new BankAccount[5];`
- Include `SavingsAccount`, `CheckingAccount`, and `PremiumAccount` objects
- Simulate various banking operations:
    - Deposits and withdrawals
    - Transfers between accounts
    - Bill payments
    - Interest applications
    - Fee deductions
    - Reward point redemptions
- Display transaction histories
- Generate system report
- Demonstrate all polymorphic behaviors

**Expected Final Output:**
```
=== BANKING SYSTEM DEMO ===

Account Types Created:
- Savings Account: SA001 (John Doe)
- Checking Account: CA002 (Jane Smith)  
- Premium Account: PA003 (Bob Johnson)

=== Daily Operations Simulation ===
Processing deposits...
Processing withdrawals...  
Processing transfers...
Processing bill payments...

=== System Report ===
Total Accounts: 3
Total System Balance: $8,750.00
Total Transactions Today: 15
Account Type Distribution:
- Savings: 1 account ($2,500.00)
- Checking: 1 account ($3,250.00)  
- Premium: 1 account ($3,000.00)

Monthly Fees Due:
- Savings: $2.00
- Checking: $5.00
- Premium: $1.00
Total Monthly Fees: $8.00

=== OOP Concepts Demonstrated ===
✅ Classes & Objects: Multiple account instances
✅ Inheritance: 3-level hierarchy (BankAccount → CheckingAccount → PremiumAccount)
✅ Polymorphism: Method overriding in action
✅ Method Overloading: Transfer service with multiple signatures
✅ Encapsulation: All attributes private with controlled access
✅ Abstraction: BankAccount as abstract template
✅ Interfaces: OnlineService contract implementation
✅ Static Methods: TransferService utility operations
```

---

## 🎓 Learning Outcomes - Curriculum Aligned

By completing these exercises, you will have mastered all concepts from your **OOP Module Summary**:

### Lesson 1: Foundations ✅
- **Classes & Objects**: Blueprint vs instance understanding through `BankAccount` hierarchy
- **Methods**: Proper method signatures and modular, reusable code structure

### Lesson 2: Hierarchies & Flexibility ✅
- **Inheritance**: Superclass (`BankAccount`) and subclasses (`SavingsAccount`, `CheckingAccount`, `PremiumAccount`)
- **Polymorphism via Method Overloading**: Multiple `deposit()` and `transfer()` signatures
- **Polymorphism via Method Overriding**: Different `withdraw()` behaviors per account type

### Lesson 3: Security & Design ✅
- **Encapsulation**: Private attributes with public getters/setters for data protection
- **Abstraction**: Abstract `BankAccount` class hiding implementation complexity
- **Interfaces**: `OnlineService` contract defining required capabilities

### Practical Application ✅
- **Real-world Problem**: Complete banking system with transfers and transaction tracking
- **Hands-on Coding**: Progressive exercises building from simple to complex
- **Theory to Practice**: Every OOP principle applied in meaningful banking context

**Enhanced Features Added:**
- ✅ **Transfer Operations** - Inter-account money movement using static utility methods  
- ✅ **Transaction Tracking** - Simple array-based history without advanced collections  
- ✅ **Daily Limits** - Business logic implementation using basic attributes  
- ✅ **System Integration** - Comprehensive demonstration using arrays and basic data structures

---

## 🧠 Notes

- All exercises build upon previous concepts
- Use clear variable names related to banking
- Focus on OOP principles over complex logic
- Test all polymorphic behaviors thoroughly
