package com.cintavra.Train;



public class Ticket {
    protected boolean free;
    protected String clientName;
    protected String startStation;
    protected String endStation;

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