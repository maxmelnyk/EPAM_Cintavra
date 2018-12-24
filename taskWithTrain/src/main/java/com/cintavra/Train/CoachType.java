package com.cintavra.Train;

public enum CoachType {

    Simple(34);
    private int capacity;

    CoachType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}