package oopbasics.exercise08;

import oopbasics.exercise02.SavingsAccount;
import oopbasics.exercise07.TransferService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionHistoryDemo {
    private static final Logger logger = Logger.getLogger(TransactionHistoryDemo.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "=== Exercise 8: Transaction History Demo ===\\n");

        // Create accounts
        SavingsAccount savingsAccount = new SavingsAccount("SA001", "John Doe", 0.0, 0.03);
        OnlineCheckingAccount checkingAccount = new OnlineCheckingAccount("CA002", "Jane Smith", 0.0, 500.0);

        // Test deposits
        logger.log(Level.INFO, "--- Test 1: Deposits ---");
        savingsAccount.deposit(1000.0);
        checkingAccount.deposit(2000.0);

        // Test withdrawals
        logger.log(Level.INFO, "\\n--- Test 2: Withdrawals ---");
        savingsAccount.withdraw(150.0);
        checkingAccount.withdraw(200.0);

        // Test interest
        logger.log(Level.INFO, "\\n--- Test 3: Interest Application ---");
        savingsAccount.applyInterest();

        // Test transfers
        logger.log(Level.INFO, "\\n--- Test 4: Transfers ---");
        TransferService.transfer(savingsAccount, checkingAccount, 500.0, "Loan repayment");

        // Test bill payments
        logger.log(Level.INFO, "\\n--- Test 5: Bill Payments ---");
        checkingAccount.payBill("Utilities", 85.0);
        checkingAccount.payBill("Internet", 50.0);

        // Test fee recording
        logger.log(Level.INFO, "\\n--- Test 6: Fee Recording ---");
        checkingAccount.recordFee(10.0);

        // Display transaction histories
        logger.log(Level.INFO, "\\n--- Test 7: Transaction Histories ---");
        savingsAccount.displayTransactionHistory();
        logger.log(Level.INFO, "");
        checkingAccount.displayTransactionHistory();

        // Test OnlineService methods
        logger.log(Level.INFO, "\\n--- Test 8: Online Service Features ---");
        checkingAccount.generateStatement();

        // Test array bounds
        logger.log(Level.INFO, "\\n--- Test 9: Array Bounds (100 transactions) ---");
        SavingsAccount testAccount = new SavingsAccount("SA999", "Test User", 100000.0, 0.01);
        
        for (int i = 1; i <= 105; i++) {
            testAccount.deposit(10.0);
        }
        
        logger.log(Level.INFO, "Total transactions recorded: {0}", testAccount.getTransactionCount());
        logger.log(Level.INFO, "Note: Array is limited to 100 transactions. Additional transactions were not recorded.");

        logger.log(Level.INFO, "\\n=== Demo Complete ===");
    }
}
