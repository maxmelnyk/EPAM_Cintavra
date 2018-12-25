package com.cintavra.Train;

public class Place {
    private int id;
    private boolean state;
    private Station startStation;
    private Station endStation;

    public Place(int id, boolean state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getEndStation() {
        return endStation;
    }
}
