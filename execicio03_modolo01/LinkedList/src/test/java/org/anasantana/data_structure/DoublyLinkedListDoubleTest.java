package org.anasantana.data_structure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDoubleTest {

    @Test
    void shouldInsertAndRemoveDoubles() {
        DoublyLinkedList<Double> list = new DoublyLinkedList<>();
        list.insert(0, 1.1);
        list.insert(1, 3.3);
        list.insert(1, 2.2);

        assertEquals(1.1, list.get(0));
        assertEquals(2.2, list.get(1));
        assertEquals(3.3, list.get(2));

        assertEquals(2.2, list.remove(1));
        assertEquals(3.3, list.pop());
    }

    @Test
    void shouldHandleEmptyListOperations() {
        DoublyLinkedList<Double> list = new DoublyLinkedList<>();
        assertThrows(IllegalStateException.class, list::pop);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void shouldPrintFormattedList() {
        DoublyLinkedList<Double> list = new DoublyLinkedList<>();
        list.push(5.5);
        list.push(6.6);
        String output = list.printList();
        assertTrue(output.contains("5.5") && output.contains("6.6"));
    }

}
