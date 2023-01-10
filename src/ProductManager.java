import java.util.ArrayList;
import java.util.List;

public class ProductManager{
    private List<Product> ListOfProduct;


    public ProductManager(){
        this.ListOfProduct = new ArrayList<>();
    }
    public int addProduct(Product p){
        this.ListOfProduct.add(p);
        return count();
    }
    public Product getProductIndex(int index){
        if (index < 0 || index >= count()){
            return null;
        }
        return this.ListOfProduct.get(index);

    }
    public boolean RemoveProduct(int id){
        int index = -1;
        for (int i = 0, n = count(); i < n; i++){
            if (this.ListOfProduct.get(i).getUniqueId() == id){
                index = i;
                break;
            }
        }
        if (index != -1){
            this.ListOfProduct.remove(index);
            return true;
        }
        return false;
    }


    public int count() {
        return this.ListOfProduct.size();
    }

    public Product getProduct(int index) {
        if (index < 0 || index >= count() ){
            return null;
        }
        return this.ListOfProduct.get(index);
    }

    public void addProduct() {
    }
}
