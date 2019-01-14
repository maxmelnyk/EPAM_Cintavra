import products.Flower;
import products.Product;

import java.util.List;
import java.util.Map;

public class Discount {
    public static double calculateNewPrice(Map<Product, Integer> map) {
        int orderedProductSize = 0;
        double newPrice = 0;

        for (Product product : map.keySet()) {
            orderedProductSize += Order.access().getOrder().get(product);
            newPrice += (map.get(product.getPrice()) * Order.access().getOrder().get(product));
        }

        if (orderedProductSize > 5 && orderedProductSize <= 15) {
            newPrice *= 0.9;
        } else if (orderedProductSize > 16) {
            newPrice *= 0.8;
        }

        return newPrice;
    }

    public static double calculatePriceWithBouquet(Map<Product, Integer> map) {
        int orderedProductSize = 1;
        double bouquet = 0;
        double newPrice = 0;
        for (Product product : map.keySet()) {
            if (map.keySet() instanceof Flower) {
                bouquet += (map.get(product.getPrice()) * Order.access().getOrder().get(product));
            } else {
                orderedProductSize += Order.access().getOrder().get(product);
                newPrice += (map.get(product.getPrice()) * Order.access().getOrder().get(product));
            }
        }
        bouquet *= 0.7;

        if (orderedProductSize > 5 && orderedProductSize <= 15) {
            newPrice *= 0.9;
        } else if (orderedProductSize > 16) {
            newPrice *= 0.8;
        }

        return newPrice + bouquet;
    }
}