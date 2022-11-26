package menus;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void getUserChoiceAdminTakeUserInput() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", Login.getUserChoiceAdmin());
    }

    @Test
    void getUserChoiceTakeUserInput() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", Login.getUserChoice());
    }

    @Test
    void getAdminAccountNameTakeUserInput(){
        String input = "admin";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("ADMIN", Login.getAdminAccountName());
    }
    @Test
    void getAdminAccountPasswordTakeUserInput(){
        String input = "121332";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("121332", Login.getAdminAccountPassword());
    }

    @Test
    void initialLoginTrue(){

    }
}