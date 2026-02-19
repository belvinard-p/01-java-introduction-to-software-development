package finalproject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {
    private final Logger logger
            = Logger.getLogger(Customer.class.getName());
    
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
    public Customer(String customerId, String firstName, String lastName, 
                    String email, String phoneNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void displayCustomerInfo(){
        logger.log(Level.INFO,"Customer ID: {0}\nFull Name: {1}\nEmail Address: {2}\nPhone Number: {3}",
                new Object[]{customerId, getFullName(), email, phoneNumber});
    }
}
