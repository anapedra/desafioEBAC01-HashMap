package org.anasantana.service;

import org.anasantana.data_structure.Queue;
import org.anasantana.model.Ticket;
import org.anasantana.validetion.TicketValidator;

public class TicketService {

    private final Queue<Ticket> queue = new Queue<>();

    public void addTicket(String holder) {
        Ticket ticket = new Ticket(holder);
        TicketValidator.validate(ticket);
        queue.enqueue(ticket);
    }

    public Ticket nextTicket() {
        return queue.dequeue();
    }

    public Ticket peekNext() {
        return queue.peek();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public int totalWaiting() {
        return queue.size();
    }

    public void clearQueue() {
        queue.clear();
    }
}
