package products.decor;

import products.bouquets.*;

public class AdditionalDecoration extends BouquetDecorator {
    private final Bouquet bouquet;

    public AdditionalDecoration(Bouquet bouquet) {
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
