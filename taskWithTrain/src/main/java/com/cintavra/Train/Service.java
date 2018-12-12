package com.cintavra.Train;

import java.util.ArrayList;

public class Service {
    private ArrayList<Train> trains = new ArrayList<>();
    public ArrayList<Train> trainSearcher = new ArrayList<>();

    public Service() {

        setTrains();
    }

    private static String[][] createRoutes() {

        return new String[][]{
                {"lviv", "ternopil", "kyiv"},
                {"uzhgorod", "lviv", "kyiv"},
                {"uzhgorod", "ternopil", "kyiv"}
        };
    }

    private void setTrains() {

        String[][] routeArray = createRoutes();
//        String[] timeArray = {"2018-04-01T03:30", "2018-04-01T03:30", "2018-04-01T03:30"};

        for (int i = 0; i < routeArray.length; i++) {

            trains.add(new Train(i + 1, /*LocalDateTime.parse(timeArray[i]),*/ routeArray[i]));
        }
    }

    public ArrayList<Train> searchTrains(String station1, String station2) {
        for (Train lookThroughTrains : trains) {
            ArrayList<String> tmp = new ArrayList<>(lookThroughTrains.trainStations);
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
                    return trainSearcher.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free; /*true*/ //Якщо поставити true, то враховуватиме можливість замовлення зайнятого квитка, але завжди виводитиме усі квитки.

        return false;
    }

    public void removeTrainSearcher() {

        trainSearcher.clear();
    }

    public void showAllPlaceInTrain(String startStation, String endStation, Train train) {

        int printDataAboutTrain = 0;

        for (Coach coach : train.coaches) {
            if (coach.getCountFreePlace() != 0) {
                if(printDataAboutTrain == 0) {
                    System.out.print("Train number: " + train.getTrainId()/* + " (DateTime: " + date + ")"*/);
                    printDataAboutTrain++;
                }
                System.out.print("\nCoach number: " + (train.coaches.indexOf(coach) + 1));
                showFreePlace(startStation, endStation, train.trainStations, coach);
            }
        }

        if(printDataAboutTrain == 1) {
            System.out.println();
            System.out.println();
        }
    }

    public void choosePlaceInTrain(int trainNumber, int numberCoach, int numberPlace, String startStation, String endStation, String userName) {

        Coach foundCoach = trainSearcher.get(trainNumber).coaches.get(numberCoach);
        buyPlace(numberPlace, startStation, endStation, trainSearcher.get(trainNumber).trainStations, userName, foundCoach);
    }

    public void buyPlace(int numberPlace, String startStation, String endStation, ArrayList<String> stations, String userName, Coach coach) {

        if (!coach.tickets[numberPlace].free) {
            if (stations.indexOf(startStation) < stations.indexOf(coach.tickets[numberPlace].startStation) && stations.indexOf(endStation) <= stations.indexOf(coach.tickets[numberPlace].startStation)) {

                coach.tickets[numberPlace].startStation = startStation;
            } else if (stations.indexOf(startStation) >= stations.indexOf(coach.tickets[numberPlace].endStation) && stations.indexOf(endStation) > stations.indexOf(coach.tickets[numberPlace].endStation)) {

                coach.tickets[numberPlace].endStation = endStation;
            }
        }

        coach.tickets[numberPlace].buyTicket(startStation, endStation, userName);
        coach.countFreePlace--;
    }

    public void showFreePlace(String startStation, String endStation, ArrayList<String> stations, Coach coach) {

        System.out.print("\nPlace num: ");

        for (int i = 0; i < coach.getAmountOfPlaces(); i++) {
            if (coach.tickets[i].free) {

                System.out.print((i + 1) + " ");
            } else if (!coach.tickets[i].free) {

                isFree(startStation, endStation, stations, coach.tickets[i], i);
            }
        }
    }

    private void isFree(String startStation, String endStation, ArrayList<String> stations, Ticket ticket, int i) {

        if (stations.indexOf(startStation) < stations.indexOf(ticket.startStation) && stations.indexOf(endStation) <= stations.indexOf(ticket.startStation)) {

            System.out.print((i + 1) + " ");
        } else if (stations.indexOf(startStation) >= stations.indexOf(ticket.endStation) && stations.indexOf(endStation) > stations.indexOf(ticket.endStation)) {

            System.out.print((i + 1) + " ");
        }
    }
}