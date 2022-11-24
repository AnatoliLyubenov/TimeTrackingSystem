package services;


import models.Account;

import java.util.HashMap;

import static services.PrintOut.showEmployeesList;

public class Statistics {

    public static void searchByEmployeeName() {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        showEmployeesList(accountsList);
        String accountName = getEmployeeName();
        if (ValidateRepeatingEmployee.checkRepeatingEmployee(accountName)) {
            showEmployeeStatistics(accountsList, accountName);
        } else {
            System.out.println("Non-existent Employee Account Name!\nCheck the list closely!");
            PressEnter.promptEnterKey();
            searchByEmployeeName();
        }
    }

}
