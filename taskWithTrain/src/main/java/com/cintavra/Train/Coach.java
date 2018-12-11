package com.cintavra.Train;

import java.util.ArrayList;

public class Coach {
    final private static int AMOUNT_OF_PLACES = 4;
    private int countFreePlace = AMOUNT_OF_PLACES;
    public Ticket[] tickets = new Ticket[AMOUNT_OF_PLACES];

    public Coach() {
        for (int value = 0; value < AMOUNT_OF_PLACES; value++) {
            tickets[value] = new Ticket();
        }
    }

    public void buyPlace(int numberPlace, String[] stations, String startStation, String endStation) {

        countFreePlace--;
        tickets[numberPlace].buyTicket(stations, startStation, endStation);
    }

    public void showFreePlace(String startStation, String endStation, String[] stations) {

        System.out.print("\nPlace num: ");

        for (int i = 0; i < AMOUNT_OF_PLACES; i++) {
            if (tickets[i].free == true) {

                System.out.print((i + 1) + " ");
            } else if (tickets[i].free == false) {

                tickets[i].isFree(startStation, endStation, stations, i);
            }
        }
    }

    public int getCountFreePlace() {

        return countFreePlace;
    }
}
