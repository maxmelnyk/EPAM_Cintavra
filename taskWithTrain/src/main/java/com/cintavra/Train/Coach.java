package com.cintavra.Train;

public class Coach {
    private final static int AMOUNT_OF_PLACES = 4;
    public int countFreePlace = AMOUNT_OF_PLACES;
    public Ticket[] tickets = new Ticket[AMOUNT_OF_PLACES];

    public Coach() {
        for (int value = 0; value < AMOUNT_OF_PLACES; value++) {
            tickets[value] = new Ticket();
        }
    }

    public int getCountFreePlace() {
        return countFreePlace;
    }

    public int getAmountOfPlaces() {
        return AMOUNT_OF_PLACES;
    }


}