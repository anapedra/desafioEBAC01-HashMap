package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListIntegerTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void shouldPushAndPopIntegers() {
        list.push(10);
        list.push(20);
        assertEquals(20, list.pop());
        assertEquals(10, list.pop());
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldInsertAndRemove() {
        list.push(1);
        list.insert(1, 2);
        list.insert(2, 3);
        assertEquals(3, list.size());
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void shouldGetElementAt() {
        list.push(100);
        list.push(200);
        assertEquals(200, list.elementAt(1));
    }
}
