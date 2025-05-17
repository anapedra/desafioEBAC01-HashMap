package org.anasantana.data_structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListIntegerComplexityTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    /**
     * O(n) – Inserção no final da lista (precisa percorrer até o último nó).
     */
    @Test
    void testPushTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            list.push(i);
        }

        long start = System.nanoTime();
        list.push(1001);
        long end = System.nanoTime();
        System.out.println("push() O(n): " + (end - start) + " ns");
    }

    /**
     * O(n) – Remoção do último elemento (precisa do penúltimo para remover).
     */
    @Test
    void testPopTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            list.push(i);
        }

        long start = System.nanoTime();
        list.pop();
        long end = System.nanoTime();
        System.out.println("pop() O(n): " + (end - start) + " ns");
    }

    /**
     * O(n) – Insere em uma posição específica, percorrendo até o índice.
     */
    @Test
    void testInsertTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            list.push(i);
        }

        long start = System.nanoTime();
        list.insert(500, 9999);
        long end = System.nanoTime();
        System.out.println("insert(index) O(n): " + (end - start) + " ns");
    }

    /**
     * O(n) – Remove da posição informada, exige caminhada até o índice.
     */
    @Test
    void testRemoveTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            list.push(i);
        }

        long start = System.nanoTime();
        list.remove(500);
        long end = System.nanoTime();
        System.out.println("remove(index) O(n): " + (end - start) + " ns");
    }

    /**
     * O(n) – Acesso a um elemento específico requer caminhada até o índice.
     */
    @Test
    void testElementAtTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            list.push(i);
        }

        long start = System.nanoTime();
        list.elementAt(999);
        long end = System.nanoTime();
        System.out.println("elementAt(index) O(n): " + (end - start) + " ns");
    }

    /**
     * O(1) – Consulta direta ao tamanho da lista.
     */
    @Test
    void testSizeTimeComplexity() {
        for (int i = 0; i < 1000; i++) {
            list.push(i);
        }

        long start = System.nanoTime();
        int size = list.size();
        long end = System.nanoTime();
        System.out.println("size() O(1): " + (end - start) + " ns | size=" + size);
    }
}
