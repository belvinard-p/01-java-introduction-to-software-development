package controlflow;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise1AccountStatusValidation {
    private static final Logger logger = Logger.getLogger(Exercise1AccountStatusValidation.class.getName());
    public static void main(String[] args) {
        int accountBalance = 200_000;

        if (accountBalance > 100_000) {
            logger.log(Level.INFO, "Account status: VIP");
        } else if (accountBalance >= 10_000 && accountBalance <= 100_000) {
            logger.log(Level.INFO, "Account status: Active" );

        }else if (accountBalance >= 1  && accountBalance <= 9_999) {
            logger.log(Level.INFO, "Account status: Low balance" );

        } else if (accountBalance == 0) {
            logger.log(Level.INFO, "Account status: Empty account");
        }else{
            logger.log(Level.INFO, "Account status: Overdraft");
        }
    }

}
