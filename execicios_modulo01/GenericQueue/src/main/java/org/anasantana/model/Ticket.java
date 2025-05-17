package org.anasantana.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private String holder;
    private LocalDateTime createdAt;

    public Ticket(String holder) {
        this.holder = holder;
        this.createdAt = LocalDateTime.now();
    }

    public String getHolder() {
        return holder;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Ticket{" + "holder='" + holder + '\'' + ", createdAt=" + createdAt + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(holder, ticket.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(holder);
    }
}
