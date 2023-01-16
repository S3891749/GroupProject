import javax.sound.sampled.Line;
import java.io.*;
import java.util.Scanner;

public class Admin {
    String user;
    String pass;
    public Admin (String user, String pass){
       this.user = user;
       this.pass = pass;

    }
    public Admin() {

    }

    public void Admin_Action() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Done. About customer");
        System.out.println("1. View All Customer Info");
        System.out.println("2. View Orders Info");
        System.out.println("3. Remove Customer");
        System.out.print("Choose your option: ");
        int option = scan.nextInt();
        switch(option) {
            case 1:
                viewCustomer_Info();
                break;
            case 2:
                viewAllOrdersInfo();
                break;
            case 3:
                removeCustomer();
                break;

        }
    }


    public void login() throws IOException {
        Scanner FileScan = new Scanner(new File("Admin_Login_Info.txt"));
        Scanner scan = new Scanner(System.in);
        boolean foundUser = false;


        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();

        while (FileScan.hasNextLine()){
            String input = FileScan.nextLine();
            String user = input.substring(0, input.indexOf(','));
            String pass = input.substring(input.indexOf(',')+1 , input.length());


            if( user.equals(username) && (pass.equals(password)) ){
                foundUser = true;
                System.out.println("Logged in \n");
                Admin_Action();
                break;
            }
        }

        if(!foundUser){
            System.out.println("Wrong username/password! Try Again!");
            login();
        }
    }

   
    public void removeCustomer() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("List of members: ");
        viewCustomer_Info();

        System.out.println("Select the user you want to remove by copying and paste the line you want to remove: ");
        String LineToDelete =scan.nextLine();
        File inputFile = new File("Data.txt");
        File tempFile = new File("temp_file.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {

            if(currentLine.startsWith(LineToDelete))
            writer.write(currentLine);
        }
        writer.close();
        reader.close();


        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Line removed");
        System.out.println("List of members after removing: ");
        viewCustomer_Info();

    }

    
    public void viewCustomer_Info(){
        try
        {
            File file=new File("/Users/buiman/IdeaProjects/GroupWork/src/Data.txt");
            FileReader fr=new FileReader(file);   
            BufferedReader br=new BufferedReader(fr);  
            StringBuffer sb=new StringBuffer();    
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);      
                sb.append("\n");     
            }
            fr.close();   

            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void viewAllOrdersInfo(){
        try
        {
            File file=new File("src/Order.txt");
            FileReader fr=new FileReader(file);   
            BufferedReader br=new BufferedReader(fr);  
            StringBuffer sb=new StringBuffer();
            String line;

            while((line=br.readLine())!=null)
            {
                sb.append(line);      
                sb.append("\n");    
            }
            fr.close();    

            System.out.println(sb.toString());   
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}

