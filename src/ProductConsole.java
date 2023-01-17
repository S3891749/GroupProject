import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProductConsole {
    ProductManager pm = new ProductManager();
    Scanner sc = new Scanner(System.in);

    public ProductConsole() {
        this.pm = pm;
        this.sc = sc;
    }


    private int ManageProduct(){
        System.out.println("______________");
        System.out.println("1. AddProduct");
        System.out.println("2. RemoveProduct");
        System.out.println("3. ShowProduct");
        System.out.println("0. Exit");
        int choice = sc.nextInt();
        return choice;
    }
    public int readInt(int min, int max){
        int choice;
        while(true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 0 && choice <= 3){
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();

            }
        }
        return choice;
    }
    public void start() throws IOException {
        while(true){
            int choice = ManageProduct();
                switch(choice){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        RemoveProduct();
                        break;
                    case 3:
                        showAll();
                        break;
                    default: throw new AssertionError();




                }
            }

        }


    public void RemoveProduct() throws IOException {

        System.out.println("Enter Id of Product: ");
        String id = sc.next();
        pm.RemoveProduct("src/product.txt", id);
    }



    public void showAll() throws IOException {
        Scanner sc = new Scanner(System.in);
        String line, name = null, category = null, price = null, id = null;
        Scanner scan = new Scanner(new File("src/product.txt"));
        System.out.println("-------------------");
        System.out.println("All Product");
        System.out.println("-------------------");
        System.out.println("ID\t Name\t\t\tPrice\t\tCategory");
        while (scan.hasNext()){
            line = scan.nextLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            id = st.nextToken();
            name = st.nextToken();
            price = st.nextToken();
            category = st.nextToken();
            System.out.println(id + "\t" + name + "\t" + "\t"+ "\t"  + price + "\t" + "\t" + category + "\t");
        }

        scan.close();


    }


        public void addProduct(){
        System.out.println("Enter product ID: ");
        int id = sc.nextInt();
        System.out.println("Enter product name:");
        String name = sc.next();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        System.out.println("Enter product category: ");
        String category = sc.next();
        try(FileWriter fw = new FileWriter("src/product.txt", true);
            BufferedWriter bw1 = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw1))
        {
            out.println(id + "," + name + "," + price + "," + category);
            out.close();

            bw1.close();
            fw.close();
        } catch (IOException e) {
        }

        new Product(id, name, price, category);

    }

}
