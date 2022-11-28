package services.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static services.ValidateRepeatingEmployee.checkRepeatingEmployee;

class ValidateRepeatingEmployeeTest {

    @Test
    public void checkRepeatingEmployeeTrue(){
        String accountName="ADMIN";
        assertTrue(checkRepeatingEmployee(accountName));
    }
    @Test
    public void checkRepeatingEmployeeFalse(){
        String accountName="adn";
        assertFalse(checkRepeatingEmployee(accountName));
    }
}