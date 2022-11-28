package services.validators;

import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;
import static services.ValidateIfFileIsEmpty.ifFileIsEmpty;

class ValidateIfFileIsEmptyTest {

    @Test
    void ifFileIsEmptyFalse() {
        assertFalse(ifFileIsEmpty("ProgramFiles/ClientsList.txt"));
    }

    @Test
    void ifFileIsEmptyFileNotFound() {
        assertTrue(ifFileIsEmpty("ClientsList_NOTFound.txt"));
    }
}