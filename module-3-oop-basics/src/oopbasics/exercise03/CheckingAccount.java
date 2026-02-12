package oopbasics.exercise03;

import oopbasics.exercise01.BankAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckingAccount extends BankAccount {
    private static final Logger logger = Logger.getLogger(CheckingAccount.class.getName());
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            logger.log(Level.WARNING, "Withdrawal failed: Amount must be positive");
            return false;
        }
        if (getBalance() + overdraftLimit < amount) {
            logger.log(Level.WARNING, "Withdrawal failed: Exceeds overdraft limit");
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public void displayAccountType() {
        logger.log(Level.INFO, "This is a Checking Account");
    }
}
