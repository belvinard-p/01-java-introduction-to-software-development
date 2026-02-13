package oopbasics.exercise06;

import oopbasics.exercise02.SavingsAccount;
import oopbasics.exercise03.CheckingAccount;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfaceDemo {
    private static final Logger logger = Logger.getLogger(InterfaceDemo.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "=== Exercise 6: Interfaces Demo ===\n");

        logger.log(Level.INFO, "--- CheckingAccount as CreditEligible ---");
        CheckingAccount checking = new CheckingAccount("CA001", "Bob", 1000.0, 500.0);
        CreditEligible creditCheck = checking;
        boolean eligible = creditCheck.checkCreditEligibility();
        logger.log(Level.INFO, "Credit Eligible: {0}\n", eligible);

        logger.log(Level.INFO, "--- SavingsAccount as Notifiable ---");
        SavingsAccount savings = new SavingsAccount("SA001", "Alice", 5000.0, 0.03);
        Notifiable notifiable = savings;
        notifiable.sendAlert("Interest rate changed");

        logger.log(Level.INFO, "\n--- VIPAccount (Challenge) ---");
        VIPAccount vip = new VIPAccount("VIP001", "Charlie", 10000.0, 2000.0);
        
        vip.displayAccountType();
        
        CreditEligible vipCredit = vip;
        logger.log(Level.INFO, "VIP Credit Eligible: {0}", vipCredit.checkCreditEligibility());
        
        Notifiable vipNotify = vip;
        vipNotify.sendAlert("Exclusive offer available");

        logger.log(Level.INFO, "\n--- Interface Polymorphism ---");
        CreditEligible[] creditAccounts = {checking, vip};
        for (CreditEligible account : creditAccounts) {
            logger.log(Level.INFO, "Checking eligibility: {0}", account.checkCreditEligibility());
        }

        Notifiable[] notifiableAccounts = {savings, vip};
        for (Notifiable account : notifiableAccounts) {
            account.sendAlert("System maintenance scheduled");
        }
    }
}
