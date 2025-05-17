package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackStringTest {

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void shouldPushStrings() {
        stack.push("Ana");
        stack.push("Pedro");
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void shouldPopInCorrectOrder() {
        stack.push("First");
        stack.push("Second");
        assertEquals("Second", stack.pop());
        assertEquals("First", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldReturnTopWithoutRemoving() {
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.top());
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
    void shouldClearAllStringsWithDesempilharTudo() {
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        assertEquals(3, stack.size());

        stack.desempilharTudo();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

}
