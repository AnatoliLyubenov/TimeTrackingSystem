package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getDailyProtocols() {
        Account account = new Employee("accountName","password","personal name",false);
        HashMap<String, ArrayList<Protocol>> protocols=new HashMap<>();
        account.setDailyProtocols(protocols);
        assertEquals(protocols,account.getDailyProtocols());
    }

    @Test
    void getName() {
        Account account = new Employee("accountName","password","personal name",false);
        assertEquals("personal name",account.getName());
    }

    @Test
    void getUserName() {
        Account account = new Employee("accountName","password","personal name",false);
        assertEquals("accountName",account.getUserName());
    }

    @Test
    void getPassword() {
        Account account = new Employee("accountName","password","personal name",false);
        assertEquals("password",account.getPassword());
    }

    @Test
    void isAdminFalse() {
        Account account = new Employee("accountName","password","personal name",false);
        assertFalse(account.isAdmin());
    }
}