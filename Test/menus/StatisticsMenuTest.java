package menus;

import org.junit.jupiter.api.Test;
import services.Statistics;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsMenuTest {

    @Test
    void getUserChoiceTakeUserInput() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("5", StatisticsMenu.getUserChoice());
    }

    @Test
    void getEmployeeNameTakeUserInput() {
        String input = "anton";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("ANTON", Statistics.getEmployeeName());
    }
}