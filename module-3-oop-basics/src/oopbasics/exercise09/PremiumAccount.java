package oopbasics.exercise09;

import oopbasics.exercise03.CheckingAccount;
import oopbasics.exercise08.OnlineService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PremiumAccount extends CheckingAccount implements OnlineService {
    private static final Logger logger = Logger.getLogger(PremiumAccount.class.getName());
    private double rewardPoints;

    public PremiumAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, overdraftLimit);
        this.rewardPoints = 0.0;
        setDailyTransferLimit(10000.0);
    }

    public double calculateMonthlyFee() {
        return 1.00;
    }

    @Override
    public boolean withdraw(double amount) {
        boolean success = super.withdraw(amount);
        if (success) {
            rewardPoints += amount / 10.0;
            logger.log(Level.INFO, "Earned {0} reward points", String.format("%.2f", amount / 10.0));
        }
        return success;
    }

    public void redeemRewards(double pointsToRedeem) {
        if (pointsToRedeem > rewardPoints) {
            logger.log(Level.WARNING, "Insufficient reward points");
            return;
        }
        double cashValue = pointsToRedeem / 100.0;
        rewardPoints -= pointsToRedeem;
        deposit(cashValue);
        logger.log(Level.INFO, "Redeemed {0} points for ${1}", 
            new Object[]{String.format("%.2f", pointsToRedeem), String.format("%.2f", cashValue)});
    }

    public double getRewardPoints() {
        return rewardPoints;
    }

    @Override
    public void displayAccountType() {
        logger.log(Level.INFO, "This is a Premium Account");
    }

    @Override
    public boolean payBill(String billType, double amount) {
        recordBillPayment(billType, amount);
        logger.log(Level.INFO, "Bill payment successful: {0} - ${1}", 
            new Object[]{billType, String.format("%.2f", amount)});
        return true;
    }

    @Override
    public void generateStatement() {
        logger.log(Level.INFO, "\n=== Premium Account Statement ===");
        logger.log(Level.INFO, "Account: {0}", getAccountNumber());
        logger.log(Level.INFO, "Holder: {0}", getAccountHolder());
        logger.log(Level.INFO, "Balance: ${0}", String.format("%.2f", getBalance()));
        logger.log(Level.INFO, "Reward Points: {0}", String.format("%.2f", rewardPoints));
        displayTransactionHistory();
    }

//    @Override
//    public void displayLastTransactions(int count) {
//        int total = getTransactionCount();
//        logger.log(Level.INFO, "\n=== Last {0} Transactions ===", Math.min(count, total));
//    }
}
