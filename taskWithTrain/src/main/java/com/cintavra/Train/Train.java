package com.cintavra.Train;

import java.util.*;

public class Train {

    private int trainId;
    private List<Coach> coaches;
    private List<Station> route;

    Train(int trainId, List<Station> route) {
        this.trainId = trainId;
        this.route.addAll(route);
    }

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
            System.out.println("Coach number: " + (coach.getCouchId() + 1));
            coach.printAllFreePlaces();
        }
    }
}