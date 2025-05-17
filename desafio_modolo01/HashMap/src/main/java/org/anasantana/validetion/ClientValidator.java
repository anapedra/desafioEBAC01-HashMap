package org.anasantana.validetion;


import org.anasantana.model.Client;

public class ClientValidator {

    public static void validate(Client client) {
        if (client == null)
            throw new IllegalArgumentException("Client cannot be null");

        if (client.getId() == null || client.getId().isEmpty())
            throw new IllegalArgumentException("Client ID is required");

        if (client.getName() == null || client.getName().isEmpty())
            throw new IllegalArgumentException("Client name is required");

        if (client.getEmail() == null || !client.getEmail().contains("@"))
            throw new IllegalArgumentException("Client email is invalid");
    }
}
