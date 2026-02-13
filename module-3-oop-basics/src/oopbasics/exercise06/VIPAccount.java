package oopbasics.exercise06;

import oopbasics.exercise03.CheckingAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VIPAccount extends CheckingAccount implements CreditEligible, Notifiable {
    private static final Logger logger = Logger.getLogger(VIPAccount.class.getName());

    public VIPAccount(String accountNumber, String accountHolder,
                      double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, overdraftLimit);
    }

    @Override
    public void displayAccountType() {

        logger.log(Level.INFO, "This is a VIP Account");
    }

    @Override
    public boolean checkCreditEligibility() {

        return getBalance() > -getOverdraftLimit() * 0.3;
    }

    @Override
    public void sendAlert(String message) {

        logger.log(Level.INFO, "VIP Alert: {0}", message);
    }
}
