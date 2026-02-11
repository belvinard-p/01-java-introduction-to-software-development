package controlflow;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise2LoanEligibilityCheck {

    private static final Logger logger =
            Logger.getLogger(Exercise2LoanEligibilityCheck.class.getName());

    public static void main(String[] args) {

        double monthlyIncome = 100_000;
        int creditScore = 800;

        checkLoanEligibility(monthlyIncome, creditScore);
    }

    private static void checkLoanEligibility(double monthlyIncome, int creditScore) {

        if (monthlyIncome >= 500_000 && creditScore >= 700) {
            logger.log(Level.INFO, "Loan approved");
        } else if (monthlyIncome >= 300_000 && creditScore >= 600) {
            logger.log(Level.INFO, "Loan conditionally approved");
        } else {
            logger.log(Level.INFO, "Loan rejected");
        }
    }
}
