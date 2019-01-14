package products.decor;

import products.bouquets.*;

public class Ribbon extends BouquetDecorator {
    private final IBouquet bouquet;
    private String color;

    public Ribbon(IBouquet bouquet, String color) {
        this.bouquet = bouquet;
        this.color = color;
    }

    @Override
    public String describe() {
        return bouquet.describe() + " with " + color + " ribbon.";
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 1.50;
    }
}
