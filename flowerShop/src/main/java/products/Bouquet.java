package products;

import enums.Countries;

import java.util.ArrayList;
import java.util.List;

public class Bouquet extends Product {
    private List<Flower> flowers = new ArrayList<>();

    public Bouquet(String name, double price, Countries country, List<Flower> flowers) {
        super(name, price, country);
        this.flowers = flowers;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}