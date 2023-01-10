import java.io.File;
import java.util.Scanner;

public class ProductConsole {
    private ProductManager pm;
    Scanner sc = new Scanner(System.in);

    public ProductConsole() {
        this.pm = new ProductManager();
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
    public void start(){
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


    public void RemoveProduct() {
        System.out.println("Enter Id of Product: ");
        int id = sc.nextInt();
        boolean results = pm.RemoveProduct(id);
        if(results){
            System.out.println("Product removed");
        }
        else {
            System.out.println("Product is not found");
        }
    }

    public void showAll() {
        System.out.println("All Product");
        System.out.println("ID\tName\tPrice\tCategory");
        for (int i = 0; i < this.pm.count(); i++){
            Product p = pm.getProduct(i);
            System.out.println(p.getUniqueId()+ "\t"+ p.getProductName() +"\t"+p.getPrice() +"\t"+ p.getCategory());
        }

    }


    public void addProduct() {
        System.out.println("Enter product ID: ");
        int id = sc.nextInt();
        System.out.println("Enter product name:");
        String name = sc.next();
        System.out.println("Enter product price: ");
        double price = sc.nextDouble();
        System.out.println("Enter product category: ");
        String category = sc.next();

        Product p = new Product(id, name, price, category);
        this.pm.addProduct(p);
    }

}
