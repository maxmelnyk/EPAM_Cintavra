package com.cintavra.Train;

public class Ticket {
    public boolean free;
    public String clientName;
    public String startStation;
    public String endStation;

    public Ticket() {
        this.free = true;
    }

    public void buyTicket(String startStation, String endStation, String userName) {
        this.startStation = startStation;
        this.endStation = endStation;
        clientName = userName;
        free = false;
    }
}