import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AccountManage {
    String filename = "src/Data.txt";
    public static Scanner x;
    private BufferedReader reader;
    BufferedWriter out = new BufferedWriter(new FileWriter("Data.txt", true));
    BufferedWriter emailOut = new BufferedWriter(new FileWriter("email.txt", true));
    private File EmailData = new File("src/email.txt");
    private File AccountData = new File("src/Data.txt");

    public AccountManage() throws IOException {
    }

    public void LoginOrNot() throws FileNotFoundException {
        do{
            boolean isLogin = verifyLogin();
            if(isLogin){
                System.out.println("Login successful!");
            }
            else{
                System.out.println("Login fail!");
            }
        }
        while(true);
    }
    public static boolean verifyLogin() throws FileNotFoundException {
        boolean isAuthenticated = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String user = sc.next();
        System.out.println("Enter password: ");
        String pass = sc.next();
        String path = "src/Data.txt";
        File file = new File(path);
        try{
            Scanner inputBuffer = new Scanner(file);

            while(inputBuffer.hasNext()){
                String line = inputBuffer.nextLine();
                String[] values = line.split(",");
                if(values[0].equals(user)){
                    if(values[1].equals(pass)){
                        isAuthenticated = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return isAuthenticated;

    }
    }




