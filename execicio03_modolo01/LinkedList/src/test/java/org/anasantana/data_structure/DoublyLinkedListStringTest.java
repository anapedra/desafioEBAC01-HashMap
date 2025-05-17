package org.anasantana.data_structure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListStringTest {

    @Test
    void shouldPushAndPopStrings() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("Ana");
        list.push("Pedro");
        assertEquals("Pedro", list.pop());
        assertEquals("Ana", list.pop());
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldInsertAtBeginningMiddleAndEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insert(0, "First");
        list.insert(1, "Third");
        list.insert(1, "Second");

        assertEquals("First", list.get(0));
        assertEquals("Second", list.get(1));
        assertEquals("Third", list.get(2));
    }

    @Test
    void shouldRemoveFromBeginningMiddleAndEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("A");
        list.push("B");
        list.push("C");
        assertEquals("B", list.remove(1));
        assertEquals("C", list.remove(1));
        assertEquals("A", list.remove(0));
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldThrowWhenPoppingEmpty() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        assertThrows(IllegalStateException.class, list::pop);
    }

    @Test
    void shouldThrowOnInvalidIndexes() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.push("OnlyOne");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(3, "X"));
    }
}
