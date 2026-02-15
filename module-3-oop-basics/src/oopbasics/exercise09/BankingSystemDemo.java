package oopbasics.exercise09;

import oopbasics.exercise01.BankAccount;
import oopbasics.exercise02.SavingsAccount;
import oopbasics.exercise03.CheckingAccount;
import oopbasics.exercise08.OnlineCheckingAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BankingSystemDemo {
    private static final Logger logger = Logger.getLogger(BankingSystemDemo.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "=== BANKING SYSTEM DEMO ===\n");

        BankAccount[] accounts = new BankAccount[5];
        accounts[0] = new SavingsAccount("SA001", "John Doe", 2000.0, 0.03);
        accounts[1] = new CheckingAccount("CA002", "Jane Smith", 3000.0, 500.0);
        accounts[2] = new PremiumAccount("PA003", "Bob Johnson", 5000.0, 1000.0);
        accounts[3] = new OnlineCheckingAccount("CA004", "Alice Brown", 1500.0, 300.0);
        accounts[4] = new SavingsAccount("SA005", "Charlie Wilson", 1000.0, 0.025);

        logger.log(Level.INFO, "Account Types Created:");
        logger.log(Level.INFO, "- Savings Account: {0} ({1})", 
            new Object[]{accounts[0].getAccountNumber(), accounts[0].getAccountHolder()});
        logger.log(Level.INFO, "- Checking Account: {0} ({1})", 
            new Object[]{accounts[1].getAccountNumber(), accounts[1].getAccountHolder()});
        logger.log(Level.INFO, "- Premium Account: {0} ({1})", 
            new Object[]{accounts[2].getAccountNumber(), accounts[2].getAccountHolder()});

        logger.log(Level.INFO, "\n=== Daily Operations Simulation ===");
        simulateDay(accounts);

        // Display transaction histories
        logger.log(Level.INFO, "\n=== Transaction Histories ===");
        for (BankAccount account : accounts) {
            if (account != null) {
                account.displayTransactionHistory();
                logger.log(Level.INFO, "");
            }
        }

        logger.log(Level.INFO, "\n=== System Report ===");
        generateSystemReport(accounts);

        logger.log(Level.INFO, "\n=== OOP Concepts Demonstrated ===");
        logger.log(Level.INFO, "✅ Classes & Objects: Multiple account instances");
        logger.log(Level.INFO, "✅ Inheritance: 3-level hierarchy (BankAccount → CheckingAccount → PremiumAccount)");
        logger.log(Level.INFO, "✅ Polymorphism: Method overriding in action");
        logger.log(Level.INFO, "✅ Method Overloading: Transfer service with multiple signatures");
        logger.log(Level.INFO, "✅ Encapsulation: All attributes private with controlled access");
        logger.log(Level.INFO, "✅ Abstraction: BankAccount as abstract template");
        logger.log(Level.INFO, "✅ Interfaces: OnlineService contract implementation");
        logger.log(Level.INFO, "✅ Static Methods: TransferService utility operations");
    }

    public static void simulateDay(BankAccount[] accounts) {
        logger.log(Level.INFO, "Processing deposits...");
        accounts[0].deposit(500.0);
        accounts[1].deposit(1000.0);
        accounts[2].deposit(2000.0);

        logger.log(Level.INFO, "Processing withdrawals...");
        accounts[0].withdraw(200.0);
        accounts[1].withdraw(500.0);
        accounts[2].withdraw(1000.0);

        logger.log(Level.INFO, "Processing transfers...");
        EnhancedTransferService.transfer(accounts[0], accounts[1], 300.0, "Payment");
        EnhancedTransferService.transfer(accounts[2], accounts[3], 500.0, 10.0, "Transfer with fee");

        logger.log(Level.INFO, "Processing bill payments...");
        if (accounts[2] instanceof PremiumAccount) {
            ((PremiumAccount) accounts[2]).payBill("Electricity", 150.0);
        }
        if (accounts[3] instanceof OnlineCheckingAccount) {
            ((OnlineCheckingAccount) accounts[3]).payBill("Internet", 80.0);
        }

        logger.log(Level.INFO, "Processing interest...");
        if (accounts[0] instanceof SavingsAccount) {
            ((SavingsAccount) accounts[0]).applyInterest();
        }
        if (accounts[4] instanceof SavingsAccount) {
            ((SavingsAccount) accounts[4]).applyInterest();
        }

        logger.log(Level.INFO, "Processing fees...");
        accounts[1].recordFee(5.0);

        logger.log(Level.INFO, "Processing reward redemptions...");
        if (accounts[2] instanceof PremiumAccount) {
            PremiumAccount premium = (PremiumAccount) accounts[2];
            if (premium.getRewardPoints() >= 100) {
                premium.redeemRewards(100.0);
            }
        }

        logger.log(Level.INFO, "Testing bulk transfer...");
        BankAccount[] destinations = {accounts[3], accounts[4]};
        double[] amounts = {100.0, 150.0};
        EnhancedTransferService.bulkTransfer(accounts[1], destinations, amounts);
    }

    public static void generateSystemReport(BankAccount[] accounts) {
        int totalAccounts = 0;
        double totalBalance = calculateTotalSystemBalance(accounts);
        int totalTransactions = 0;
        int savingsCount = 0, checkingCount = 0, premiumCount = 0;
        double savingsBalance = 0, checkingBalance = 0, premiumBalance = 0;

        for (BankAccount account : accounts) {
            if (account != null) {
                totalAccounts++;
                totalTransactions += account.getTransactionCount();

                if (account instanceof PremiumAccount) {
                    premiumCount++;
                    premiumBalance += account.getBalance();
                } else if (account instanceof CheckingAccount) {
                    checkingCount++;
                    checkingBalance += account.getBalance();
                } else if (account instanceof SavingsAccount) {
                    savingsCount++;
                    savingsBalance += account.getBalance();
                }
            }
        }

        logger.log(Level.INFO, "Total Accounts: {0}", totalAccounts);
        logger.log(Level.INFO, "Total System Balance: ${0}", String.format("%.2f", totalBalance));
        logger.log(Level.INFO, "Total Transactions Today: {0}", totalTransactions);
        logger.log(Level.INFO, "Account Type Distribution:");
        logger.log(Level.INFO, "- Savings: {0} account(s) (${1})", 
            new Object[]{savingsCount, String.format("%.2f", savingsBalance)});
        logger.log(Level.INFO, "- Checking: {0} account(s) (${1})", 
            new Object[]{checkingCount, String.format("%.2f", checkingBalance)});
        logger.log(Level.INFO, "- Premium: {0} account(s) (${1})", 
            new Object[]{premiumCount, String.format("%.2f", premiumBalance)});

        logger.log(Level.INFO, "\nMonthly Fees Due:");
        logger.log(Level.INFO, "- Savings: $2.00");
        logger.log(Level.INFO, "- Checking: $5.00");
        logger.log(Level.INFO, "- Premium: $1.00");
        double totalFees = (savingsCount * 2.0) + (checkingCount * 5.0) + (premiumCount * 1.0);
        logger.log(Level.INFO, "Total Monthly Fees: ${0}", String.format("%.2f", totalFees));
    }

    public static double calculateTotalSystemBalance(BankAccount[] accounts) {
        double total = 0.0;
        for (BankAccount account : accounts) {
            if (account != null) {
                total += account.getBalance();
            }
        }
        return total;
    }
}
