package oopbasics.exercise03;

import oopbasics.exercise01.BankAccount;
import oopbasics.exercise02.SavingsAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        
        accounts[0] = new SavingsAccount("SA001", "Yaya", 100.0, 0.05);
        accounts[1] = new CheckingAccount("CA001", "Oumarou", 100.0, 200.0);

        logger.log(Level.INFO, "=== Polymorphism Demo: Withdrawing $150 from each account ===");

        for (BankAccount account : accounts) {
            logger.log(Level.INFO, "Before withdrawal:");
            account.displayBalance();
            
            boolean success = account.withdraw(1050);
            logger.log(Level.INFO, "Withdrawal {0}", success ? "successful" : "failed");
            
            logger.log(Level.INFO, "After withdrawal:");
            account.displayBalance();
        }
    }
}
