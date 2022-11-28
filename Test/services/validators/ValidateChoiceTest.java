package services.validators;

import org.junit.jupiter.api.Test;
import services.ValidateChoice;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateChoiceTest {
    @Test
    public void testValidateChoiceInRange() {
        String choice = "1";
        int end = 1;
        assertEquals(1, ValidateChoice.validateChoice(choice, end));
    }

    @Test
    public void testValidateChoiceOutOfRange() {
        String choice = "22";
        int end = 1;
        assertEquals(-1, ValidateChoice.validateChoice(choice, end));
    }

    @Test
    public void testValidateChoiceCatch() {
        String choice = "A";
        int end = 1;
        assertDoesNotThrow(() -> ValidateChoice.validateChoice(choice, end), "Invalid choice! Enter digit from 0 to " + end + " including!");
    }
}