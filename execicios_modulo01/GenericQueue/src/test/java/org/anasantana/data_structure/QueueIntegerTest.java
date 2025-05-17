package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueIntegerTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void shouldEnqueueIntegers() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldDequeueInFIFOOrder() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldPeekWithoutRemoving() {
        queue.enqueue(99);
        assertEquals(99, queue.peek());
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
        queue.enqueue(100);
        queue.enqueue(200);
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}
