package products.bouquets;

public abstract class BouquetDecorator implements IBouquet {
    @Override
    public String describe() {
        return "Making bouquet";
    }
}
