package services.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static services.ValidateRepeatingClientProject.checkRepeatingClientProject;

class ValidateRepeatingClientProjectTest {

    @Test
    public void checkRepeatingClientProjectTrue() {
        String clientName="SISECAM";
        String projectName="CONFIGURE NEW PHONE CENTRAL";

        assertTrue(checkRepeatingClientProject(clientName,projectName));
    }
}