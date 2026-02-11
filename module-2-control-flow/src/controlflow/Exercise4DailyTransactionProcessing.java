package controlflow;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise4DailyTransactionProcessing {

    private static final Logger logger =
            Logger.getLogger(Exercise4DailyTransactionProcessing.class.getName());

    public static void main(String[] args) {
        logger.info("Processing daily transactions...");
        dailyTransactionProcessing(10);
    }

    private static void dailyTransactionProcessing(int transactionCount) {
        for (int i = 0; i < transactionCount; i++) {
            // Using i+1 to display human-readable transaction numbers (starting from 1 instead of 0)
            logger.log(Level.INFO, "Processing transaction #{0}", i + 1);
        }
    }
}
