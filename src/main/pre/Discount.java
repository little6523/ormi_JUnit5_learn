package pre;

public class Discount {
    private final int discountPercentage;

    public Discount(int discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.discountPercentage = discountPercentage;
    }

    public int apply(Product product) {
        int originalPrice = product.getPrice();
        int discountAmount = (originalPrice * discountPercentage) / 100;
        return originalPrice - discountAmount;
    }
}
