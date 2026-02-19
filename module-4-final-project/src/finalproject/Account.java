package finalproject;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Account implements Transferable{
    private static final Logger logger = Logger.getLogger(Account.class.getName());
    private String accountNumber;
    private Customer accountHolder;
    private double balance;
    private String[] transactionHistory;
    private int transactionCount;

    public Account(String accountNumber, Customer accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new String[100];
        this.transactionCount = 0;
    }

    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public void displayBalance() {
        logger.log(Level.INFO, "Account: {0}", accountNumber);
        logger.log(Level.INFO, "Balance: ${0}", String.format("%.2f", balance));
    }

    public void addTransaction(String transaction) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = transaction;
            transactionCount++;
        }
    }

    public void displayTransactionHistory() {
        logger.log(Level.INFO, "\n=== Transaction History - {0} ===", accountNumber);
        for (int i = 0; i < transactionCount; i++) {
            logger.log(Level.INFO, "{0}. {1}", new Object[]{i + 1, transactionHistory[i]});
        }
        logger.log(Level.INFO, "Total Transactions: {0}", transactionCount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
