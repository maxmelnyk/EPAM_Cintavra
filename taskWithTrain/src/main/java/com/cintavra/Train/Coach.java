package com.cintavra.Train;

import java.util.ArrayList;

public class Coach {
    private static final int AMOUNT_OF_PLACES = 4;
    private Ticket ticket;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    //перевіряємо чи квитки не заброньовані, якщо вільні, то додаємо до списку вільних
    public ArrayList<Ticket> getFreeTicketsList() {
        for (int i = 0; i < AMOUNT_OF_PLACES; i++) {
            if (ticket.isEmptySeat()) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }
}
