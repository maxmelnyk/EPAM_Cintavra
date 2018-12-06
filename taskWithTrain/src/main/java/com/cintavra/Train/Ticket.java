package com.cintavra.Train;

public class Ticket {
    private boolean free;
    private Client owner;

    public Ticket(boolean free) {
        this.free = free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}