import enums.Colors;
import enums.Countries;
import products.*;
import products.bouquets.Bouquet;
import products.flowers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
    private List<Product> flowersAvailable = new ArrayList<Product>(addFlowers());
    private List<Product> palmsTreesAvailable = new ArrayList<Product>(addPalmTrees());
    private List<Product> bouquetsAvailable = new ArrayList<Product>(addBouquets());
    private List<Product> cactusAvailable = new ArrayList<Product>(addCactus());
    private Map<String, Integer> countOfProducts = new HashMap<>();

    private static Stock ourInstance = new Stock();

    public static Stock access() {
        return ourInstance;
    }

    private Stock() {
    }

    public List<Product> getFlowersAvailable() {
        return flowersAvailable;
    }

    public List<Product> getPalmsTreesAvailable() {
        return palmsTreesAvailable;
    }

    public List<Product> getBouquetsAvailable() {
        return bouquetsAvailable;
    }

    public List<Product> getCactusAvailable() {
        return cactusAvailable;
    }

    public int getCountOfProduct(String name) {

        return countOfProducts.get(name);
    }

    private void setCountOfProduct(String name, Integer quantity) {
        countOfProducts.put(name, quantity);
    }

    public List<Flower> addFlowers() {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Gladiolus("Gladiolus", 10, Countries.COLOMBIA, 40, Colors.PINK));
        setCountOfProduct("Gladiolus", 25);
        flowers.add(new Lily("Lily", 12, Countries.ETHIOPIA, 50, Colors.PURPLE));
        setCountOfProduct("Lily", 15);
        flowers.add(new Orchid("Orchid", 8, Countries.ISRAEL, 70, Colors.RED));
        setCountOfProduct("Orchid", 17);
        flowers.add(new Tulip("Tulip", 13.3, Countries.ITALY, 80, Colors.WHITE));
        setCountOfProduct("Tulip", 23);
        return flowers;
    }

    public List<PalmTree> addPalmTrees() {
        List<PalmTree> palmTrees = new ArrayList<>();
        palmTrees.add(new PalmTree("Palm Tree", 45, Countries.KENYA));
        setCountOfProduct("Palm Tree", 7);
        return palmTrees;
    }

    public List<Cactus> addCactus() {
        List<Cactus> cactuses = new ArrayList<>();
        cactuses.add(new Cactus("Cactus", 5.5, Countries.MEXICO, 35, Colors.GREEN));
        setCountOfProduct("Cactus", 12);
        return cactuses;
    }

    public List<Bouquet> addBouquets() {
        List<Flower> bouq1 = new ArrayList<>();
        bouq1.add(new Tulip("Tulip", 13.3, Countries.ITALY, 35, Colors.WHITE));
        setCountOfProduct("Tulip", 4);
        bouq1.add(new Lily("Lily", 12, Countries.ETHIOPIA, 35, Colors.PURPLE));
        setCountOfProduct("Lily", 3);
        List<Bouquet> bouquets = new ArrayList<Bouquet>();
        bouquets.add(new Bouquet("bouq1", 50, Countries.MIXED, bouq1));
        return bouquets;
    }

    public void viewFlowersAvailable() {
        for (int i = 0; i < flowersAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + flowersAvailable.get(i) +
                    ", quantity - " + getCountOfProduct(flowersAvailable.get(i).getName()));
        }
    }

    public void viewPalmTreesAvailable() {
        for (int i = 0; i < palmsTreesAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + palmsTreesAvailable.get(i) +
                    ", quantity - " + getCountOfProduct(palmsTreesAvailable.get(i).getName()));
        }
    }

    public void viewCactusAvailable() {
        for (int i = 0; i < cactusAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + cactusAvailable.get(i) +
                    ", quantity - " + getCountOfProduct(cactusAvailable.get(i).getName()));
        }
    }

    public void viewBouquetsAvailable() {
        for (int i = 0; i < bouquetsAvailable.size(); i++) {
            System.out.println((i + 1) + " - " + bouquetsAvailable.get(i) +
                    ", quantity - " + getCountOfProduct(bouquetsAvailable.get(i).getName()));
        }
    }

    public void changeAvailableQuantity() {
        int orderSize;

        for (Product product : Order.access().getOrderList()) {
            orderSize = Order.access().getOrderQuantity().get(Order.access().getOrderList().indexOf(product));

            if (flowersAvailable.contains(product)) {
                calculateNewQuantity(flowersAvailable, product, orderSize);
            } else if (palmsTreesAvailable.contains(product)) {
                calculateNewQuantity(palmsTreesAvailable, product, orderSize);
            } else if (bouquetsAvailable.contains(product)) {
                calculateNewQuantity(bouquetsAvailable, product, orderSize);
            }
        }
    }

    public void calculateNewQuantity(List<Product> list, Product product, int orderSize) {
        int newQuantity = getCountOfProduct(list.get(list.indexOf(product)).getName()) - orderSize;

        if (newQuantity <= 0) {
            list.remove(product);
        } else {
            setCountOfProduct(list.get(list.indexOf(product)).getName(), newQuantity);
        }
    }
}