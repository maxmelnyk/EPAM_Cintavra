package com.cintavra.Train;

//TODO тут явно ще щось потрібно дописати
public class Ticket {
    private String id;
    private boolean emptySeat;
    private Client owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEmptySeat() {
        return emptySeat;
    }

    public void setEmptySeat(boolean emptySeat) {
        this.emptySeat = emptySeat;
    }

    public Client getOwner() {
        return owner;
    }
}