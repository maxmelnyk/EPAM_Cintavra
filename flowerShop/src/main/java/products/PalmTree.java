package products;

import enums.Countries;

public class PalmTree extends Product {
    public PalmTree(String name, double price, Countries country) {
        super(name, price, country);
    }

    @Override
    public String toString() {
        return getName() +
                ": price - " + getPrice() +
                ", country  - " + getCountry();
    }
}