package org.anasantana.service;


import org.anasantana.data_structure.MyHashMap;
import org.anasantana.model.Client;
import org.anasantana.validetion.ClientValidator;

public class ClientService {

    private final MyHashMap<String, Client> clientMap = new MyHashMap<>();

    public void addClient(Client client) {
        ClientValidator.validate(client);
        clientMap.put(client.getId(), client);
    }

    public Client getClient(String id) {
        return clientMap.get(id);
    }

    public Client removeClient(String id) {
        return clientMap.remove(id);
    }

    public int countClients() {
        return clientMap.size();
    }

    public void clearClients() {
        clientMap.clear();
    }
}
