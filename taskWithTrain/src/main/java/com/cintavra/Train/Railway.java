package com.cintavra.Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Railway {
    public ArrayList<Train> trains = new ArrayList<Train>();
    public ArrayList<Train> trainSearcher = new ArrayList<Train>();

    public Railway() {
        String[] route1 = {"lviv", "ternopil", "kyiv"};
        String[] route2 = {"uzhgorod", "lviv", "kyiv"};
        String[] route3 = {"uzhgorod", "ternopil", "kyiv"};

        Train train1 = new Train(1, LocalDateTime.of(2018, 3, 13, 15, 1), route1);
        trains.add(train1);

        Train train2 = new Train(2, LocalDateTime.parse("2018-04-01T03:30"), route2);
        trains.add(train2);

        Train train3 = new Train(3, LocalDateTime.of(2013, 6, 23, 6, 13), route3);
        trains.add(train3);
    }


    public ArrayList<Train> searchTrains(String station1, String station2) {
        for (Train lookThroughTrains : trains) {
            ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(lookThroughTrains.trainStations));
            if (tmp.contains(station1.toLowerCase()) && tmp.contains(station2.toLowerCase()) &&
                    tmp.indexOf(station1.toLowerCase()) < tmp.indexOf(station2.toLowerCase()))
                trainSearcher.add(lookThroughTrains);
        }
        return trainSearcher;
    }

    public boolean dataChecking(int trainNumber, int coachNumber, int placeNumber) {

        if (trainSearcher.size() > trainNumber)
            if (trainSearcher.get(trainNumber).coaches.size() > coachNumber)
                if (trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets.length > placeNumber)

                    //якщо квиток вільний і існує впринципі, то повертає true
                    return trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free;

        return false;
    }

    public void removetrainSearcher() {
        trainSearcher.clear();
    }
}
