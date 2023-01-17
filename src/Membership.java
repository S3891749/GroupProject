public class Membership {
    public static final double SILVER_THRESHOLD = 5000000;
    public static final double GOLD_THRESHOLD = 10000000;
    public static final double PLATINUM_THRESHOLD = 25000000;
    public static final double SILVER_DISCOUNT = 0.05;
    public static final double GOLD_DISCOUNT = 0.1;
    public static final double PLATINUM_DISCOUNT = 0.15;

    public static String getMembershipLevel(double totalSpending) {
        if (totalSpending > PLATINUM_THRESHOLD) {
            return "Platinum";
        } else if (totalSpending > GOLD_THRESHOLD) {
            return "Gold";
        } else if (totalSpending > SILVER_THRESHOLD) {
            return "Silver";
        } else {
            return "None";
        }
    }

    public static double getDiscount(String membershipLevel) {
        if (membershipLevel.equals("Silver")) {
            return SILVER_DISCOUNT;
        } else if (membershipLevel.equals("Gold")) {
            return GOLD_DISCOUNT;
        } else if (membershipLevel.equals("Platinum")) {
            return PLATINUM_DISCOUNT;
        } else {
            return 0;
        }
    }
}
