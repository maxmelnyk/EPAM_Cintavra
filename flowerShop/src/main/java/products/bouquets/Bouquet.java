package products.bouquets;

import enums.Countries;
import products.Flower;
import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Bouquet extends Product implements IBouquet {
    private List<Flower> flowers;

    public Bouquet(String name, double price, Countries country, List<Flower> flowers) {
        super(name, price, country);
        this.flowers = flowers;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public String describe() {
        return "It's simple bouquet ";
    }
}