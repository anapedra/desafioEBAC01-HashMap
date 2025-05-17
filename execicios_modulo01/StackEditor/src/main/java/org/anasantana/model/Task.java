package org.anasantana.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class Task implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String description;

    private LocalDateTime createdAt;

    public Task() {
        this.createdAt = LocalDateTime.now();
    }

    public Task(Long id, String description) {
        this.id = id;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public Task(Long id, String description, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
