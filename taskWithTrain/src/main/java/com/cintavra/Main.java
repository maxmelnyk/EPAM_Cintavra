package com.cintavra;

import java.util.Scanner;

import com.cintavra.Train.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        Service service = new Service();

        do {
            ticketOrder(service);

            System.out.println("\nTo buy another ticket enter 1");
            choice = scan.nextInt();

        } while (choice == 1);
    }

    private static void ticketOrder(Service service) {

        int choice = 0;

        System.out.println("Enter start station:");
        Scanner scan = new Scanner(System.in);
        String startStation = scan.nextLine();

        System.out.println("Enter final station:");
        String finalStation = scan.nextLine();


        if (service.searchTrains(startStation, finalStation).isEmpty()) {

            System.out.println("There is no train with such route.");
        } else {

            for (Train train : service.trainSearcher) {

                service.showAllPlaceInTrain(startStation, finalStation, train);
            }

            System.out.println("Enter number of train:");
            int trainNumber = (scan.nextInt()) - 1;

            System.out.println("Enter number of coach:");
            int coachNumber = scan.nextInt() - 1;

            System.out.println("Enter number of place:");
            int placeNumber = scan.nextInt() - 1;

            //перевірка на існування даних за значеннями введених користувачем
            if (service.dataChecking(trainNumber, coachNumber, placeNumber)) {

                System.out.println();
                System.out.println("Print your name:");
                scan.nextLine();
                String userName = scan.nextLine();
                System.out.println();

                System.out.println("Ticket info:");
                System.out.println(" Train number: " + (trainNumber + 1) + "\n Number of coach: " + (coachNumber + 1) +
                        "\n Place number: " + (placeNumber + 1) + "\n Customer: " + userName);
                System.out.println("\nTo proceed enter 1");

                choice = scan.nextInt();

                if (choice == 1) {

                    //buying ticket
                    service.choosePlaceInTrain(trainNumber, coachNumber, placeNumber, startStation, finalStation, userName);
                    service.removeTrainSearcher();
                    System.out.println("Purchase successful!");
                }

            } else {
                System.out.println("Incorrect data!\nTry again.");
            }
        }
    }
}