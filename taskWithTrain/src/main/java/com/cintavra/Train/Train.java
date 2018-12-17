package com.cintavra.Train;

import java.util.ArrayList;
import java.util.Arrays;

public class Train {
    private int countOfCoaches = 1;
    private int trainId;
    protected ArrayList<Coach> coaches = new ArrayList<>();
    protected ArrayList<String> trainListStations = new ArrayList<>();

    Train(int trainId, String[] route) {
        this.trainId = trainId;
        setCoaches();
        this.trainListStations.addAll(Arrays.asList(route));
    }

    public int getTrainId() {
        return trainId;
    }

    private void setCoaches() {
        for (int i = 0; i < countOfCoaches; i++) {
            Coach coach = new Coach();
            coaches.add(coach);
        }
    }
}