package org.anasantana.validetion;

import org.anasantana.model.Ticket;

public class TicketValidator {
    public static void validate(Ticket ticket) {
        if (ticket == null || ticket.getHolder() == null || ticket.getHolder().isBlank()) {
            throw new IllegalArgumentException("Ticket holder cannot be null or blank");
        }
    }
}
