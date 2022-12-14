package menus;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class AdminMenuTest {

    @Test
    void getUserChoiceTakeUserInput() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", AdminMenu.getUserChoice());
    }
}