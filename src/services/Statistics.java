package services;


import menus.AdminMenu;
import models.Account;

import java.util.HashMap;
import java.util.Scanner;

import static services.PrintOut.showEmployeeClients;
import static services.PrintOut.showEmployeesList;

public class Statistics {
    public static String getEmployeeName(){
        System.out.println("Choose Employee Account Name to show Employee's Statistics");
        System.out.print("Enter Employee Account Name - > ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }
    public static void showEmployeeStatistics(HashMap<String, Account> accountsList, String accountName) {
        for (String str : accountsList.keySet()) {
            if (str.equalsIgnoreCase(accountName)) {
                try {
                    if (accountsList.get(str).getDailyProtocols() == null) {
                        System.out.println(accountName + "'s Protocol List is empty.");
                    } else {
                        System.out.println();
                        System.out.println("=========== " + accountsList.get(accountName).getName() + " Protocol List ===========");
                        showEmployeeClients(accountName);
                    }
                    PressEnter.promptEnterKey();
                    AdminMenu.menu();
                } catch (NullPointerException e) {
                    System.out.println(accountName + "'s Protocol List is empty.");
                    PressEnter.promptEnterKey();
                    AdminMenu.menu();
                }
            }
        }
    }


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
