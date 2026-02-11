package controlflow;

import java.util.logging.Logger;

public class Exercise3TransactionTypeProcessing {

    private static final Logger logger =
            Logger.getLogger(Exercise3TransactionTypeProcessing.class.getName());

    public static void main(String[] args) {

        String transactionType = "DEPOSIT";

        processTransaction(transactionType);
    }

    private static void processTransaction(String transactionType) {

        switch (transactionType) {
            case "DEPOSIT":
                logger.info("Processing deposit transaction");
                break;

            case "WITHDRAWAL":
                logger.info("Processing withdrawal transaction");
                break;

            case "TRANSFER":
                logger.info("Processing transfer transaction");
                break;

            case "BALANCE_INQUIRY":
                logger.info("Processing balance inquiry");
                break;

            default:
                logger.info("Unknown transaction type");
        }
    }
}
