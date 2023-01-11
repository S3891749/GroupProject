public class DiscountRate {

    
    private static double productDiscountPlatinum = 0.15;
    private static double productDiscountGold = 0.1;
    private static double productDiscountSilver = 0.05;

    

    public static double getProductDiscountRate(String type) {
        switch (type) {
            case "Platinum":
                return productDiscountPlatinum;
            case "Gold":
                return productDiscountGold;
            case "Silver":
                return productDiscountSilver;
            default:
                throw new IllegalArgumentException("wrong service type specified");
        }
    }

}