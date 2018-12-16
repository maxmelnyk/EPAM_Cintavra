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
        this.clientName = userName;
        this.free = false;
    }

    @Override
    public String toString() {
        return "Ticket status:" + free + ", clientName=" + clientName + ", startStation='" + startStation + ", endStation='" + endStation;
    }
}