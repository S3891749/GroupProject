import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AccountConsole ac = new AccountConsole();
        ac.UserAccount();
        Account a1 = new Account();
        a1.CustomerAction();
        Admin ad = new Admin();
        ad.Admin_Action();



    }

}
