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
        this.tickets = new ArrayList<>();
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
        train1.addCoach(createCoach(0));
        train1.addCoach(createCoach(1));
        train1.addCoach(createCoach(2));
        trainList.add(train1);
        Train train2 = new Train(2, createRoutes(2));
        train2.addCoach(createCoach(0));
        train2.addCoach(createCoach(1));
        train2.addCoach(createCoach(2));
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
                    if (coachNumber - 1 == coach.getCouchId()) {
                        if (placeNumber < coach.getPlaces().size())
                        {
                            System.out.println(coach.getPlaces().get(placeNumber - 1).getState());
                            return coach.getPlaces().get(placeNumber - 1).getState();
                        }
                    }
                }
            }
        }

        return false;
    }

    public void showAllPlaceInTrains(List<Train> trainsForUser) {
        for (Train train : trainsForUser) {
            System.out.print("Train number: " + (train.getTrainId() + 1));
            train.printAllCoaches();
            System.out.println();
            System.out.println();
        }
    }

    public void buyTicket(String clientName, int trainId, int coachId, int placeId) {
        Place place = trainList.get(trainId - 1).getCoaches().get(coachId - 1).getPlaces().get(placeId - 1);
        place.setState(false);
        Ticket ticket = new Ticket(clientName, trainId - 1, coachId - 1, placeId - 1, userStartStation.getName(), userEndStation.getName());
        tickets.add(ticket);
        ticket.printTicket();
    }

    /*public void isPlaceStillFree(List<Train> trainsForUser) {
        int count = 0;
        for (Train train :trainsForUser) {
            for (Ticket ticket :tickets) {
                if(train.getTrainId() == ticket.getTrainId()) {
                   if ((train.getRoute().get(0) != userStartStation) && (train.getRoute().get(train.getRoute().size() - 1) != userEndStation)){
                       for (Station station :train.getRoute()) {
                           if (station.getName().equals(ticket.getStartStation())){
                               if (train.getRoute().indexOf(station) > train.getRoute().indexOf(userStartStation) && train.getRoute().indexOf(station) > train.getRoute().indexOf(userEndStation)){
                                   train.getCoaches().get(ticket.getCoachId()).getPlaces().get(ticket.getPlaceId()).setState(true);
                                   System.out.println("1 1");
                               }
                           } else if(station.getName().equals(ticket.getEndStation())) {
                                if (train.getRoute().indexOf(new Station(ticket.getEndStation())) < train.getRoute().indexOf(userStartStation) && train.getRoute().indexOf(new Station(ticket.getEndStation())) < train.getRoute().indexOf(userEndStation)){
                                   train.getCoaches().get(ticket.getCoachId()).getPlaces().get(ticket.getPlaceId()).setState(true);
                                   System.out.println("2 22 2 2 2 2");
                               }
                           }

                       }
                   }
                }
            }
        }
    }*/

    /*public void checkTicketState() {
        Ticket ticket = trainsForClient.get(trainNumber).coaches.get(coachNumber).tickets[placeNumber];
        if (!ticket.startStation.isEmpty()) {
            ticket.free = false;
        }
    }*/
}