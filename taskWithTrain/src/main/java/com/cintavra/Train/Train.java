package com.cintavra.Train;

import java.util.ArrayList;
import java.util.Arrays;


public class Train {
    private final static int COUNT_OF_COACHES = 1;
    private int trainId;
    public ArrayList<Coach> coaches = new ArrayList();
    public ArrayList<String> trainStations = new ArrayList();

    Train(int trainId, String[] route) {
        createCoaches();
        this.trainId = trainId;
        this.trainStations.addAll(Arrays.asList(route));
    }

    public ArrayList<Coach> createCoaches() {
        for (int i = 0; i < COUNT_OF_COACHES; i++) {
            Coach coach = new Coach();
            coaches.add(coach);
        }
        return coaches;
    }

    public int getTrainId() {
        return trainId;
    }
}