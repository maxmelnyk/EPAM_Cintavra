package com.cintavra.Train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Service {
    public static ArrayList<Train> trains = new ArrayList<Train>();
    public static ArrayList<Train> trainSearcher = new ArrayList<Train>();

    public static String[][] createRoutes(){
        return new String[][]{
                {"lviv", "ternopil", "kyiv"},
                {"uzhgorod", "lviv", "kyiv"},
                {"uzhgorod", "ternopil", "kyiv"}
        };
    }
    public static ArrayList<Train> createTrains(){
        String[] timeArray = {"2018-04-01T03:30", "2018-04-01T03:30", "2018-04-01T03:30"};
        String[][] routeArray = createRoutes();
        ArrayList<Train> trains = new ArrayList<Train>();

        for(int i = 0; i < routeArray.length; i++) {

            trains.add(new Train(i+1, LocalDateTime.parse(timeArray[i]), routeArray[i]));
        }

        return trains;
    }

    public static ArrayList<Train> searchTrains(String station1, String station2) {
        for (Train lookThroughTrains : trains) {
            ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(lookThroughTrains.trainStations));
            if (tmp.contains(station1.toLowerCase()) && tmp.contains(station2.toLowerCase()) &&
                    tmp.indexOf(station1.toLowerCase()) < tmp.indexOf(station2.toLowerCase()))
                trainSearcher.add(lookThroughTrains);
        }
        return trainSearcher;
    }

    public static boolean dataChecking(int trainNumber, int coachNumber, int placeNumber) {

        if (trainSearcher.size() > trainNumber)
            if (trainSearcher.get(trainNumber).coaches.size() > coachNumber)
                if (trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets.length > placeNumber)

                    //якщо квиток вільний і існує впринципі, то повертає true
                    return trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free;

        return false;
    }

    public static void removetrainSearcher() {
        trainSearcher.clear();
    }
}
