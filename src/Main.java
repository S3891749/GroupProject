import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Account a1 = new Account();
        Admin ad = new Admin();
        AccountConsole ac = new AccountConsole();
        System.out.println("Welcome to our project: ");
        System.out.println("our team Member: ");
        System.out.println("S3891749, Bui Quang Man");
        System.out.println("S3930216, Luong Dinh Khang");
        System.out.println("S3924310, Nguyen Quang Phu");
        System.out.println("S3914580, Lam Nhi Khang");
        System.out.println("_____________________________");
        System.out.println("Login as: ");
        System.out.println("1. Customer");
        System.out.println("2. Admin");

        int choose = sc.nextInt();

        switch (choose){
            case 1:
                System.out.println("Welcome, please choose task");
                ac.UserAccount();
                while(true){
                    a1.CustomerAction();
                }
            case 2:
                System.out.println("Welcome admin, please choose task");
                ad.LoginOrNot();
                while(true){
                ad.Admin_Action();
        }}


    }

}
