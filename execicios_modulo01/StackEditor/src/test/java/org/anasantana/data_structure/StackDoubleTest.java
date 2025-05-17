package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackDoubleTest {

    private Stack<Double> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void shouldPushDoubles() {
        stack.push(1.1);
        stack.push(2.2);
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldPopInCorrectOrder() {
        stack.push(3.14);
        stack.push(2.71);
        assertEquals(2.71, stack.pop());
        assertEquals(3.14, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldReturnTopWithoutRemoving() {
        stack.push(9.99);
        stack.push(8.88);
        assertEquals(8.88, stack.top());
        assertEquals(2, stack.size());
    }

    @Test
    void shouldThrowOnPopWhenEmpty() {
        Exception ex = assertThrows(IllegalStateException.class, () -> stack.pop());
        assertEquals("Stack is empty", ex.getMessage());
    }

    @Test
    void shouldThrowOnTopWhenEmpty() {
        Exception ex = assertThrows(IllegalStateException.class, () -> stack.top());
        assertEquals("Stack is empty", ex.getMessage());
    }

    @Test
    void shouldClearAllDoublesWithDesempilharTudo() {
        stack.push(10.0);
        stack.push(20.5);
        stack.push(30.7);

        assertEquals(3, stack.size());

        stack.desempilharTudo();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

}
