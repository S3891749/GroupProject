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
        System.out.println("4. Get Order by Customer");
        System.out.println("5. Change Status of Order");
        System.out.print("Choose your option: ");
        int option = scan.nextInt();
        switch(option) {
            case 1:
                viewCustomer_Info();
            case 2:
                viewAllOrdersInfo();
            case 3:
                removeCustomer();
            case 4:
                getOrderbyCustomerID();
            case 5:
                UpdateOrderStatus();
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
        File inputFile = new File("Customer_Info.txt");
        File tempFile = new File("temp_file.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
           
            String trimmedLine = currentLine.trim();

            if(trimmedLine.equals(LineToDelete)) continue;

            writer.write(currentLine + System.getProperty("line.separator"));
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
            File file=new File("Customer_Info.txt");    
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
            File file=new File("Order_Info.txt"); 
            FileReader fr=new FileReader(file);   
            BufferedReader br=new BufferedReader(fr);  
            StringBuffer sb=new StringBuffer();    
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

    public void getOrderbyCustomerID() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Customer's ID number: ");
        int id = scan.nextInt();
        String CustomerID = Integer.toString(id);


        File originalFile = new File("Order_Info.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        StringBuilder sb = new StringBuilder();
        String line = "";

        while ((line = br.readLine()) != null){
            if (line.startsWith(CustomerID)){
                System.out.println("CustomerID,OrderID,Date_Ordered,Order_Status");
                System.out.println(line);
                System.out.println();
            }
        }
    }

    public void UpdateOrderStatus() throws IOException {
        
        viewAllOrdersInfo();
 
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Customer's ID number: ");
        int id = scan.nextInt();
        String CustomerID = Integer.toString(id);

        System.out.println("Enter Order ID number: ");
        int oID = scan.nextInt();
        String OrderID = Integer.toString(oID);
        File originalFile = new File("Order_Info.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));
        StringBuilder sb = new StringBuilder();
        String line = "";
        String changed_info="";
        String result = "";

        while ((line = br.readLine()) != null) {
            if (line.startsWith(CustomerID+ ","+OrderID)) {
                result = line;
                String[] parts = result.split(",");
                String customerID = parts[0];
                String orderID = parts[1];
                String date_ordered = parts[2];
                String order_status = parts[3];

                System.out.println("Do you want to change order Status (blank to keep old value | Y to change status to [Ordered]: ");
                String ans = scan.nextLine();
                if (!ans.isEmpty()){
                    System.out.println("Type ordered");
                    order_status = scan.nextLine();
                }

                changed_info = customerID+","+orderID+","+date_ordered+","+order_status;
                System.out.println("Here's your updated information:");
                System.out.println("CustomerID | OrderID | Date Ordered | Order Status");
                System.out.println(changed_info);
                break;
            }
            File inputFile = new File("Order_Info.txt");
            File tempFile = new File("temp_file_Order.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                
                String trimmedLine = currentLine.trim();

                if(trimmedLine.equals(result)) continue;

                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);          
            PrintWriter pw = new PrintWriter(new FileOutputStream("Order_Info.txt",true));
            pw.println(changed_info);
            pw.flush();
            pw.close();


        }
    }

}

