package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListStringTest {

    private LinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void shouldPushAndPopStrings() {
        list.push("Ana");
        list.push("Bob");
        assertEquals("Bob", list.pop());
        assertEquals("Ana", list.pop());
        assertTrue(list.size() == 0);
    }

    @Test
    void shouldInsertAndGetElement() {
        list.push("One");
        list.insert(0, "Zero");
        assertEquals("Zero", list.get(0));
    }

    @Test
    void shouldRemoveByIndex() {
        list.push("A");
        list.push("B");
        list.push("C");
        String removed = list.remove(1);
        assertEquals("B", removed);
        assertEquals(2, list.size());
    }

    @Test
    void shouldPrintList() {
        list.push("X");
        list.push("Y");
        assertEquals("[X -> Y]", list.printList());
    }
}
