package org.anasantana.service;

import org.anasantana.data_structure.Stack;
import org.anasantana.model.Task;
import org.anasantana.validation.TaskValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskService {

    private final Stack<Task> actionStack;
    private final List<Task> taskList;

    public TaskService(Stack<Task> actionStack) {
        this.actionStack = actionStack;
        this.taskList = new ArrayList<>();
    }

    public Task createTask(String description) {
        Task task = new Task(null, description);
        TaskValidator.validate(task);
        taskList.add(task);
        actionStack.push(task);
        return task;
    }

    public List<Task> listTasks() {
        return Collections.unmodifiableList(taskList);
    }

    public Task undoLastTask() {
        if (actionStack.isEmpty()) {
            throw new IllegalStateException("No actions to undo.");
        }
        Task last = actionStack.pop();
        taskList.remove(last);
        return last;
    }


    public void popAll() {
        actionStack.desempilharTudo();
    }


    public int getUndoStackSize() {
        return actionStack.size();
    }
}
