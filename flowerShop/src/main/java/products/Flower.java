package products;

import enums.Colors;
import enums.Countries;

public abstract class Flower extends Product {
    private int height;
    private Colors color;

    public Flower(String name, double price, Countries country, int height, Colors color) {
        super(name, price, country);
        this.height = height;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public Colors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getName() +
                "\t: price - " + getPrice() +
                ", country  - " + getCountry() +
                ", height - " + getHeight() +
                ", color - " + getColor();
    }
}