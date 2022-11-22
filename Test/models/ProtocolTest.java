package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProtocolTest {

    @Test
    void getClientName() {
        Client client = new Client("client name","project name","31.12.2022");
        Protocol protocol = new Protocol(client,20,"28.12.2022");
        assertEquals("client name", protocol.getClient().getClientName());
    }

    @Test
    void setProject() {
        Client client = new Client("client name","project name","31.12.2022");
        Protocol protocol = new Protocol(client,20,"28.12.2022");

        protocol.getClient().setProjectName("NEW projectName");
        assertEquals("NEW projectName",protocol.getClient().getProjectName());
    }

    @Test
    void getDeadLine() {
        Client client = new Client("client name","project name","31.12.2022");
        Protocol protocol = new Protocol(client,20,"28.12.2022");
        assertEquals("31.12.2022",protocol.getClient().getExpirationDate());
    }

    @Test
    void getMinutes() {
        Client client = new Client("client name","project name","31.12.2022");
        Protocol protocol = new Protocol(client,20,"28.12.2022");
        assertEquals(20,protocol.getMinutes());
    }

    @Test
    void setMinutes() {
        Client client = new Client("client name","project name","31.12.2022");
        Protocol protocol = new Protocol(client,20,"28.12.2022");
        protocol.setMinutes(1);
        assertEquals(1,protocol.getMinutes());
    }

    @Test
    void getProtocolDate() {
        Client client = new Client("client name","project name","31.12.2022");
        Protocol protocol = new Protocol(client,20,"28.12.2022");
        assertEquals("28.12.2022",protocol.getProtocolDate());
    }
}