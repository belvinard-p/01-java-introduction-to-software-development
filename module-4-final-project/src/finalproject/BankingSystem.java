package finalproject;

import java.util.Scanner;

public class BankingSystem {
    private static Account[] accounts = new Account[50];
    private static Customer[] customers = new Customer[50];

    private static int accountCount = 0;
    private static int customerCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice;

        do {
            System.out.println("\n═══════════════════════════════════");
            System.out.println("        BANKING SYSTEM MENU        ");
            System.out.println("═══════════════════════════════════");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. View Account Details");
            System.out.println("7. View All Accounts");
            System.out.println("0. Exit");
            System.out.println("═══════════════════════════════════");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performWithdrawal();
                    break;
                case 5:
                    performTransfer();
                    break;
                case 6:
                    viewAccountDetails();
                    break;
                case 7:
                    viewAllAccounts();
                    break;
                case 0:
                    System.out.println("👋 Thank you for using Banking System!");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        } while(choice != 0);
    }

    public static void createCustomer() {
        System.out.println("\n📝 CREATE NEW CUSTOMER");
        System.out.println("──────────────────────");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            System.out.println("❌ Error: All fields are required!");
            return;
        }

        String customerId = generateCustomerId();

        Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber);
        customers[customerCount] = customer;
        customerCount++;

        System.out.println("✅ Customer created successfully!");
        System.out.println("   Customer ID: " + customerId);
    }

    public static void createAccount() {
        System.out.println("\n🏦 CREATE NEW ACCOUNT");
        System.out.println("─────────────────────");

        // Check if customers exist
        if(customerCount == 0) {
            System.out.println("❌ No customers found. Please create a customer first.");
            return;
        }

        // Display customer list
        System.out.println("\n📋 Select a customer:");
        for(int i = 0; i < customerCount; i++) {
            System.out.println((i+1) + ". " + customers[i].getFullName() +
                    " (ID: " + customers[i].getCustomerId() + ")");
        }

        // Get customer selection
        System.out.print("Enter customer number: ");
        int customerChoice = scanner.nextInt();
        scanner.nextLine();

        if(customerChoice < 1 || customerChoice > customerCount) {
            System.out.println("❌ Invalid customer selection!");
            return;
        }

        Customer selectedCustomer = customers[customerChoice - 1];

        // Select account type
        System.out.println("\n📊 Account Types:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.print("Choose account type: ");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        // Get initial balance
        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        // Validate balance
        if(!validateAmount(initialBalance)) {
            System.out.println("❌ Initial balance must be greater than 0!");
            return;
        }

        String accountNumber = generateAccountNumber();

        Account account;
        switch(accountType) {
            case 1:
                System.out.print("Enter interest rate (e.g., 0.03 for 3%): ");
                double interestRate = scanner.nextDouble();
                scanner.nextLine();
                account = new SavingsAccount(accountNumber, selectedCustomer, initialBalance, interestRate);
                break;
            case 2:
                System.out.print("Enter overdraft limit: $");
                double overdraftLimit = scanner.nextDouble();
                scanner.nextLine();
                account = new CheckingAccount(accountNumber, selectedCustomer, initialBalance, overdraftLimit);
                break;
            default:
                System.out.println("❌ Invalid account type!");
                return;
        }

        accounts[accountCount] = account;
        accountCount++;

        System.out.println("✅ Account created successfully!");
        System.out.println("   Account Number: " + accountNumber);
    }

    public static void performDeposit() {
        System.out.println("\n💰 DEPOSIT");
        System.out.println("──────────");

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);

        if(account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(!validateAmount(amount)) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }

        account.deposit(amount);
        System.out.println("✅ Deposit successful!");
        System.out.printf("   New balance: $%.2f%n", account.getBalance());
    }

    public static void performWithdrawal() {
        System.out.println("\n💸 WITHDRAWAL");
        System.out.println("─────────────");

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);

        if(account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(!validateAmount(amount)) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }

        if(account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful!");
            System.out.printf("   New balance: $%.2f%n", account.getBalance());
        } else {
            System.out.println("❌ Insufficient funds!");
        }
    }

    public static void performTransfer() {
        System.out.println("\n🔄 TRANSFER");
        System.out.println("────────────");

        System.out.print("Enter source account number: ");
        String sourceNumber = scanner.nextLine();

        System.out.print("Enter destination account number: ");
        String destNumber = scanner.nextLine();

        Account sourceAccount = findAccount(sourceNumber);
        Account destAccount = findAccount(destNumber);

        if(sourceAccount == null || destAccount == null) {
            System.out.println("❌ One or both accounts not found!");
            return;
        }

        if(!(sourceAccount instanceof Transferable)) {
            System.out.println("❌ Source account does not support transfers!");
            return;
        }

        System.out.print("Enter transfer amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(!validateAmount(amount)) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }

        Transferable transferSource = (Transferable) sourceAccount;
        if(transferSource.transferTo(destAccount, amount)) {
            System.out.println("✅ Transfer successful!");
        } else {
            System.out.println("❌ Transfer failed!");
        }
    }

    public static Account findAccount(String accountNumber) {
        for(int i = 0; i < accountCount; i++) {
            if(accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public static Customer findCustomer(String customerId) {
        for(int i = 0; i < customerCount; i++) {
            if(customers[i].getCustomerId().equals(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    public static String generateAccountNumber() {
        return "ACC" + (accountCount + 1);
    }

    public static String generateCustomerId() {
        return "CUST" + (customerCount + 1);
    }

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static void viewAccountDetails() {
        System.out.println("\n📊 ACCOUNT DETAILS");
        System.out.println("────────────────");

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);

        if(account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.println("\n═══════════════════════════════════");
        account.displayBalance();
        System.out.println("───────────────────────────────────");
        account.getAccountHolder().displayCustomerInfo();
        System.out.println("───────────────────────────────────");
        account.displayTransactionHistory();
        System.out.println("═══════════════════════════════════");
    }

    public static void viewAllAccounts() {
        System.out.println("\n📋 ALL ACCOUNTS");
        System.out.println("═══════════════════════════════════");

        if(accountCount == 0) {
            System.out.println("❌ No accounts found.");
            return;
        }

        for(int i = 0; i < accountCount; i++) {
            Account acc = accounts[i];
            String accountType = acc instanceof SavingsAccount ? "Savings" : "Checking";
            System.out.printf("%d. %s | %s | %s | Balance: $%.2f%n",
                    i + 1,
                    acc.getAccountNumber(),
                    accountType,
                    acc.getAccountHolder().getFullName(),
                    acc.getBalance());
        }
        System.out.println("═══════════════════════════════════");
        System.out.println("Total Accounts: " + accountCount);
    }

}
