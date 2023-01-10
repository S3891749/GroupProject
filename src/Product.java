public class Product {
    private int uniqueId;
    private String ProductName;

    private double Price;
    private String Category ="none";

    public Product(int uniqueId, String productName, double price, String category) {
        this.uniqueId = uniqueId;
        ProductName = productName;
        Price = price;
        Category = category;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }


    @Override
    public String toString() {
        return "Product{" +
                "uniqueId=" + uniqueId +
                ", ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", Category='" + Category + '\'' +
                '}';
    }
}
