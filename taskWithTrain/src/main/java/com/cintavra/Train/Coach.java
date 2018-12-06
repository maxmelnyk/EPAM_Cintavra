package com.cintavra.Train;

public class Coach {
    final private static int AMOUNT_OF_PLACES = 4;
    private Ticket tickets[];

    public void createFreeTickets() {
        Ticket tickets[] = new Ticket[AMOUNT_OF_PLACES];

        for(int i = 0; i < AMOUNT_OF_PLACES; i++){
            Ticket ticket = new Ticket(true);  //ініціалізація даних про квиток
            //додаємо в масив квитків
        }

        this.tickets = tickets;
    }
}
