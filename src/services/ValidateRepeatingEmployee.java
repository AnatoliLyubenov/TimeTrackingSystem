package services;

import models.Account;

import java.util.HashMap;

public class ValidateRepeatingEmployee {
    public static boolean checkRepeatingEmployee(String accountName) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        boolean isRepeating = false;
        if (accountsList.containsKey(accountName.toUpperCase())) {
            isRepeating = true;
        }
        return isRepeating;
    }

}
