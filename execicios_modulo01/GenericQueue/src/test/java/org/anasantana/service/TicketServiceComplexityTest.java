package org.anasantana.service;

import org.junit.jupiter.api.Test;

public class TicketServiceComplexityTest {

    /**
     * O(1) – Inserir no final da fila.
     */
    @Test
    void testAddTicketTimeComplexity() {
        TicketService service = new TicketService();

        long start = System.nanoTime();
        service.addTicket("User A");
        long end = System.nanoTime();

        System.out.println("addTicket() O(1): " + (end - start) + " ns");
    }

    /**
     * O(1) – Remover do início da fila.
     */
    @Test
    void testNextTicketTimeComplexity() {
        TicketService service = new TicketService();
        service.addTicket("User B");

        long start = System.nanoTime();
        service.nextTicket();
        long end = System.nanoTime();

        System.out.println("nextTicket() O(1): " + (end - start) + " ns");
    }

    /**
     * O(1) – Consultar quem está no início da fila, sem remover.
     */
    @Test
    void testPeekNextTimeComplexity() {
        TicketService service = new TicketService();
        service.addTicket("User C");

        long start = System.nanoTime();
        service.peekNext();
        long end = System.nanoTime();

        System.out.println("peekNext() O(1): " + (end - start) + " ns");
    }

    /**
     * O(n) – Esvaziar toda a fila (remover todos os elementos).
     */
    @Test
    void testClearQueueTimeComplexity() {
        TicketService service = new TicketService();

        for (int i = 0; i < 1000; i++) {
            service.addTicket("User " + i);
        }

        long start = System.nanoTime();
        service.clearQueue();  // presume-se que limpa todos os elementos
        long end = System.nanoTime();

        System.out.println("clearQueue() O(n): " + (end - start) + " ns");
    }

    /**
     * O(1) – Verificar se a fila está vazia.
     */
    @Test
    void testIsQueueEmptyTimeComplexity() {
        TicketService service = new TicketService();

        long start = System.nanoTime();
        service.isQueueEmpty();
        long end = System.nanoTime();

        System.out.println("isQueueEmpty() O(1): " + (end - start) + " ns");
    }
}
