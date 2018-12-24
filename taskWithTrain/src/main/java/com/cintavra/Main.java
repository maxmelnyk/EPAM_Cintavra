package com.cintavra;

import com.cintavra.Train.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter start station:");
            startStation = scan.nextLine();

            System.out.println("Enter final station:");
            endStation = scan.nextLine();

            if (searchAppropriateTrain().isEmpty()) {
                System.out.println("There is no train with such route.");
            } else {

                showAllPlaceInTrain();

                System.out.println("Enter number of train:");
                trainNumber = scan.nextInt() - 1;

                System.out.println("Enter number of coach:");
                coachNumber = scan.nextInt() - 1;

                System.out.println("Enter number of place:");
                placeNumber = scan.nextInt() - 1;

                //перевірка на існування даних за значеннями введених користувачем
                if (checkEnteredData()) {
                    System.out.println();
                    System.out.println("Print your name:");
                    scan.nextLine();
                    userName = scan.nextLine();
                    System.out.println();

                    System.out.println("Ticket info:");
                    System.out.println(" Train number: " + (trainNumber + 1) + "\n Number of coach: " + (coachNumber + 1) +
                            "\n Place number: " + (placeNumber + 1) + "\n Customer: " + userName);
                    System.out.println("\nTo confirm your order enter 1");
                    choice = scan.nextInt();

                    if (choice == 1) {
                        buyPlace();
                        removeTrainsForClient();
                        System.out.println("Purchase successful!");
                    } else {
                        checkTicketState();
                    }
                } else {
                    System.out.println("Incorrect data!\nTry again.");
                }
            }
            System.out.println("\nTo buy another ticket enter 1");
            choice = scan.nextInt();
            scan.nextLine();
        } while (choice == 1);
    }
}