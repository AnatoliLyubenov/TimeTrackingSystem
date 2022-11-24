package services;

import models.Account;

import java.util.HashMap;

public class PrintOut {
    public static void showEmployeesList(HashMap<String, Account> accountsList) {
        System.out.println();
        System.out.println("Employee list:");
        System.out.println("================================================================");
        for (String str : accountsList.keySet()) {
            if (!accountsList.get(str).isAdmin()) {
                System.out.println("Employee Account Name - > " + accountsList.get(str).getUserName());
                System.out.println("Employee Name - > " + accountsList.get(str).getName());
                System.out.println("================================================================");
            }
        }
    }

}
