package oopbasics.exercise08;

import oopbasics.exercise03.CheckingAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineCheckingAccount extends CheckingAccount implements OnlineService {
    private static final Logger logger = Logger.getLogger(OnlineCheckingAccount.class.getName());

    public OnlineCheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, overdraftLimit);
    }

    @Override
    public boolean payBill(String billType, double amount) {
        if (amount <= 0) {
            logger.log(Level.WARNING, "Bill payment failed: Invalid amount");
            return false;
        }
        recordBillPayment(billType, amount);
        logger.log(Level.INFO, "Bill payment successful: {0} - ${1}", 
            new Object[]{billType, String.format("%.2f", amount)});
        return true;
    }

    @Override
    public void generateStatement() {
        logger.log(Level.INFO, "\\n=== Account Statement ===");
        logger.log(Level.INFO, "Account: {0}", getAccountNumber());
        logger.log(Level.INFO, "Holder: {0}", getAccountHolder());
        logger.log(Level.INFO, "Current Balance: ${0}", String.format("%.2f", getBalance()));
        displayTransactionHistory();
    }

//    @Override
//    public void displayLastTransactions(int count) {
//        int total = getTransactionCount();
//        int startIndex = Math.max(0, total - count);
//
//        logger.log(Level.INFO, "\\n=== Last {0} Transactions ===", Math.min(count, total));
//        for (int i = startIndex; i < total; i++) {
//            logger.log(Level.INFO, "{0}. {1}", new Object[]{i - startIndex + 1, getTransaction(i)});
//        }
//    }

}
