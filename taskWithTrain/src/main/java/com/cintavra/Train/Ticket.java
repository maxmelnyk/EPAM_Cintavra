package com.cintavra.Train;



public class Ticket {
    private String clientName;
    private int trainId;
    private int coachId;
    private int placeId;
    private String startStation;
    private String endStation;

    public Ticket(String clientName, int trainId, int coachId, int placeId, String startStation, String endStation) {
        this.clientName = clientName;
        this.trainId = trainId;
        this.coachId = coachId;
        this.placeId = placeId;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public void printTicket() {
        System.out.println("Ticket info:" + "\nclientName ='" + clientName + '\'' +
                ", \ntrainId =" + trainId + ", \ncoachId =" + coachId +
                ", \nplaceId =" + placeId + ", \nfrom =" + startStation +
                " to =" + endStation + '.');
    }
}