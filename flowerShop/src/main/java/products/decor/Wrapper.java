package products.decor;

import enums.WrapperType;
import products.bouquets.*;

public class Wrapper extends BouquetDecorator {
    private final IBouquet bouquet;
    private WrapperType wrapperType;

    public Wrapper(IBouquet bouquet, WrapperType wrapperType) {
        this.bouquet = bouquet;
        this.wrapperType = wrapperType;
    }

    @Override
    public String describe() {
        return bouquet.describe() + " with " + wrapperType.toString().toLowerCase();
    }

    @Override
    public double getPrice() {
        return bouquet.getPrice() + wrapperType.getPrice();
    }
}

