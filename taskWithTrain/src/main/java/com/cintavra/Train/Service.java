package com.cintavra.Train;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<Train> trainList;
    private List<Ticket> tickets;
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
                        if (placeNumber <= coach.getPlaces().size()) {
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
        if (place.getStartStation() != null && place.getEndStation() != null) {
            replaceStartAndEndStations(trainId, place);
        } else {
            place.setStartStation(userStartStation);
            place.setEndStation(userEndStation);
        }
        Ticket ticket = new Ticket(clientName, trainId, coachId, placeId, userStartStation.getName(), userEndStation.getName());
        tickets.add(ticket);
        ticket.printTicket();
    }

    private void replaceStartAndEndStations(int trainId, Place place) {
        for (Train train : trainList) {
            if (train.getTrainId() == trainId - 1) {
                if (train.getRoute().indexOf(place.getStartStation()) < train.getRoute().indexOf(userStartStation)
                        && train.getRoute().indexOf(place.getEndStation()) <= train.getRoute().indexOf(userStartStation)) {
                    place.setEndStation(userEndStation);
                } else {
                    place.setStartStation(userStartStation);
                }
            }
        }
    }

    public void isPlaceStillFree(List<Train> trainsForUser) {
        for (Train train : trainsForUser) {
            for (Coach coach : train.getCoaches()) {
                for (Place place : coach.getPlaces()) {
                    if (!place.getState()) {
                        if (train.getRoute().indexOf(userStartStation) < train.getRoute().indexOf(place.getStartStation())
                                && train.getRoute().indexOf(userEndStation) <= train.getRoute().indexOf(place.getStartStation())) {
                            place.setState(true);
                        } else if (train.getRoute().indexOf(userStartStation) >= train.getRoute().indexOf(place.getEndStation())
                                && train.getRoute().indexOf(userEndStation) > train.getRoute().indexOf(place.getEndStation())) {
                            place.setState(true);
                        }
                    }
                }
            }
        }
    }

    public void checkTicketState(List<Train> trainsForUser, int trainNumber, int coachNumber, int placeNumber) {
        for (Train train : trainsForUser) {
            if (trainNumber - 1 == train.getTrainId()) {
                for (Coach coach : train.getCoaches()) {
                    if (coachNumber - 1 == coach.getCouchId()) {
                        for (Place place : coach.getPlaces()) {
                            if (place.getId() == placeNumber - 1) {
                                if (place.getStartStation() != null) {
                                    place.setState(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}