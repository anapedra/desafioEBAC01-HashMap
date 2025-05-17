package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueDoubleTest {

    private Queue<Double> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void shouldEnqueueDoubles() {
        queue.enqueue(1.5);
        queue.enqueue(2.8);
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldDequeueInFIFOOrder() {
        queue.enqueue(3.14);
        queue.enqueue(2.71);
        assertEquals(3.14, queue.dequeue());
        assertEquals(2.71, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldPeekWithoutRemoving() {
        queue.enqueue(9.99);
        assertEquals(9.99, queue.peek());
        assertEquals(1, queue.size());
    }

    @Test
    void shouldThrowOnPeekWhenEmpty() {
        Exception ex = assertThrows(IllegalStateException.class, queue::peek);
        assertEquals("Queue is empty", ex.getMessage());
    }

    @Test
    void shouldThrowOnDequeueWhenEmpty() {
        Exception ex = assertThrows(IllegalStateException.class, queue::dequeue);
        assertEquals("Queue is empty", ex.getMessage());
    }

    @Test
    void shouldClearQueue() {
        queue.enqueue(7.5);
        queue.enqueue(8.3);
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}
