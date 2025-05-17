package org.anasantana.service;

import org.anasantana.data_structure.Stack;
import org.anasantana.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTestComplexity {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService(new Stack<>());
    }

    /**
     * O(1) – Criação da task, validação simples e inserção no final de uma lista + topo da pilha.
     */
    @Test
    void testCreateTaskTimeComplexity() {
        long start = System.nanoTime();
        service.createTask("Learn JUnit");
        long end = System.nanoTime();
        System.out.println("createTask() O(1): " + (end - start) + " ns");
    }

    /**
     * O(1) – Tamanho da pilha é apenas uma variável.
     */
    @Test
    void testGetUndoStackSizeTimeComplexity() {
        service.createTask("T1");
        long start = System.nanoTime();
        int size = service.getUndoStackSize();
        long end = System.nanoTime();
        System.out.println("getUndoStackSize() O(1): " + (end - start) + " ns | size=" + size);
    }

    /**
     * O(1) – Apenas retorna a lista imutável; não percorre nem copia.
     */
    @Test
    void testListTasksTimeComplexity() {
        IntStream.range(0, 100).forEach(i -> service.createTask("Task " + i));
        long start = System.nanoTime();
        List<Task> tasks = service.listTasks();
        long end = System.nanoTime();
        System.out.println("listTasks() O(1): " + (end - start) + " ns | list size=" + tasks.size());
    }

    /**
     * O(n) – remove(task) em ArrayList requer busca linear + realocação.
     */
    @Test
    void testUndoLastTaskTimeComplexity() {
        IntStream.range(0, 1000).forEach(i -> service.createTask("Task " + i));
        long start = System.nanoTime();
        Task last = service.undoLastTask();
        long end = System.nanoTime();
        System.out.println("undoLastTask() O(n): " + (end - start) + " ns | removed=" + last.getDescription());
    }

    /**
     * O(n) – desempilhar tudo da pilha.
     */
    @Test
    void testPopAllTimeComplexity() {
        IntStream.range(0, 5000).forEach(i -> service.createTask("PopAll Task " + i));
        long start = System.nanoTime();
        service.popAll();
        long end = System.nanoTime();
        System.out.println("popAll() O(n): " + (end - start) + " ns");
    }

    /**
     * O(1) – Testa a exceção lançada ao tentar fazer pop com pilha vazia.
     */
    @Test
    void testUndoWithEmptyStackThrowsQuickly() {
        long start = System.nanoTime();
        Exception ex = assertThrows(IllegalStateException.class, service::undoLastTask);
        long end = System.nanoTime();
        System.out.println("undoLastTask() [empty stack] O(1): " + (end - start) + " ns | msg=" + ex.getMessage());
    }

    /**
     * O(1) – Validação por string simples + throw.
     */
    @Test
    void testCreateTaskWithInvalidDescription() {
        long start = System.nanoTime();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.createTask("   "));
        long end = System.nanoTime();
        System.out.println("createTask() [invalid desc] O(1): " + (end - start) + " ns | msg=" + ex.getMessage());
    }
}
