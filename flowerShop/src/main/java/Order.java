import enums.WrapperType;
import products.*;
import products.bouquets.*;
import products.decor.*;

import java.io.*;
import java.util.*;

public class Order {
    private BufferedReader reader;
    private Map<Product, Integer> order = new HashMap<>();
    private Map<Product, Integer> done = new HashMap<>();

    private boolean flowersAsBouquet = false;
    private int deliveryPrice = 0;
    private String deliveryAddress = "";
    private Bouquet bouq;
    private IBouquet bouquet;
    private static Order ourInstance = new Order();

    public static Order access() {
        return ourInstance;
    }

    private Order() {
    }

    public Map<Product, Integer> getOrder() {
        return order;
    }

    public void setFlowersAsBouquet(boolean flowersAsBouquet) {
        this.flowersAsBouquet = flowersAsBouquet;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setDelivery(int delivery) {
        this.deliveryPrice = delivery;
    }


    public void viewOrderInfo() {
        double total = 0;
        System.out.println("Your order is ");
        for (Product product : order.keySet()) {
            if (flowersAsBouquet == true) {
                if (product instanceof Bouquet) {
                    addDecor(reader);
                    total = Discount.calculatePriceWithBouquet(order) + deliveryPrice;
                    System.out.println(product.getName() + " " + order.get(Bouquet.class) + " pcs");
                }
            } else {
                if (product instanceof Flower) {
                    total = Discount.calculateNewPrice(order) + deliveryPrice;
                    System.out.println(product.getName() + " " + order.get(Flower.class) + " pcs");
                } else if (product instanceof Cactus) {
                    total = Discount.calculateNewPrice(order) + deliveryPrice;
                    System.out.println(product.getName() + " " + order.get(Cactus.class) + " pcs");
                } else if (product instanceof PalmTree) {
                    total = Discount.calculateNewPrice(order) + deliveryPrice;
                    System.out.println(product.getName() + " " + order.get(PalmTree.class) + " pcs");
                }
                System.out.println("Delivery to " + deliveryAddress);
                System.out.println("Total price is " + total + "\n");
            }
        }
    }

    public void addDecor(BufferedReader reader) {
        System.out.println("Do you want to add decor to your bouquet?\n To confirm enter y");
        try {
            String line = reader.readLine();

            if (line == "y") {
                chooseDecor(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chooseDecor(BufferedReader reader) throws IOException {
        System.out.println("Choose what you want to add to your bouquet:\n" +
                "1 - add some decor;\n" +
                "2 - add postcard;\n" +
                "3 - add ribbon;\n" +
                "4 - add wrapper;\n" +
                "Press \"Enter\" button exit.");
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            } else {
                switch (Integer.parseInt(line)) {
                    case 1:
                        bouquet = new AdditionalDecoration(bouquet);
                        System.out.println(bouquet.describe());
                        System.out.println(bouquet.getPrice());
                        break;
                    case 2:
                        bouquet = new Postcard(bouquet);
                        System.out.println(bouquet.describe());
                        System.out.println(bouquet.getPrice());
                        break;
                    case 3:
                        bouquet = new Ribbon(bouquet, "gold");
                        System.out.println(bouquet.describe());
                        System.out.println(bouquet.getPrice());
                        break;
                    case 4:
                        bouquet = new Wrapper(bouquet, WrapperType.PAPER);
                        System.out.println(bouquet.describe());
                        System.out.println(bouquet.getPrice());
                        break;
                    default:
                        System.out.println("Entered wrong value, try again.");
                        continue;
                }
            }
        }
    }

    public void addToOrderList(Product product, int quantity) {
        done.put(product, quantity);
    }

    public void clearOrderList() {
        order.clear();
        deliveryAddress = "";
        deliveryPrice = 0;
    }
}