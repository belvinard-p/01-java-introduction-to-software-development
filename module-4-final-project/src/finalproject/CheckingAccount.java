package finalproject;

public class CheckingAccount extends Account implements Transferable {
    private double overdraftLimit;
    private double overdraftFee;
    private double dailyTransferLimit;
    private double transferredToday;

    public CheckingAccount(String accountNumber, Customer accountHolder, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = 35.0;
        this.dailyTransferLimit = 5000.0;
        this.transferredToday = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        setBalance(getBalance() + amount);
        addTransaction(String.format("DEPOSIT: +$%.2f", amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (amount > getAvailableBalance()) {
            return false;
        }
        setBalance(getBalance() - amount);
        addTransaction(String.format("WITHDRAWAL: -$%.2f", amount));
        
        if (getBalance() < 0 && overdraftFee > 0) {
            setBalance(getBalance() - overdraftFee);
            addTransaction(String.format("OVERDRAFT FEE: -$%.2f", overdraftFee));
        }
        return true;
    }

    public boolean hasOverdraftProtection() {
        return overdraftLimit > 0;
    }

    public double getAvailableBalance() {
        return getBalance() + overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = limit;
    }

    @Override
    public boolean transferTo(Account destination, double amount) {
        if (!canTransfer(amount)) {
            return false;
        }
        if (withdraw(amount)) {
            destination.deposit(amount);
            transferredToday += amount;
            addTransaction(String.format("TRANSFER OUT: -$%.2f to %s", amount, destination.getAccountNumber()));
            return true;
        }
        return false;
    }

    @Override
    public boolean canTransfer(double amount) {
        if (transferredToday + amount > dailyTransferLimit) {
            return false;
        }
        if (getAvailableBalance() < amount) {
            return false;
        }
        return true;
    }

    @Override
    public double getDailyTransferLimit() {
        return dailyTransferLimit;
    }

    @Override
    public void setDailyTransferLimit(double limit) {
        this.dailyTransferLimit = limit;
    }
}
