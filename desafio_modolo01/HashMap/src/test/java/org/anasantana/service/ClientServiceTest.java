package org.anasantana.service;

import org.anasantana.model.Client;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceTest {

    private ClientService service;

    @BeforeEach
    void setup() {
        service = new ClientService();
    }

    @Test
    void shouldAddAndRetrieveClient() {
        Client c = new Client("1", "Alice", "alice@email.com");
        service.addClient(c);
        assertEquals("Alice", service.getClient("1").getName());
    }

    @Test
    void shouldRemoveClient() {
        Client c = new Client("2", "Bob", "bob@email.com");
        service.addClient(c);
        assertEquals("Bob", service.removeClient("2").getName());
        assertNull(service.getClient("2"));
    }

    @Test
    void shouldCountClientsCorrectly() {
        service.addClient(new Client("3", "Carol", "carol@email.com"));
        service.addClient(new Client("4", "Dan", "dan@email.com"));
        assertEquals(2, service.countClients());
    }

    @Test
    void shouldClearClients() {
        service.addClient(new Client("5", "Eve", "eve@email.com"));
        service.clearClients();
        assertEquals(0, service.countClients());
    }
}
