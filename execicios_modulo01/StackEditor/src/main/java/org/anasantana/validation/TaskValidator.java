package org.anasantana.validation;

import org.anasantana.model.Task;

public class TaskValidator {

    public static void validate(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
    }
}