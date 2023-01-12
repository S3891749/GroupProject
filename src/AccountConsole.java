import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountConsole {
    Scanner sc = new Scanner(System.in);
    AccountManage am = new AccountManage();

    public AccountConsole() throws IOException {
    }

    public void register() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Email");
        String newEmail = sc.next();
        System.out.println("Enter your username: ");
        String newUser = sc.next();
        System.out.println("Enter your password: ");
        String newPass = sc.next();
        System.out.println("Confirm your password: ");
        String confirmNewPass = sc.next();
        BufferedWriter out = new BufferedWriter(new FileWriter("src/Data.txt", true));
        BufferedWriter emailOut = new BufferedWriter(new FileWriter("src/email.txt", true));
        out.write("\n"+newUser);
        out.write(",");
        out.write(newPass);
        emailOut.write("\n"+newUser);
        emailOut.write("\t");
        emailOut.write(newEmail);
        System.out.println("Account created!");
        out.close();
        emailOut.close();

    }
    public void UserAccount() throws IOException {
        try{
            System.out.println("--------------------");
            System.out.println("1. Create user account");
            System.out.println("2. Login user account");
            System.out.println("--------------------");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            if (choice == 1){
                register();
            }
            if (choice == 2){
                am.LoginOrNot();
            }



        }
        catch(Exception e){

        }
    }
}
