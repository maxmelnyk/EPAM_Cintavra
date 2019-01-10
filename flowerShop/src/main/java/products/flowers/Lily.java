package products.flowers;

import enums.Colors;
import enums.Countries;
import products.Flower;

public class Lily extends Flower {
    public Lily(String name, double price, Countries country, int height, Colors color) {
        super(name, price, country, height, color);
    }
}