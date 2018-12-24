package com.cintavra.Train;

public class Ticket {
    private String clientName;
    private int trainId;
    private int coachId;
    private int placeId;
    protected String startStation;
    protected String endStation;

    public Ticket(String clientName, int trainId, int coachId, int placeId, String startStation, String endStation) {
        this.clientName = clientName;
        this.trainId = trainId;
        this.coachId = coachId;
        this.placeId = placeId;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }



    private void printTicket() {
        System.out.println("Ticket info:" + "\nclientName='" + clientName + '\'' +
                ", \ntrainId=" + trainId + ", \ncoachId=" + coachId +
                ", \nplaceId=" + placeId + ", \nstartStatione=" + startStation + '.');
    }
}