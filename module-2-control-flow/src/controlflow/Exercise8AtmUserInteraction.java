package controlflow;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise8AtmUserInteraction {
    private static final Logger logger = Logger.getLogger(Exercise8AtmUserInteraction.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double accountBalance = scanner.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();

        interactionUserAtm(accountBalance, withdrawalAmount);

        scanner.close();

    }

    private static void interactionUserAtm(double accountBalance, double withdrawalAmount) {
        if (withdrawalAmount > accountBalance) {
            logger.log(Level.INFO, "Transaction denied: insufficient funds");
        } else if (withdrawalAmount <= 0) {
            logger.log(Level.INFO, "Invalid withdrawal amount");
        }else {
            accountBalance -= withdrawalAmount;
            logger.log(Level.INFO, "Transaction successful" );
            logger.log(Level.INFO, "Remaining balance: {0} ", accountBalance);
        }

    }
}
