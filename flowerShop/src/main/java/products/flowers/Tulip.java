package products.flowers;

import enums.Colors;
import enums.Countries;
import products.Flower;

public class Tulip extends Flower {
    public Tulip(String name, double price, Countries country, int height, Colors color) {
        super(name, price, country, height, color);
    }
}