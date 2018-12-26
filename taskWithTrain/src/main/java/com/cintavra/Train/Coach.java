package com.cintavra.Train;

import java.util.List;

public class Coach {
    private int couchId;
    private CoachType coachType;
    private List<Place> places;

    public Coach(int couchId, CoachType coachType, List<Place> places) {
        this.couchId = couchId;
        this.coachType = coachType;
        this.places = places;
    }

    public int getCouchId() {
        return couchId;
    }

    public List<Place> getPlaces() {
        return places;
    }


    public void printAllFreePlaces() {
        System.out.print("Free places: ");
        for (Place place : places) {
            if (place.getState())
                System.out.print((place.getId() + 1) + " ");
        }
    }
}