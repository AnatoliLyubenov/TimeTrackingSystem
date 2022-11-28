package services.validators;

import models.Client;
import models.Protocol;
import org.junit.jupiter.api.Test;
import services.Load;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static services.ValidateProtocol.checkIfDailyProtocolExists;
import static services.ValidateProtocol.checkIfProjectRecordExists;

class ValidateProtocolTest {

    @Test
    void checkIfDailyProtocolExistsTrue() {
        ArrayList<Protocol> todayProtocols=new ArrayList<>();
        todayProtocols.add(new Protocol("test","CONFIGURE NEW PHONE CENTRAL","31.12.2022",20, "31.12.2023"));
        HashMap<String, ArrayList<Protocol>> employeeDailyProtocols = new HashMap<>();
        employeeDailyProtocols.put("31.12.2022", todayProtocols);
        assertTrue(checkIfDailyProtocolExists("31.12.2022", employeeDailyProtocols));
    }

    @Test
    void checkIfDailyProtocolExistsFalse() {
        ArrayList<Protocol> todayProtocols = new ArrayList<>();
        todayProtocols.add(new Protocol("test", "CONFIGURE NEW PHONE CENTRAL", "31.12.2022", 20, "31.12.2023"));
        HashMap<String, ArrayList<Protocol>> employeeDailyProtocols = new HashMap<>();
        employeeDailyProtocols.put("31.12.2022", todayProtocols);
        assertFalse(checkIfDailyProtocolExists("01.12.2022", employeeDailyProtocols));
    }

    @Test
    void checkIfProjectRecordExistsFalse() {
        ArrayList<Client> clientsList = Load.clientListFromFile();
        ArrayList<Protocol> todayProtocols = new ArrayList<>();
        int clientIndex = 0;
        assertEquals(-1, checkIfProjectRecordExists(clientsList, todayProtocols, clientIndex));
    }

    @Test
    void checkIfProjectRecordExistsTrue() {
        ArrayList<Client> clientsList = Load.clientListFromFile();
        ArrayList<Protocol> todayProtocols = new ArrayList<>();
        todayProtocols.add(new Protocol("test", "CONFIGURE NEW PHONE CENTRAL", "31.12.2022", 20, "31.12.2023"));
        int clientIndex = 0;
        assertEquals(0, checkIfProjectRecordExists(clientsList, todayProtocols, clientIndex));
    }
}