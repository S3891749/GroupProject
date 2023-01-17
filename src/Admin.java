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
        int choose = scan.nextInt();
        switch(choose) {
            case 1:
                viewCustomer_Info();
                break;
            case 2:
                viewAllOrdersInfo();
                break;
            case 3:
                Remove();
                break;
        }
    }
    public void Remove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id you want to remove: ");
        String line = sc.nextLine();
        RemoveCustomer("Admin_Login.txt", line);
    }


    public void login() throws IOException {
        Scanner FileScan = new Scanner(new File("Admin_Login.txt"));
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


    public static void RemoveCustomer(String filepath, String deleteline){
        String tempFile = "temp.txt";
        File oldFile = new File("src/Customer_Info.txt");
        File newFile = new File(tempFile);
        int line = 0;
        String currentLine;
        try{
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null){
                line++;
                if (currentLine.startsWith(deleteline)) {
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

        }catch (Exception e){

        }
    }

    
    public void viewCustomer_Info(){
        try
        {
            File file=new File("/Users/buiman/IdeaProjects/GroupWork/src/Customer_Info.txt");
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

            System.out.println(line);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}

