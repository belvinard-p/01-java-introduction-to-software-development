# Exercise 5: Abstraction and Abstract Classes - Key Takeaways

## ✅ What Was Implemented

### 1. **Abstract Class Declaration**
```java
public abstract class BankAccount {
    // Cannot be instantiated directly
    public abstract void displayAccountType();
}
```

### 2. **Abstract Method Implementation**
- `SavingsAccount` implements `displayAccountType()` → "This is a Savings Account"
- `CheckingAccount` implements `displayAccountType()` → "This is a Checking Account"

### 3. **Compilation Error Demonstration**
```java
// This WILL NOT compile:
// BankAccount account = new BankAccount("123", "John", 1000.0);
// Error: BankAccount is abstract; cannot be instantiated
```

---

## 🎯 Key Takeaways

### 1. **Abstract Classes Cannot Be Instantiated**
- You cannot create objects directly from an abstract class
- They serve as templates/blueprints for subclasses
- Use `abstract` keyword in class declaration

### 2. **Abstract Methods Force Implementation**
- Abstract methods have no body (no implementation)
- All concrete subclasses MUST implement abstract methods
- Guarantees consistent behavior across all account types

### 3. **Partial Contract**
- Abstract classes can have:
  - ✅ Concrete methods (with implementation) → `deposit()`, `withdraw()`
  - ✅ Abstract methods (without implementation) → `displayAccountType()`
  - ✅ Attributes → `balance`, `accountNumber`
  - ✅ Constructors → Used by subclasses via `super()`

### 4. **Polymorphism Still Works**
```java
BankAccount[] accounts = {savings, checking};
for (BankAccount account : accounts) {
    account.displayAccountType(); // Calls correct implementation
}
```

### 5. **When to Use Abstract Classes**
- ✅ Common behavior shared across subclasses
- ✅ Some methods need different implementations per subclass
- ✅ Prevent instantiation of generic/incomplete classes
- ✅ Enforce implementation contract

---

## 🆚 Abstract Class vs Interface (Preview for Exercise 6)

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Methods | Can have both abstract and concrete | Only abstract (Java 8+ allows default) |
| Attributes | Can have instance variables | Only constants (public static final) |
| Constructor | Can have constructors | Cannot have constructors |
| Inheritance | Single inheritance (extends one) | Multiple inheritance (implements many) |
| Use Case | "IS-A" relationship | "CAN-DO" capability |

---

## 💡 Real-World Banking Analogy

**Abstract Class = Generic "Account" Concept**
- You can't open a generic "account" at a bank
- You must choose: Savings, Checking, Investment, etc.
- All accounts share common features (balance, deposit, withdraw)
- Each type has specific behaviors (interest calculation, overdraft rules)

**Abstract Method = Required Feature**
- Every account MUST display its type
- But each type displays differently
- The abstract method enforces this requirement

---

## 🔍 Code Structure

```
BankAccount (abstract)
├── deposit() [concrete]
├── withdraw() [concrete]
├── displayBalance() [concrete]
└── displayAccountType() [abstract] ← Must be implemented

SavingsAccount extends BankAccount
└── displayAccountType() [implemented] ✅

CheckingAccount extends BankAccount
└── displayAccountType() [implemented] ✅
```

---

## ✨ Benefits Achieved

1. **Code Reusability** - Common logic in BankAccount
2. **Consistency** - All accounts must implement displayAccountType()
3. **Flexibility** - Each subclass provides its own implementation
4. **Type Safety** - Compiler enforces implementation
5. **Maintainability** - Changes to common behavior in one place

---

## 🚀 Next Steps

Exercise 6 will introduce **Interfaces** which provide:
- Multiple inheritance capability
- Pure contracts (no implementation)
- Cross-cutting concerns (CreditEligible, Notifiable)
