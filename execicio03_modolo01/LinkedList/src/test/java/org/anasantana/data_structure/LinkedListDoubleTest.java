package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDoubleTest {

    private LinkedList<Double> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void shouldPushAndPopDoubles() {
        list.push(3.14);
        list.push(1.618);
        assertEquals(1.618, list.pop());
        assertEquals(3.14, list.pop());
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldInsertAndGetDouble() {
        list.insert(0, 2.5);
        list.insert(1, 4.5);
        assertEquals(4.5, list.get(1));
    }

    @Test
    void shouldRemoveAndPrint() {
        list.push(9.9);
        list.push(8.8);
        list.remove(0);
        assertEquals("[8.8]", list.printList());
    }
}
