package com.cintavra.Train;

import java.util.*;

public class Train {

    private int trainId;
    protected List<Coach> coaches;
    protected List<Station> route;

    Train(int trainId, List<Station> route) {
        this.trainId = trainId;
        this.route.addAll(route);
    }

    public int getTrainId() {
        return trainId;
    }


    public List<Station> getRoute() {
        return route;
    }
}