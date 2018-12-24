package com.cintavra.Train;

import java.util.ArrayList;
import java.util.List;


public class Service {
    public List<Train> trainList;
    public List<Ticket> tickets;

    public Service() {
        createTrainList();
    }

    public ArrayList<Train> getTrainList() {
        return trainList;
    }

    public void createTrainList() {
        String[][] routeArray = createRoutes();
        for (int i = 0; i < routeArray.length; i++) {
            trainList.add(new Train(i + 1, routeArray[i]));
        }
    }

    public String[][] createRoutes() {
        return new String[][]{
                {"lviv", "ternopil", "kyiv"},
                {"uzhgorod", "lviv", "kyiv"},
                {"uzhgorod", "ternopil", "kyiv"},
                {"kyiv", "ternopil", "lviv"},
                {"kyiv", "lviv", "uzhgorod"},
                {"kyiv", "ternopil", "uzhgorod"},
                {"kyiv", "ternopil", "zhytomyr", "uzhgorod"},
                {"uzhgorod", "zhytomyr", "ternopil", "kyiv"}
        };
    }

    public ArrayList<Train> searchAppropriateTrain() {
        for (Train train : trainList) {
            if (train.trainListStations.contains(startStation.toLowerCase())
                    && train.trainListStations.contains(endStation.toLowerCase())
                    && train.trainListStations.indexOf(startStation.toLowerCase()) < train.trainListStations.indexOf(endStation.toLowerCase())) {
                trainsForClient.add(train);
            }
        }
        return trainsForClient;
    }

    public boolean checkEnteredData() {
        for (Train train : trainList) {
            if (trainNumber == trainList.indexOf(train) && trainsForClient.contains(train)) {
                if (coachNumber <= train.coaches.size() && train.coaches.get(coachNumber).tickets.length > placeNumber) {
                    return trainList.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber].free;
                }
            }
        }
        return false;
    }

    public void removeTrainsForClient() {
        trainsForClient.clear();
    }

    public void showAllPlaceInTrain() {
        for (Train train : trainsForClient) {
            int printDataAboutTrain = 0;
            for (Coach coach : train.coaches) {
                if (coach.getCountFreePlace() != 0) {
                    if (printDataAboutTrain == 0) {
                        System.out.print("Train number: " + train.getTrainId());
                        printDataAboutTrain++;
                    }
                    System.out.print("\nCoach number: " + (train.coaches.indexOf(coach) + 1));
                    showFreePlace(train.trainListStations, coach);
                }
            }
            if (printDataAboutTrain == 1) {
                System.out.println();
                System.out.println();
            }
        }
    }

    public void buyPlace() {
        Train train = trainList.get(trainNumber);
        if (!train.coaches.get(coachNumber).tickets[placeNumber].free) {
            if (train.trainListStations.indexOf(startStation) < train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].startStation) && train.trainListStations.indexOf(endStation) <= train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].startStation)) {
                train.coaches.get(coachNumber).tickets[placeNumber].startStation = startStation;
            } else if (train.trainListStations.indexOf(startStation) >= train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].endStation) && train.trainListStations.indexOf(endStation) > train.trainListStations.indexOf(train.coaches.get(coachNumber).tickets[placeNumber].endStation)) {
                train.coaches.get(coachNumber).tickets[placeNumber].endStation = endStation;
            }
        }
        train.coaches.get(coachNumber).tickets[placeNumber].buyTicket(startStation, endStation, userName);
        train.coaches.get(coachNumber).countFreePlace--;
    }

    public void showFreePlace(ArrayList<String> stations, Coach coach) {
        System.out.print("\nPlace num: ");
        for (int i = 0; i < coach.getAmountOfPlaces(); i++) {
            if (coach.tickets[i].free) {
                System.out.print((i + 1) + " ");
            } else if (!coach.tickets[i].free) {
                isPlaceStillFree(stations, coach.tickets[i]);
            }
        }
    }

    public void isPlaceStillFree(ArrayList<String> stations, Ticket ticket) {
        int count = 0;
        if (stations.indexOf(startStation) < stations.indexOf(ticket.startStation) && stations.indexOf(endStation) <= stations.indexOf(ticket.startStation)) {
            ticket.free = true;
            System.out.print((count + 1) + " ");
        } else if (stations.indexOf(startStation) >= stations.indexOf(ticket.endStation) && stations.indexOf(endStation) > stations.indexOf(ticket.endStation)) {
            ticket.free = true;
            System.out.print((count + 1) + " ");
        }
    }

    public void checkTicketState() {
        Ticket ticket = trainsForClient.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber];
        if (!ticket.startStation.isEmpty()) {
            ticket.free = false;
        }
    }

}