package com.cintavra;

import java.util.Scanner;

import com.cintavra.Train.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int CHOICEMARK = 1;
        int choice;

        Railway r = new Railway();

        do{
            System.out.println("Enter start station:");
            Scanner scan = new Scanner(System.in);
            String startStation = scan.nextLine();

            System.out.println("Enter final station:");
            String finalStation = scan.nextLine();

            for (Train i : r.searchTrains(startStation, finalStation)) {
                System.out.println(i.trainId);
                i.allPlaceInTrain();
            }

            System.out.println("Enter number of train:");
            int trainNumber = (scan.nextInt()) - 1;

            System.out.println("Enter number of coach:");
            int coachNumber = scan.nextInt() - 1;

            System.out.println("Enter number of place:");
            int placeNumber = scan.nextInt() - 1;

            r.trainSeacher.get(trainNumber).choosePlaceInTrain(coachNumber, placeNumber);

            System.out.println("For finish buying enter 1");
            choice = scan.nextInt();

            r.removeTrainSeacher();
        }while(choice == CHOICEMARK);
     }
}
