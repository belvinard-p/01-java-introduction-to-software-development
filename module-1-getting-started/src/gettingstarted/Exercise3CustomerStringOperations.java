package gettingstarted;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise3CustomerStringOperations {
    private static final Logger
            logger = Logger.getLogger(Exercise3CustomerStringOperations.class.getName());
    public static void main(String[] args) {
        String customerName = "James Peter";

        int customerNameLength = customerName.length();
        String firstName = customerName.substring(0, customerName.indexOf(" "));
        String updatedName = customerName.replace('a', '@');

        logger.log(Level.INFO, "Customer name length: {0}", customerNameLength);
        logger.log(Level.INFO, "First character: {0}", customerName.charAt(0));
        logger.log(Level.INFO, "Customer first name: {0}", firstName);
        logger.log(Level.INFO, "Contains 'Jam': {0}", customerName.contains("Jam"));
        logger.log(Level.INFO, "Lower case name: {0}", customerName.toLowerCase());
        logger.log(Level.INFO, "Upper case name: {0}", customerName.toUpperCase());
        logger.log(Level.INFO, "Updated customer name: {0}", updatedName);


    }
}
