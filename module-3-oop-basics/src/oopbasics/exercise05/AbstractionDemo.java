package oopbasics.exercise05;

import oopbasics.exercise01.BankAccount;
import oopbasics.exercise02.SavingsAccount;
import oopbasics.exercise03.CheckingAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractionDemo {
    private static final Logger logger = Logger.getLogger(AbstractionDemo.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "=== Exercise 5: Abstraction Demo ===");

        // This will NOT compile - BankAccount is abstract
        // BankAccount account = new BankAccount("123", "John", 1000.0);

        SavingsAccount savings = new SavingsAccount("SA001", "Alice", 5000.0, 0.03);
        CheckingAccount checking = new CheckingAccount("CA001", "Bob", 3000.0, 500.0);

        logger.log(Level.INFO, "\n--- Savings Account ---");
        savings.displayAccountType();
        savings.displayBalance();

        logger.log(Level.INFO, "\n--- Checking Account ---");
        checking.displayAccountType();
        checking.displayBalance();

        logger.log(Level.INFO, "\n--- Polymorphism with Abstract Class ---");
        BankAccount[] accounts = {savings, checking};
        for (BankAccount account : accounts) {
            account.displayAccountType();
        }
    }
}
