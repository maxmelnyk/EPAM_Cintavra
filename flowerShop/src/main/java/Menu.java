import products.Product;

import java.io.*;
import java.util.Map;

public class Menu {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Menu ourInstance;

    private Menu() {
    }

    public static Menu access() {

        if (ourInstance == null) {
            ourInstance = new Menu();
        }

        return ourInstance;
    }


    public void mainMenu() {
        System.out.println("\nWelcome to Don Pedro's Flower Store.\n" +
                "Choose what would you like to view:\n" +
                "1 - available flowers;\n" +
                "2 - available trees;\n" +
                "3 - available bouquets;\n" +
                "4 - available cactus;\n" +
                "5 - to buy ordered products as a bouquet.\n" +
                "Press \"Enter\" button exit.");

        mainMenuChoice();
    }

    private void mainMenuChoice() {
//        String line;
//        try {
//            while ((line = reader.readLine()) != null) {
//                if (line.isEmpty()) {
//                    break;
//                } else {
//                    switch (Integer.parseInt(line)) {
//                        case 1:
//                            Stock.access().viewProductsAvailable();
//                            flowerMenuChoice();
//                            break;
//                        case 2:
//                            Stock.access().viewProductsAvailable();
//                            palmTreesMenuChoice();
//                            break;
//                        case 3:
//                            Stock.access().viewProductsAvailable();
//                            bouquetMenuChoice();
//                            break;
//                        case 4:
//                            Stock.access().viewProductsAvailable();
//                            cactusMenuChoice();
//                            break;
//                        case 5:
//                            Order.access().setFlowersAsBouquet(true);
//                            confirmedOrderAction();
//                            break;
//                        default:
//                            System.out.println("Entered wrong value, try again.");
//                            continue;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("An error occurred! Restart the application.");
//            System.exit(0);
//        }
    }

    public void productMenuChoice() {
        menuChoice(Stock.access().getProductsAvailable());
    }

    public void menuChoice(Map<Product, Integer> map) {
        System.out.println("Enter number of item you want to buy:\n" +
                "\nenter 0 to go back or press \"Enter\" button to exit.");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                } else {
                    int choice = Integer.parseInt(line);
                    if (choice > 0 && choice <= map.size()) {
                        System.out.println("how many pcs you want to buy?");
                        int amount = Integer.parseInt(reader.readLine());

                        if (amount <= Stock.access().getProductsAvailable().get((choice - 1))) {
                            Order.access().addToOrderList((Product) map.keySet(), amount);
                            returnExitOrContinue();
                        } else {
                            System.out.println("Sorry, " + amount + " pcs unavailable now.");
                            mainMenu();
                        }
                    } else if (choice == 0) {
                        mainMenu();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

    public void returnExitOrContinue() throws IOException {
        System.out.println("Enter 0 to go to main menu, enter 1 to order or press \"Enter\" button to exit.");
        String line = reader.readLine();
        int choice = Integer.parseInt(line);
        if (choice == 0) {
            mainMenu();
        } else if (choice == 1) {
            confirmedOrderAction();
        } else if (line.isEmpty()) {
            System.exit(0);
        } else {
            returnExitOrContinue();
        }
    }

    public void confirmedOrderAction() {
        deliveryInfo();
        Order.access().viewOrderInfo();
        System.out.println("Thank you for your order.");
        Stock.access().changeAvailableQuantity();
        Order.access().clearOrderList();
        mainMenu();
    }

    public void deliveryInfo() {
        System.out.println("Do you need delivery?\n" +
                "1 - Yes\n" +
                "2 - No");
        try {

            String line = reader.readLine();
            if (Integer.parseInt(line) == 1) {
                System.out.println("Enter delivery address");
                Order.access().setDeliveryAddress(reader.readLine());
                Order.access().setDelivery(25);

            }
        } catch (Exception e) {
            System.out.println("An error occurred! Restart the application.");
            System.exit(0);
        }
    }

}