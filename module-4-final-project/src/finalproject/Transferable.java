package finalproject;

public interface Transferable {
    boolean transferTo(Account destination, double amount);
    void setDailyTransferLimit(double limit);
    double getDailyTransferLimit();
    boolean canTransfer(double amount);
}
