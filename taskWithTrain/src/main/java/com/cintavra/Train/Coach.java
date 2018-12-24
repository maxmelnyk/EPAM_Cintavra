package com.cintavra.Train;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private int couchId;
    public List<Place> places;

    public Coach(int couchId, List<Place> places) {
        this.couchId = couchId;
        this.places = places;
    }

    public List<Place> getTickets() {
        return places;
    }

    public int getCouchId() {
        return couchId;
    }
}