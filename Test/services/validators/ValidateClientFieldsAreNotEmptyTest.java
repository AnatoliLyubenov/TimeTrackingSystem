package services.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static services.ValidateClientFieldsAreNotEmpty.validateEnterClientFieldsAreNotEmpty;

class ValidateClientFieldsAreNotEmptyTest {

    @Test
    void validateEnterClientFieldsAreNotEmptyFalse(){
        assertFalse(validateEnterClientFieldsAreNotEmpty("","Test","abc"));
    }

    @Test
    void validateEnterClientFieldsAreNotEmptyTrue(){
        assertTrue(validateEnterClientFieldsAreNotEmpty("aaa","Test","abc"));
    }
}