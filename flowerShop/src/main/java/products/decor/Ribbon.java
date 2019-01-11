package products.decor;

import products.bouquets.*;

public class Ribbon extends BouquetDecorator {
    private final Bouquet bouquet;
    private String color;

    public Ribbon(Bouquet bouquet, String color) {
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
