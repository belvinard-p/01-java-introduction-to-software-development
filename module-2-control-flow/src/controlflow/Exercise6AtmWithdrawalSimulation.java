package controlflow;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise6AtmWithdrawalSimulation {
    private static final Logger logger = Logger.getLogger(Exercise6AtmWithdrawalSimulation.class.getName());

    public static void main(String[] args) {
        int accountBalance = 50_000;
        int withdrawalAmount = 5_000;

        atmWithdrawalSimulation(accountBalance, withdrawalAmount);
    }

    private static void atmWithdrawalSimulation(int accountBalance, int withdrawalAmount) {
        do {
            if (accountBalance < withdrawalAmount) {
                logger.log(Level.INFO, "Insufficient funds");
                break;
            }

            accountBalance -= withdrawalAmount;
            logger.log(Level.INFO, "Withdrawal successful. Remaining balance: {0}" + accountBalance);

        } while (accountBalance >= withdrawalAmount);
    }
}
