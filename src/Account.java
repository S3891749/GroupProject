import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Account {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String Email;
    private String Address;
    private double TotalSpending = 0;
    String filename = "src/Order.txt";
    File file = new File(filename);

    public Account(String username, String password, String fullName, String phoneNumber, String email, String address) throws IOException {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        Email = email;
        Address = address;
    }
    public void CustomerAction() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose section");
        System.out.println("1. Create new Order");
        System.out.println("2. Track your Order");

        System.out.print("Choose your option: ");
        int option = scan.nextInt();
        switch(option){
            case 1:
                CreateOrder();
                break;
            case 2:
                TrackOrder();
                break;

        }
    }


    public void TrackOrder() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your orderID: ");
        int ID = scan.nextInt();

        String CustomerID = getUsername();
        String orderID = String.valueOf(ID);

        File originalFile = new File("src/Order.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        StringBuilder sb = new StringBuilder();
        String line = "";

        while ((line = br.readLine()) != null){
            if (line.endsWith(orderID)){
                System.out.println("CustomerName,Product,Date,OrderID");
                System.out.println(line);
                System.out.println();
            }
        }
    }

    public void CreateOrder() throws IOException {
        Scanner sc = new Scanner(System.in);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String CurrentDate = dateFormat.format(date);

        int id;
        Random randomNumber = new Random();
        id = randomNumber.nextInt(99999);
        String OrderID= Integer.toString(id);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter Product: ");
        String product = sc.nextLine();
        System.out.println("Order successful");
        System.out.println("Your Order Id: ID" + OrderID);
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
                bw.append("\n" + name + "," + product + "," + CurrentDate + "," + OrderID + "\n");
                bw.close();
                fw.close();
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    private void viewInfo() throws IOException {
        File originalFile = new File("src/Order.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        StringBuilder sb = new StringBuilder();
        String line = "";

        while ((line = br.readLine()) != null){
                System.out.println(line);
        }

    }


    public Account() throws IOException {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
