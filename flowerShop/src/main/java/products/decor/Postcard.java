package products.decor;

import products.bouquets.*;

public class Postcard extends BouquetDecorator {
    private final IBouquet bouquet;

    public Postcard(IBouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public String describe() {
        return bouquet.describe() + " with postcard.";
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 10.0;
    }
}
