package com.cintavra;

import java.text.ParseException;
import java.util.Scanner;

import com.cintavra.Train.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int choice = 0;
            Railway railway = new Railway();
        do {
            System.out.println("Enter start station:");
            Scanner scan = new Scanner(System.in);
            String startStation = scan.nextLine();

            System.out.println("Enter final station:");
            String finalStation = scan.nextLine();



            if (railway.searchTrains(startStation, finalStation).isEmpty()) {

                System.out.println("There is no train with such route.");
            } else {

                for (Train i : railway.trainSearcher) {

                    i.allPlaceInTrain(startStation, finalStation);
                }

                System.out.println("Enter number of train:");
                int trainNumber = (scan.nextInt()) - 1;

                System.out.println("Enter number of coach:");
                int coachNumber = scan.nextInt() - 1;

                System.out.println("Enter number of place:");
                int placeNumber = scan.nextInt() - 1;

                //перевірка на існування даних за значеннями введених користувачем
                if(railway.dataChecking(trainNumber, coachNumber, placeNumber)){

                    System.out.println("Ticket info:");
                    System.out.println(" Train number: " + (trainNumber + 1) + "\n Number of coach: " + (coachNumber + 1) +
                            "\n Place number: " + (placeNumber + 1));
                    System.out.println("\nTo proceed enter 1");

                    choice = scan.nextInt();

                    if (choice == 1) {
                        //buying ticket
                        railway.trainSearcher.get(trainNumber).choosePlaceInTrain(coachNumber, placeNumber, startStation, finalStation);
                        railway.removetrainSearcher();
                        System.out.println("Purchase successful!");
                    }
                }else{
                    System.out.println("Incorrect data!\nTry again.");
                    continue;
                }
            }

            System.out.println("\nTo buy another ticket enter 1");
            choice = scan.nextInt();

        } while (choice == 1);
    }
}
