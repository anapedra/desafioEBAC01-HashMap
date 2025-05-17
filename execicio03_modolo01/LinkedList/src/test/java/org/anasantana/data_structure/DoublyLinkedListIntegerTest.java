package org.anasantana.data_structure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListIntegerTest {

    @Test
    void shouldWorkWithIntegers() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        assertEquals(3, list.size());
        assertEquals(2, list.get(1));
        assertEquals(2, list.remove(1));
    }

    @Test
    void shouldHandleInsertAndGet() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(0, 10);
        list.insert(1, 30);
        list.insert(1, 20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void shouldHandleSingleElementPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.push(99);
        assertEquals(99, list.pop());
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldThrowOnInvalidUse() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IllegalStateException.class, list::pop);
    }
}
