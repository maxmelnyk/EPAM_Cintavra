package com.cintavra.Train;

import java.util.*;

public class Train {

    private int trainId;
<<<<<<< HEAD
//    public LocalDateTime date;
    protected ArrayList<Coach> coaches = new ArrayList<>();
    protected ArrayList<String> trainListStations = new ArrayList<>();
=======
    private List<Coach> coaches;
    private List<Station> route;
>>>>>>> origin

    Train(int trainId, List<Station> route) {
        this.trainId = trainId;
<<<<<<< HEAD
        setCoaches();
//        this.date = date;
        this.trainListStations.addAll(Arrays.asList(route));
=======
        this.route = route;
        this.coaches = new ArrayList<>();
    }
>>>>>>> origin

    public int getTrainId() {
        return trainId;
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public List<Station> getRoute() {
        return route;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void printAllCoaches() {
        for (Coach coach : coaches) {
            System.out.println("\nCoach number: " + (coach.getCouchId() + 1));
            coach.printAllFreePlaces();
        }
    }
}
