package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueStringTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void shouldEnqueueStrings() {
        queue.enqueue("Ana");
        queue.enqueue("Bruno");
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void shouldDequeueInFIFOOrder() {
        queue.enqueue("First");
        queue.enqueue("Second");
        assertEquals("First", queue.dequeue());
        assertEquals("Second", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void shouldPeekWithoutRemoving() {
        queue.enqueue("A");
        assertEquals("A", queue.peek());
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
         queue.enqueue("One");
         queue.enqueue("Two");
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
}
