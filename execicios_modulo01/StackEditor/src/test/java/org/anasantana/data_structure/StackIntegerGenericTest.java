package org.anasantana.data_structure;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackIntegerGenericTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void shouldPushIntegers() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldPopInCorrectOrder() {
        stack.push(5);
        stack.push(9);
        assertEquals(9, stack.pop());
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldPeekTopWithoutRemoving() {
        stack.push(33);
        stack.push(44);
        assertEquals(44, stack.top());
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
}






