package services.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static services.ValidateDate.validateDateIsNotEmpty;
import static services.ValidateDate.validateExpirationDate;

public class ValidateDateTest {

    @Test
    public void validateExpirationDateValid() {
        String inputDate = "31.12.2022";
        assertEquals("31.12.2022", validateExpirationDate(inputDate));
    }

    @Test
    public void validateExpirationDateNotValid() {
        String inputDate = "31.12.2002";
        assertEquals("not valid", validateExpirationDate(inputDate));
    }

    @Test
    void validateDateIsNotEmptyTrue() {
        assertTrue(validateDateIsNotEmpty("31.12.2022"));
    }

    @Test
    void validateDateIsNotEmptyNotFalse() {
        assertFalse(validateDateIsNotEmpty(""));
    }

    @Test
    public void validateExpirationDateNotValidDate() {
        String date = "30.02.2023";
        int end = 1;
        assertDoesNotThrow(() -> validateExpirationDate(date), date + " is NOT valid date format");
    }
}