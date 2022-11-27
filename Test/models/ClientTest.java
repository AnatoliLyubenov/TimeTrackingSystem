package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void getExpirationDate() {
        Client client = new Client("clientName", "test", "31.12.2022");
        assertEquals("31.12.2022", client.getExpirationDate());
    }

    @Test
    void addClientToList() {
    }

    @Test
    void getChosenClientIndex() {

    }

}