package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProtocolTest {

    @BeforeEach
    void setUp() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");
    }

    @Test
    void getClientName() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");
        assertEquals("client name", protocol.getClientName());
    }

    @Test
    void setProject() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");

        protocol.setProject("NEW projectName");
        assertEquals("NEW projectName",protocol.getProject());
    }

    @Test
    void getDeadLine() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");
        assertEquals("31.12.2022",protocol.getDeadLine());
    }

    @Test
    void getMinutes() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");
        assertEquals(20,protocol.getMinutes());
    }

    @Test
    void setMinutes() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");
        protocol.setMinutes(1);
        assertEquals(1,protocol.getMinutes());
    }

    @Test
    void getProtocolDate() {
        Protocol protocol = new Protocol("client name","project name","31.12.2022",20,"28.12.2022");
        assertEquals("28.12.2022",protocol.getProtocolDate());
    }
}