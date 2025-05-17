package org.anasantana.service;
import org.anasantana.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        org.anasantana.data_structure.Stack<Task> customStack = new org.anasantana.data_structure.Stack<>();
        service = new TaskService(customStack);
    }


    @Test
    void shouldCreateValidTask() {
        Task task = service.createTask("Learn JUnit");
        assertNotNull(task);
        assertEquals("Learn JUnit", task.getDescription());
        assertEquals(1, service.listTasks().size());
        assertEquals(1, service.getUndoStackSize());
    }

    @Test
    void shouldThrowExceptionWhenTaskIsNull() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.createTask(null);
        });
        assertEquals("Task description cannot be empty.", ex.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsEmpty() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            service.createTask("   ");
        });
        assertEquals("Task description cannot be empty.", ex.getMessage());
    }

    @Test
    void shouldUndoLastTaskSuccessfully() {
        Task task1 = service.createTask("First");
        Task task2 = service.createTask("Second");

        Task undone = service.undoLastTask();

        assertEquals("Second", undone.getDescription());
        assertEquals(1, service.listTasks().size());
        assertEquals(1, service.getUndoStackSize());
    }

    @Test
    void shouldThrowExceptionWhenUndoingWithoutTasks() {
        Exception ex = assertThrows(IllegalStateException.class, () -> {
            service.undoLastTask();
        });
        assertEquals("No actions to undo.", ex.getMessage());
    }

    @Test
    void shouldReturnCorrectUndoStackSize() {
        assertEquals(0, service.getUndoStackSize());
        service.createTask("Task 1");
        service.createTask("Task 2");
        assertEquals(2, service.getUndoStackSize());
    }

    @Test
    void shouldListAllCreatedTasks() {
        service.createTask("Task A");
        service.createTask("Task B");

        List<Task> tasks = service.listTasks();
        assertEquals(2, tasks.size());
        assertEquals("Task A", tasks.get(0).getDescription());
        assertEquals("Task B", tasks.get(1).getDescription());
    }


    @Test
    void shouldClearUndoStackWithDesempilharTudo() {
        service.createTask("Task 1");
        service.createTask("Task 2");
        service.createTask("Task 3");

        assertEquals(3, service.getUndoStackSize());

        service.popAll();

        assertEquals(0, service.getUndoStackSize());
    }



}
