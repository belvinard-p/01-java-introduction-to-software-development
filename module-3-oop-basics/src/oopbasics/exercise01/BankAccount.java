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
    private String[] transactionHistory;
    private int transactionCount;

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
        this.transactionHistory = new String[100];
        this.transactionCount = 0;
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
        addTransaction(String.format("DEPOSIT: +$%.2f", amount));
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
        addTransaction(String.format("WITHDRAWAL: -$%.2f", amount));
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

    public void displayTransactionHistory() {
        logger.log(Level.INFO, "=== Transaction History - Account {0} ===", accountNumber);
        for (int i = 0; i < transactionCount; i++) {
            logger.log(Level.INFO, "{0}. {1}", new Object[]{i + 1, transactionHistory[i]});
        }
        logger.log(Level.INFO, "Total Transactions: {0}", transactionCount);
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    private void addTransaction(String transactionRecord) {
        if (transactionCount < 100) {
            transactionHistory[transactionCount++] = transactionRecord;
        } else {
            logger.log(Level.WARNING, "Transaction history full. Cannot add more transactions.");
        }
    }

    public void recordInterest(double amount) {
        balance += amount;
        addTransaction(String.format("INTEREST: +$%.2f", amount));
    }

    public void recordFee(double amount) {
        balance -= amount;
        addTransaction(String.format("FEE: -$%.2f", amount));
    }

    public void recordBillPayment(String billType, double amount) {
        if (withdraw(amount)) {
            transactionHistory[transactionCount - 1] = String.format("BILL PAYMENT (%s): -$%.2f", billType, amount);
        }
    }

    public void recordTransferOut(double amount, String toAccountNumber) {
        addTransaction(String.format("TRANSFER OUT: -$%.2f to %s", amount, toAccountNumber));
    }

    public void recordTransferIn(double amount, String fromAccountNumber) {
        addTransaction(String.format("TRANSFER IN: +$%.2f from %s", amount, fromAccountNumber));
    }

    protected String getTransaction(int index) {
        if (index >= 0 && index < transactionCount) {
            return transactionHistory[index];
        }
        return null;
    }
}