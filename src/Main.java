import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Account a1 = new Account();
        Admin ad = new Admin();
        AccountConsole ac = new AccountConsole();
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
