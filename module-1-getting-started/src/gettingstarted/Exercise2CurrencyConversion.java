package gettingstarted;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise2CurrencyConversion {
   private static final Logger logger =
            Logger.getLogger(Exercise2CurrencyConversion.class.getName());

    public static void main(String[] args) {
        double amountInUSD = 1_000.0;
        double usdToEurRate = 0.85;
        double amountInEUR = amountInUSD * usdToEurRate;

        double expenseInEUR = 50.0;
        double remainingBalanceInEUR = amountInEUR - expenseInEUR;

        double remainingBalanceInUSD = remainingBalanceInEUR / usdToEurRate;

        logger.log(Level.INFO, "Initial amount in USD $ : {0}", amountInUSD);
        logger.log(Level.INFO, "Final amount in Euro € : {0}", amountInEUR);
        logger.log(Level.INFO, "Remaining balance after expense: € {0}", remainingBalanceInEUR);
        logger.log(Level.INFO, "Remaining balance in USD: $ {0}", remainingBalanceInUSD);


    }
}
