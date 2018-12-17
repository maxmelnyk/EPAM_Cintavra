package com.cintavra.Train;

public class Coach {
    private int amountOfPlaces = 4;
    public int countFreePlace = amountOfPlaces;
    public Ticket[] tickets = new Ticket[amountOfPlaces];

    public Coach() {
        setTickets();
    }

    public void setTickets() {
        for (int value = 0; value < amountOfPlaces; value++) {
            tickets[value] = new Ticket();
        }
    }

    public int getCountFreePlace() {
        return countFreePlace;
    }

    public int getAmountOfPlaces() {
        return amountOfPlaces;
    }
}