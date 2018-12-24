package com.cintavra.Train;

import java.util.ArrayList;
import java.util.List;


public class Service {
    public List<Train> trainList;
    public List<Ticket> tickets;
    private Station userStartStation;
    private Station userEndStation;

    public Service() {
        this.trainList = createTrainList();
    }

    private Coach createCoach(int id) {
        List<Place> places = new ArrayList<>();
        for (int i = 0; i < CoachType.Simple.getCapacity(); i++) {
            places.add(new Place(i, true));
        }

        return new Coach(id, CoachType.Simple, places);
    }

    private List<Train> createTrainList() {
        List<Train> trainList = new ArrayList<>();

        Train train = new Train(0, createRoutes(0));
        train.addCoach(createCoach(0));
        train.addCoach(createCoach(1));
        train.addCoach(createCoach(2));
        trainList.add(train);
        Train train1 = new Train(1, createRoutes(1));
        train.addCoach(createCoach(0));
        train.addCoach(createCoach(1));
        train.addCoach(createCoach(2));
        trainList.add(train1);
        Train train2 = new Train(2, createRoutes(2));
        train.addCoach(createCoach(0));
        train.addCoach(createCoach(1));
        train.addCoach(createCoach(2));
        trainList.add(train2);

        return trainList;
    }

    private List<Station> createRoutes(int trainId) {
        List<Station> route = new ArrayList<>();

        switch (trainId) {
            case 0: {
                route.add(new Station("lviv"));
                route.add(new Station("ternopil"));
                route.add(new Station("kyiv"));
                break;
            }
            case 1: {
                route.add(new Station("uzhgorod"));
                route.add(new Station("lviv"));
                route.add(new Station("kyiv"));
                break;
            }
            case 2: {
                route.add(new Station("uzhgorod"));
                route.add(new Station("ternopil"));
                route.add(new Station("kyiv"));
                break;
            }
        }

        return route;
    }

    public List<Train> findTrainsForUser(String startSt, String endSt) {
        this.userStartStation = new Station(startSt);
        this.userEndStation = new Station(endSt);
        List<Train> trainsForUser = new ArrayList<>();

        for (Train train : trainList) {
            if (train.getRoute().contains(userStartStation)
                    && train.getRoute().contains(userEndStation)
                    && train.getRoute().indexOf(userStartStation) < train.getRoute().indexOf(userEndStation)) {
                trainsForUser.add(train);
            }
        }

        return trainsForUser;
    }

    public boolean checkEnteredData(int trainNumber, int coachNumber, int placeNumber, List<Train> trainsForUser) {
        for (Train train : trainsForUser) {
            if (trainNumber - 1 == train.getTrainId()) {
                for (Coach coach : train.getCoaches()) {
                    if (coachNumber <= coach.getCouchId()) {
                        if (placeNumber < coach.getPlaces().size())
                            return coach.getPlaces().get(placeNumber).getState();
                    }
                }
            }
        }

        return false;
    }

    public void showAllPlaceInTrains(List<Train> trainsForUser) {
        for (Train train : trainsForUser) {
            System.out.print("Train number: " + train.getTrainId() + 1);
            train.printAllCoaches();
            System.out.println();
            System.out.println();
        }
    }

    public void buyTicket() {
        Ticket ticket = new Ticket();
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