package oopbasics.exercise01;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BankAccount {
    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private double dailyTransferLimit;
    private double transferredToday;

    public double getBalance() {
        return balance;
    }

    public abstract void displayAccountType();

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.dailyTransferLimit = 0.0;
        this.transferredToday = 0.0;
    }

    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            logger.log(Level.WARNING, "Deposit failed: Amount must be positive");
            return;
        }
        balance += amount;
    }

    public void deposit(int amount) {
        deposit((double) amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            logger.log(Level.WARNING, "Withdrawal failed: Amount must be positive");
            return false;
        }
        if (balance < amount) {
            logger.log(Level.WARNING, "Withdrawal failed: Insufficient funds");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void displayBalance() {
        logger.log(Level.INFO, "Account Number: {0}, Account Holder: {1}, Balance: {2}",
                new Object[]{accountNumber, accountHolder, balance});
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public boolean canTransfer(double amount) {
        return transferredToday + amount <= dailyTransferLimit;
    }

    public void addToTransferredToday(double amount) {
        transferredToday += amount;
    }

    public double getDailyTransferLimit() {
        return dailyTransferLimit;
    }

    public void setDailyTransferLimit(double dailyTransferLimit) {
        this.dailyTransferLimit = dailyTransferLimit;
    }

    public double getTransferredToday() {
        return transferredToday;
    }
}