package org.anasantana.model;

import java.util.Objects;

public class Client {
    private String id;
    private String name;
    private String email;

    public Client(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Equals and hashCode based on ID (unique key)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
