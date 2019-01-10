package com.cintavra.Train;

import java.util.*;

public class Train {

    private int trainId;
    private List<Coach> coaches;
    private List<Station> route;

    Train(int trainId, List<Station> route) {
        this.trainId = trainId;
        this.route = route;
        this.coaches = new ArrayList<>();
    }

    public int getTrainId() {
        return trainId;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<Station> getRoute() {
        return route;
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public void printAllCoaches() {
        for (Coach coach : coaches) {
            System.out.println("\nCoach №: " + (coach.getCouchId() + 1));
            coach.printAllFreePlaces();
        }
    }
}
