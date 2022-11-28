package services.validators;

import org.junit.jupiter.api.Test;
import services.ValidateCredentials;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCredentialsTest {

    @Test
    void ifAccountNameIsValidTrue() {
        assertTrue(ValidateCredentials.ifAccountNameIsValid("admin"));
    }

    @Test
    void ifAccountNameIsValidFalse() {

        assertFalse(ValidateCredentials.ifAccountNameIsValid("ad"));
    }

    @Test
    void checkPasswordAdmin() {
        assertEquals(1, ValidateCredentials.checkPassword("admin", "1234"));
    }

    @Test
    void checkPasswordEmployee() {
        assertEquals(2, ValidateCredentials.checkPassword("aandonov", "1234"));
    }

    @Test
    void getEnteredAccountNameTakeUserInput() {
        String input = "name";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("name", ValidateCredentials.getEnteredAccountName());
    }

    @Test
    void getEnteredAccountPasswordTakeUserInput() {
        String input = "45675";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("45675", ValidateCredentials.getEnteredAccountPassword());
    }
}