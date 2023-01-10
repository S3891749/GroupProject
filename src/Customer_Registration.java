import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer_Registration {
    protected String username;
    protected String password;
    protected String fullName;
    protected String phoneNumber;
    protected String Email;
    protected String Address;

    public Customer_Registration(String username, String password, String fullName, String phoneNumber, String email, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.Email = email;
        this.Address = address;
    }
    public void AddCustomer(){

    }

    @Override
    public String toString() {
        return "Customer_Registration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
