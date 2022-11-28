package services;

import models.Account;
import models.Client;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SaveTest {

    @Test
    void accountsListToFile() {
        HashMap<String, Account> accountsList = new HashMap<>();
        assertDoesNotThrow(() -> Save.accountsListToFile(accountsList, "Test/AccountsList.txt"));
    }

}