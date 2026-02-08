package gettingstarted;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise1AccountBalance {

    private static final Logger logger =
            Logger.getLogger(Exercise1AccountBalance.class.getName());

    public static void main(String[] args) {

        int accountBalance = 100_000;
        int deposit = 50_000;
        int withdraw = 20_000;

        int balanceAfterDeposit = accountBalance + deposit;
        int balanceAfterWithdrawal = balanceAfterDeposit - withdraw;

        logger.log(Level.INFO, "Initial account balance: {0}", accountBalance);
        logger.log(Level.INFO, "Balance after deposit: {0}", balanceAfterDeposit);
        logger.log(Level.INFO, "Balance after withdrawal: {0}", balanceAfterWithdrawal);
    }
}
