package oopbasics.exercise09;

import oopbasics.exercise01.BankAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EnhancedTransferService {
    private static final Logger logger = Logger.getLogger(EnhancedTransferService.class.getName());

    public static boolean transfer(BankAccount from, BankAccount to, double amount) {
        return transfer(from, to, amount, null);
    }

    public static boolean transfer(BankAccount from, BankAccount to, double amount, String description) {
        return transfer(from, to, amount, 0.0, description);
    }

    public static boolean transfer(BankAccount from, BankAccount to, double amount, double fee, String description) {
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

        from.recordTransferOut(amount, to.getAccountNumber());
        to.recordTransferIn(amount, from.getAccountNumber());

        if (fee > 0) {
            from.recordFee(fee);
        }

        if (description != null) {
            logger.log(Level.INFO, "Transfer: ${0} from {1} to {2} - {3}", 
                new Object[]{String.format("%.2f", amount), from.getAccountHolder(), 
                to.getAccountHolder(), description});
        }

        logger.log(Level.INFO, "Transfer successful!");
        return true;
    }

    public static boolean bulkTransfer(BankAccount source, BankAccount[] destinations, double[] amounts) {
        if (destinations.length != amounts.length) {
            logger.log(Level.WARNING, "Bulk transfer failed: Array length mismatch");
            return false;
        }

        double totalAmount = 0;
        for (double amount : amounts) {
            totalAmount += amount;
        }

        if (!source.canTransfer(totalAmount)) {
            logger.log(Level.WARNING, "Bulk transfer failed: Daily transfer limit exceeded");
            return false;
        }

        if (source.getBalance() < totalAmount) {
            logger.log(Level.WARNING, "Bulk transfer failed: Insufficient funds");
            return false;
        }

        for (int i = 0; i < destinations.length; i++) {
            transfer(source, destinations[i], amounts[i]);
        }

        logger.log(Level.INFO, "Bulk transfer completed: {0} transfers, total ${1}", 
            new Object[]{destinations.length, String.format("%.2f", totalAmount)});
        return true;
    }
}
