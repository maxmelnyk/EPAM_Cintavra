package com.cintavra;

import com.cintavra.Train.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        Service service = new Service();

        int choice;
        do {
            System.out.println("Enter start station:");
            String startStation = scanString.nextLine();

            System.out.println("Enter final station:");
            String endStation = scanString.nextLine();

            List<Train> trainsForUser = service.findTrainsForUser(startStation, endStation);
            if (trainsForUser.isEmpty()) {
                System.out.println("There is no train with such route.");
            } else {

                service.checkingForOtherPlaces(trainsForUser);
                service.showAllPlaceInTrains(trainsForUser);

                System.out.println("Choose your place");

                System.out.println("Enter number of train:");
                int trainNumber = scanInt.nextInt();

                System.out.println("Enter number of coach:");
                int coachNumber = scanInt.nextInt();

                System.out.println("Enter number of place:");
                int placeNumber = scanInt.nextInt();

                if (service.checkEnteredData(trainNumber, coachNumber, placeNumber, trainsForUser)) {
                    System.out.println();
                    System.out.println("Print your name:");
                    String userName = scanString.nextLine();

                    System.out.println("\nTo confirm your order enter 1");
                    while (true) {
                        String stringChoice = scanString.nextLine();
                        if (!isIntEntered(stringChoice)) {
                            cleanConsole();
                            System.out.println("Error");
                            System.out.println("\nTo confirm your order enter 1");
                        } else {
                            choice = Integer.parseInt(stringChoice);
                            break;
                        }
                    }

                    if (choice == 1)
                        service.buyTicket(userName, trainNumber, coachNumber, placeNumber);
                    System.out.println("Purchase successful!");
                    service.checkPlaceState(trainsForUser, coachNumber);
                } else {
                    System.out.println("Incorrect data!\nTry again.");
                }
            }
            System.out.println("\nTo buy another ticket enter 1");
            while (true) {
                String stringChoice = scanString.nextLine();
                if (!isIntEntered(stringChoice)) {
                    cleanConsole();
                    System.out.println("Error");
                    System.out.println("\nTo buy another ticket enter 1");
                } else {
                    choice = Integer.parseInt(stringChoice);
                    break;
                }
            }
        } while (choice == 1);
    }

    private static boolean isIntEntered(String str) {
        int i;
        boolean result = false;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return result;
        }
        if (i == 1) {
            result = true;
        }
        return result;
    }

    private static void cleanConsole() {
    }

}