package oopbasics.exercise02;

import oopbasics.exercise01.BankAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SavingsAccount extends BankAccount {
    private static final Logger logger = Logger.getLogger(SavingsAccount.class.getName());
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder,
                          double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayBalance() {
        super.displayBalance();
        logger.log(Level.INFO, "Interest rate: " + (interestRate * 100) + "%");
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        logger.log(Level.INFO, "Interest applied: " + interest);
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(
                "SA001", "Belvinard", 1000.0, 0.05
        );

        logger.log(Level.INFO, "=== Before Interest ===");
        savingsAccount.displayBalance();

        savingsAccount.applyInterest();

        logger.log(Level.INFO,"=== After Interest ===");
        savingsAccount.displayBalance();
    }
}