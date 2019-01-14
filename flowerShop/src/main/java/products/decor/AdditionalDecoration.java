package products.decor;

import products.bouquets.*;

public class AdditionalDecoration extends BouquetDecorator {
    private final IBouquet bouquet;

    public AdditionalDecoration(IBouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public String describe() {
        return bouquet.describe() + " with decorations.";
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + 7.60;
    }
}
