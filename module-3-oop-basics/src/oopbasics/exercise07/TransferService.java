package oopbasics.exercise07;

import oopbasics.exercise01.BankAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TransferService {
    private static final Logger logger = Logger.getLogger(TransferService.class.getName());

    public static boolean transfer(BankAccount from, BankAccount to, double amount) {
        return transfer(from, to, amount, null);
    }

    public static boolean transfer(BankAccount from, BankAccount to, double amount, String description) {
        if (!from.canTransfer(amount)) {
            logger.log(Level.WARNING, "Transfer failed: Daily transfer limit exceeded");
            return false;
        }

        if (!from.withdraw(amount)) {
            return false;
        }

        to.deposit(amount);
        from.addToTransferredToday(amount);

        if (description != null) {
            logger.log(Level.INFO, "Transfer: ${0} from {1}''s to {2}''s", 
                new Object[]{String.format("%.2f", amount), from.getAccountHolder(), to.getAccountHolder()});
            logger.log(Level.INFO, "Description: {0}", description);
        }

        logger.log(Level.INFO, "Transfer successful!");
        return true;
    }

    public static boolean transferWithFee(BankAccount from, BankAccount to, double amount, double fee) {
        double totalAmount = amount + fee;

        if (!from.canTransfer(totalAmount)) {
            logger.log(Level.WARNING, "Transfer failed: Daily transfer limit exceeded");
            return false;
        }

        if (!from.withdraw(totalAmount)) {
            return false;
        }

        to.deposit(amount);
        from.addToTransferredToday(totalAmount);

        logger.log(Level.INFO, "Transfer with fee successful! Amount: ${0}, Fee: ${1}", 
            new Object[]{String.format("%.2f", amount), String.format("%.2f", fee)});
        return true;
    }
}
