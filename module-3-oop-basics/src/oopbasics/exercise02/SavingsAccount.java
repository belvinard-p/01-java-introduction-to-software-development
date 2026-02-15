package oopbasics.exercise02;

import oopbasics.exercise01.BankAccount;
import oopbasics.exercise06.Notifiable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SavingsAccount extends BankAccount implements Notifiable {
    private static final Logger logger = Logger.getLogger(SavingsAccount.class.getName());
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder,
                          double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        setDailyTransferLimit(1000.0);
    }

    @Override
    public void displayBalance() {
        super.displayBalance();
        logger.log(Level.INFO, "Interest rate: " + (interestRate * 100) + "%");
    }

    @Override
    public void displayAccountType() {
        logger.log(Level.INFO, "This is a Savings Account");
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        recordInterest(interest);
        logger.log(Level.INFO, "Interest applied: " + interest);
    }

    @Override
    public void sendAlert(String message) {
        logger.log(Level.INFO, "Savings Alert: {0}", message);
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