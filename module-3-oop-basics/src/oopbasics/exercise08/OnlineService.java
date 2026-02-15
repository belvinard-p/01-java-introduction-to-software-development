package oopbasics.exercise08;

public interface OnlineService {
    boolean payBill(String billType, double amount);
    void generateStatement();
}
