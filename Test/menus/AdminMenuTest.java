package menus;

import models.Client;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;
import services.Load;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.*;

class AdminMenuTest {

    @Test
    void getUserChoiceTakeUserInput() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", AdminMenu.getUserChoice());
    }
    @Test
    void validateEnterClientFieldsAreNotEmptyFalse(){
        assertFalse(AdminMenu.validateEnterClientFieldsAreNotEmpty("","Test","abc"));
    }

    @Test
    void validateEnterClientFieldsAreNotEmptyTrue(){
        assertTrue(AdminMenu.validateEnterClientFieldsAreNotEmpty("aaa","Test","abc"));
    }
}