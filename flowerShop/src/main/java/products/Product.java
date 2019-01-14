package products;

import enums.Countries;

public abstract class Product {
    private String name;
    private double price;
    private Countries country;

    public Product(String name, double price, Countries country){
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Countries getCountry() {
        return country;
    }

}