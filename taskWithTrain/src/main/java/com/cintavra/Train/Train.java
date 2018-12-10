package com.cintavra.Train;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Train {
    final private static int COUNT_OF_COACHES = 1;
    public int trainId;
    public LocalDateTime date;
    ArrayList<Coach> coaches = new ArrayList<Coach>();
    public String[] trainStations;

    Train(int trainId, LocalDateTime date, String[] route) {
        for (int i = 0; i < COUNT_OF_COACHES; i++) {
            Coach coach = new Coach();  //ініціалізація даних про вагон
            coaches.add(coach);
        }
        this.trainId = trainId;
        this.date = date;
        this.trainStations = route;

    }

    public void allPlaceInTrain(String startStation, String endStation) {

        int printDataFromTrain = 0;

        for (Coach coach : coaches) {
            if (coach.getCountFreePlace() != 0) {
                if(printDataFromTrain == 0) {
                    System.out.print("Train number: " + trainId + " (DateTime: " + date + ")");
                    printDataFromTrain++;
                }
                System.out.print("\nCoach number: " + (coaches.indexOf(coach) + 1));
                coach.showFreePlace(startStation, endStation, trainStations);
            }
        }

        if(printDataFromTrain == 1) {
            System.out.println();
            System.out.println();
        }
    }

    public void choosePlaceInTrain(int numberCoach, int numberPlace, String startStation, String endStation) {
        Coach foundCoach = coaches.get(numberCoach);
        foundCoach.buyPlace(numberPlace, this.trainStations, startStation, endStation);
    }
}
