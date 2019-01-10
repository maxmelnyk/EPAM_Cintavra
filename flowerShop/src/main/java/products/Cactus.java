package products;

import enums.Colors;
import enums.Countries;

public class Cactus extends Product {
    private int height;
    private Colors color;

    public Cactus(String name, double price, Countries country, int height, Colors color) {
        super(name, price, country);
        this.height = height;
        this.color = color;
    }
}