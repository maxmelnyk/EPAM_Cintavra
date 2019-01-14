import enums.*;
import products.*;
import products.bouquets.Bouquet;

import java.util.*;

public class Stock {
    private Map<Product, Integer> productsAvailable = new HashMap<>();

    private static Stock ourInstance = new Stock();

    public static Stock access() {
        return ourInstance;
    }

    private Stock() {
    }

    public Map<Product, Integer> getProductsAvailable() {
        return productsAvailable;
    }


    public Map<Product, Integer> addProducts() {
        Map<Product, Integer> products = new HashMap<>();
        products.put((new Flower("Gladiolus", 10, Countries.COLOMBIA, 40, Colors.PINK)), 25);
        products.put((new Flower("Lily", 12, Countries.ETHIOPIA, 50, Colors.PURPLE)), 15);
        products.put((new Flower("Orchid", 8, Countries.ISRAEL, 70, Colors.RED)), 17);
        products.put((new Flower("Tulip", 13.3, Countries.ITALY, 80, Colors.WHITE)), 23);
        products.put((new PalmTree("Palm Tree", 45, Countries.KENYA)), 7);
        products.put(new Cactus("Cactus", 5.5, Countries.MEXICO, 35, Colors.GREEN), 13);
        products.put(new Bouquet("Rose bouquet", 50, Countries.ITALY, createRoseBouquet()), 2);
        return products;
    }

    public List<Flower> createRoseBouquet() {
        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            flowers.add(new Flower("Rose", 13.3, Countries.ITALY, 35, Colors.WHITE));
        }
        flowers.add(new Flower("Rose", 13.3, Countries.ITALY, 35, Colors.RED));
        return flowers;
    }

    public void viewProductsAvailable() {
        for (Map.Entry<Product, Integer> entry : addProducts().entrySet()) {
            System.out.println("Product = " + entry.getKey() + ", quantity = " + entry.getValue());
        }
    }

    public void changeAvailableQuantity() {
        int orderSize;

        for (Product product : Order.access().getOrder().keySet()) {
            orderSize = Order.access().getOrder().get(product);
            if (addProducts().containsKey(Flower.class)) {
                calculateNewQuantity(productsAvailable, product, orderSize);
            } else if (addProducts().containsKey(PalmTree.class)) {
                calculateNewQuantity(productsAvailable, product, orderSize);
            } else if (addProducts().containsKey(Cactus.class)) {
                calculateNewQuantity(productsAvailable, product, orderSize);
            }
        }
    }

    public void calculateNewQuantity(Map<Product, Integer> map, Product product, int orderSize) {
        int newQuantity = map.get(product) - orderSize;
        if (newQuantity <= 0) {
            map.remove(product);
        } else {
            map.put(product, newQuantity);
        }
    }
}