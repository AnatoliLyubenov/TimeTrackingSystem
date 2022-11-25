import menus.AdminMenu;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.AssertJUnit.assertEquals;

public class test {

    @Test
    void getUserChoiceTakeUserInput() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", AdminMenu.getUserChoice());
    }

}

