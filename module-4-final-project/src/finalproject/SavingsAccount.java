package finalproject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SavingsAccount extends Account implements Transferable {
    private static final Logger logger = Logger.getLogger(SavingsAccount.class.getName());
    private double interestRate;
    private int withdrawalsThisMonth;
    private static final int MAX_FREE_WITHDRAWALS = 3;
    private static final double WITHDRAWAL_FEE = 2.0;
    private double dailyTransferLimit;
    private double transferredToday;

    public SavingsAccount(String accountNumber, Customer accountHolder, 
                         double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
        this.withdrawalsThisMonth = 0;
        this.dailyTransferLimit = 1000.0;
        this.transferredToday = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            logger.log(Level.WARNING, "Deposit amount must be positive.");
            return;
        }
        setBalance(getBalance() + amount);
        addTransaction("DEPOSIT: +$" + String.format("%.2f", amount));
        logger.log(Level.INFO, "Deposit successful! New balance: ${0}", String.format("%.2f", getBalance()));
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            logger.log(Level.WARNING, "Withdrawal amount must be positive.");
            return false;
        }

        double totalAmount = amount;
        if (withdrawalsThisMonth >= MAX_FREE_WITHDRAWALS) {
            totalAmount += WITHDRAWAL_FEE;
            logger.log(Level.INFO, "Withdrawal fee applied: ${0}", String.format("%.2f", WITHDRAWAL_FEE));
        }

        if (getBalance() < totalAmount) {
            logger.log(Level.WARNING, "Insufficient funds. Available: ${0}",
                    String.format("%.2f", getBalance()));
            return false;
        }

        setBalance(getBalance() - totalAmount);
        withdrawalsThisMonth++;
        addTransaction("WITHDRAWAL: -$" + String.format("%.2f", amount));
        if (totalAmount > amount) {
            addTransaction("WITHDRAWAL FEE: -$" + String.format("%.2f", WITHDRAWAL_FEE));
        }
        logger.log(Level.INFO, "Withdrawal successful! New balance: ${0}",
                String.format("%.2f", getBalance()));
        return true;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        setBalance(getBalance() + interest);
        addTransaction("INTEREST: +$" + String.format("%.2f", interest));
        logger.log(Level.INFO, "Interest applied: ${0}", String.format("%.2f", interest));
        logger.log(Level.INFO, "New balance: ${0}", String.format("%.2f", getBalance()));
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 12;
    }

    public void resetMonthlyWithdrawals() {
        withdrawalsThisMonth = 0;
        logger.log(Level.INFO, "Monthly withdrawal counter reset.");
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getWithdrawalsThisMonth() {
        return withdrawalsThisMonth;
    }

    @Override
    public boolean transferTo(Account destination, double amount) {
        if (!canTransfer(amount)) {
            logger.log(Level.WARNING, "Transfer exceeds daily limit");
            return false;
        }
        if (withdraw(amount)) {
            destination.deposit(amount);
            transferredToday += amount;
            addTransaction(String.format("TRANSFER OUT: -$%.2f to %s", amount, destination.getAccountNumber()));
            return true;
        }
        return false;
    }

    @Override
    public boolean canTransfer(double amount) {
        return transferredToday + amount <= dailyTransferLimit;
    }

    @Override
    public double getDailyTransferLimit() {
        return dailyTransferLimit;
    }

    @Override
    public void setDailyTransferLimit(double limit) {
        this.dailyTransferLimit = limit;
    }
}
