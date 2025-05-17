package org.anasantana.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.anasantana.model.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {

    private TicketService service;

    @BeforeEach
    void setUp() {
        service = new TicketService();
    }

    @Test
    void shouldAddValidTickets() {
        service.addTicket("Alice");
        service.addTicket("Bob");
        assertEquals(2, service.totalWaiting());
    }

    @Test
    void shouldReturnNextTicketInFIFOOrder() {
        service.addTicket("John");
        service.addTicket("Jane");

        Ticket first = service.nextTicket();
        assertEquals("John", first.getHolder());

        Ticket second = service.nextTicket();
        assertEquals("Jane", second.getHolder());

        assertTrue(service.isQueueEmpty());
    }

    @Test
    void shouldPeekNextTicketWithoutRemoving() {
        service.addTicket("Carlos");
        assertEquals("Carlos", service.peekNext().getHolder());
        assertEquals(1, service.totalWaiting());
    }

    @Test
    void shouldThrowWhenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, () -> service.nextTicket());
        assertThrows(IllegalStateException.class, () -> service.peekNext());
    }

    @Test
    void shouldClearQueueSuccessfully() {
        service.addTicket("User1");
        service.addTicket("User2");
        service.clearQueue();
        assertTrue(service.isQueueEmpty());
    }
}
