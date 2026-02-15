package oopbasics.exercise07;

import oopbasics.exercise01.BankAccount;
import oopbasics.exercise02.SavingsAccount;
import oopbasics.exercise03.CheckingAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TransferDemo {
    private static final Logger logger = Logger.getLogger(TransferDemo.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "=== Exercise 7: Transfer System Demo ===\n");

        SavingsAccount johnSavings = new SavingsAccount("SA001", "John", 2000.0, 0.03);
        CheckingAccount janeChecking = new CheckingAccount("CA001", "Jane", 2000.0, 500.0);

        logger.log(Level.INFO, "--- Initial Balances ---");
        displayAccountInfo(johnSavings);
        displayAccountInfo(janeChecking);

        logger.log(Level.INFO, "\n--- Test 1: Simple Transfer ---");
        TransferService.transfer(johnSavings, janeChecking, 500.0);
        displayAccountInfo(johnSavings);
        displayAccountInfo(janeChecking);

        logger.log(Level.INFO, "\n--- Test 2: Transfer with Description ---");
        TransferService.transfer(janeChecking, johnSavings, 300.0, "Loan repayment");
        displayAccountInfo(johnSavings);
        displayAccountInfo(janeChecking);

        logger.log(Level.INFO, "\n--- Test 3: Transfer with Fee ---");
        TransferService.transferWithFee(johnSavings, janeChecking, 200.0, 5.0);
        displayAccountInfo(johnSavings);
        displayAccountInfo(janeChecking);

        logger.log(Level.INFO, "\n--- Test 4: Daily Transfer Limit ---");
        logger.log(Level.INFO, "Attempting to transfer $600 (limit: $1000, already transferred: ${0})",
            String.format("%.2f", johnSavings.getTransferredToday()));
        TransferService.transfer(johnSavings, janeChecking, 600.0);

        logger.log(Level.INFO, "\n--- Test 5: Exceeding Daily Limit ---");
        logger.log(Level.INFO, "Attempting to transfer $400 (would exceed daily limit)");
        TransferService.transfer(johnSavings, janeChecking, 400.0);

        logger.log(Level.INFO, "\n--- Final Balances ---");
        displayAccountInfo(johnSavings);
        displayAccountInfo(janeChecking);
    }

    private static void displayAccountInfo(BankAccount account) {
        logger.log(Level.INFO, "{0}''s Account - Balance: ${1} | Transferred today: ${2} | Daily limit: ${3}",
            new Object[]{
                account.getAccountHolder(),
                String.format("%.2f", account.getBalance()),
                String.format("%.2f", account.getTransferredToday()),
                String.format("%.2f", account.getDailyTransferLimit())
            });
    }
}
