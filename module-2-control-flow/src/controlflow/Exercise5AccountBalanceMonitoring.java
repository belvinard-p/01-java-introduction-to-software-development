package controlflow;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise5AccountBalanceMonitoring {

    private static final Logger logger =
            Logger.getLogger(Exercise5AccountBalanceMonitoring.class.getName());

    public static void main(String[] args) {
        int accountBalance = 50_000;
        int deduction = 5_000;

        accountBalanceMonitoring(accountBalance, deduction);
    }

    private static void accountBalanceMonitoring(int accountBalance, int deduction) {
        while (accountBalance > 0) {
            accountBalance -= deduction;

            if (accountBalance < 0) {
                accountBalance = 0;
            }

            logger.log(Level.INFO,
                    "Account balance after deduction: {0}", accountBalance);
        }
    }
}
