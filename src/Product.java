public class Product {
    protected int uniqueId;
    protected String ProductName;
    String CurrencyPrice = "VND";
    protected double Price;
    protected String Category ="none";

    public Product(int uniqueId, String productName, String currencyPrice, double price, String category) {
        this.uniqueId = uniqueId;
        ProductName = productName;
        CurrencyPrice = currencyPrice;
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

    public String getCurrencyPrice() {
        return CurrencyPrice;
    }

    public void setCurrencyPrice(String currencyPrice) {
        CurrencyPrice = currencyPrice;
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

}
