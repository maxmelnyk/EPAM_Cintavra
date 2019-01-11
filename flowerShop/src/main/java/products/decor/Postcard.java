package products.decor;

import products.bouquets.*;

public class Postcard extends BouquetDecorator {
    private final Bouquet bouquet;

    public Postcard(Bouquet bouquet) {
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
