
# 🏦 Module 2 — Control Flow (Context Banking)

## 🎯 Module objective

This module has goal to master:

* Controls flow(`if`, `else if`, `else`)
* Multiple choices(`switch`)
* Loops (`for`, `while`, `do-while`)
  in real scenarios **banking system**.

---

## 📘 Exercise 1 — Account Status Validation (if / else)

### Context

In an internet banking system, an account can have different balances.
Depending on the account balance, the system must determine the account status.

### Requirements

Write a Java program that:

* Declares an integer variable `accountBalance`
* If the balance is:

    * greater than 100_000 → display **"Account status: VIP"**
    * between 10_000 and 100_000 → display **"Account status: Active"**
    * between 1 and 9_999 → display **"Account status: Low balance"**
    * equal to 0 → display **"Account status: Empty account"**
    * less than 0 → display **"Account status: Overdraft"**

---

## 📘 Exercise 2 — Loan Eligibility Check (if / else if / else)

### Context

A bank evaluates loan eligibility based on a customer’s monthly income and credit score.

### Requirements

Write a Java program that:

* Declares:

    * `double monthlyIncome`
    * `int creditScore`
* Apply the following rules:

    * If income ≥ 500_000 and credit score ≥ 700 → **"Loan approved"**
    * If income ≥ 300_000 and credit score ≥ 600 → **"Loan conditionally approved"**
    * Otherwise → **"Loan rejected"**

---

## 📘 Exercise 3 — Transaction Type Processing (switch)

### Context

In an internet banking application, different transaction types are processed differently.

### Requirements

Write a Java program that:

  * Declares a `String transactionType`
* Uses a `switch` statement to handle:

    * `"DEPOSIT"` → display **"Processing deposit transaction"**
    * `"WITHDRAWAL"` → display **"Processing withdrawal transaction"**
    * `"TRANSFER"` → display **"Processing transfer transaction"**
    * `"BALANCE_INQUIRY"` → display **"Processing balance inquiry"**
    * default → display **"Unknown transaction type"**

---

## 📘 Exercise 4 — Daily Transaction Processing (for loop)

### Context

A bank system processes transactions recorded during the day.

### Requirements

Write a Java program that:

* Uses a `for` loop to process **10 transactions**
* For each transaction number, display:

    * `"Processing transaction #X"`

---

## 📘 Exercise 5 — Account Balance Monitoring (while loop)

### Context

A bank continuously monitors an account balance until it becomes insufficient.

### Requirements

Write a Java program that:

* Declares an integer `accountBalance`
* Uses a `while` loop to:

    * Deduct 5_000 from the balance on each iteration
    * Continue while the balance is greater than 0
    * Display the balance after each deduction

---

## 📘 Exercise 6 — ATM Withdrawal Simulation (do-while loop)

### Context

An ATM allows at least one withdrawal attempt before validating the remaining balance.

### Requirements

Write a Java program that:

* Declares:

    * `int accountBalance`
    * `int withdrawalAmount`
* Uses a `do-while` loop to:

    * Perform a withdrawal
    * Display the remaining balance
    * Continue while the balance is sufficient for another withdrawal

---

## 📘 Exercise 7 — Choosing the Right Loop (Analysis)

### Context

Different banking scenarios require different iterative structures.

### Requirements

Answer the following questions in comments:

* When is a `for` loop more appropriate than a `while` loop in banking systems?
* When should a `do-while` loop be preferred?
* Give one banking example for each loop type.

#### Solution: 
| Loop Type  | Best Used When                 | Banking Example                    |
| ---------- | ------------------------------ | ---------------------------------- |
| `for`      | Number of iterations is known  | Process fixed list of transactions |
| `while`    | Condition-based, unknown count | Retry login attempts               |
| `do-while` | Must execute at least once     | ATM menu display                   |

---

## 📘 Exercise 8 — ATM User Interaction (Scanner + Control Flow)

### Context

In an internet banking ATM simulation, the system must interact with the user to process a transaction based on their input.

### Requirements

Write a Java program that:

* Uses `Scanner` to read user input from the console
* Asks the user to enter:

    * their current account balance
    * a withdrawal amount
* Applies the following rules using conditional statements:

    * If the withdrawal amount is greater than the account balance, display
      **"Transaction denied: insufficient funds"**
    * If the withdrawal amount is less than or equal to 0, display
      **"Invalid withdrawal amount"**
    * Otherwise:

        * deduct the withdrawal amount from the balance
        * display **"Transaction successful"**
        * display the remaining balance

### Additional Constraints

* The program must:

    * use `if / else if / else`
    * close the `Scanner` after use
* All amounts must be handled using appropriate numeric data types

---

## 🧠 Notes importantes (senior mindset)

* All exercises are **independent**
* Use **clear variable names** related to banking
* Prefer readable numeric literals (`100_000`)
* Use logging instead of `System.out.println` if possible

