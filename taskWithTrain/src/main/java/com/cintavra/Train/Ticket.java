package com.cintavra.Train;

import java.util.Arrays;

public class Ticket {
    public boolean free;
    private String clientName;
    public boolean[] stations;
    public String startStation;
    public String endStation;

    public Ticket() {
        this.free = true;
    }

    public void buyTicket(String[] stations, String startStation, String endStation) {
        free = false;
        this.startStation = startStation;
        this.endStation = endStation;

        int begin = Arrays.asList(stations).indexOf(startStation);
        int end = Arrays.asList(stations).indexOf(endStation);

        this.stations = new boolean[stations.length];

        for (int j = begin; j <= end; j++) {
            this.stations[j] = false;
        }
    }

    public void posibleToBeFree(String startStation, String endStation, String[] stations, int index) {
        int begin = Arrays.asList(stations).indexOf(startStation);
        int end = Arrays.asList(stations).indexOf(endStation);
        int impossible = 0;

        for (int i = begin + 1; i < end; i++) {
            if (this.stations[i] == false) {
                impossible = 1;
                break;
            }
        }

        if (impossible == 0) {
            System.out.print((index + 1) + " ");
            this.free = true;
        }
    }


}