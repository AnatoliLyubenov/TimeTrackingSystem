package services;

import models.Account;
import models.Protocol;

import java.util.ArrayList;
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

    public static void showEmployeeClients(String accountName) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        HashMap<String, ArrayList<Protocol>> employeeProtocols = accountsList.get(accountName).getDailyProtocols();
        int totalDailyWorkTime = 0;

        for (String date : employeeProtocols.keySet()) {
            ArrayList<Protocol> employeeDailyProtocols = employeeProtocols.get(date);
            for (int i = 0; i < employeeDailyProtocols.size(); i++) {
                System.out.println("Client Name - > " + employeeDailyProtocols.get(i).getClientName());
                System.out.println("Project Name - > " + employeeDailyProtocols.get(i).getProject());
                System.out.println("Expiration Date - > " + employeeDailyProtocols.get(i).getDeadLine());
                System.out.println("Work time spend on " + date + " - > " + CalculateWorkTimeH.convertMtoH(employeeDailyProtocols.get(i).getMinutes()));
                System.out.println("================================================================");
                totalDailyWorkTime += employeeDailyProtocols.get(i).getMinutes();
            }
            System.out.println("*******************************************************************************");
            System.out.println(date + " - " + accountsList.get(accountName).getName() + " work time spend on Clients.txt - > " + CalculateWorkTimeH.convertMtoH(totalDailyWorkTime));
            System.out.println("*******************************************************************************");
            System.out.println();
            totalDailyWorkTime = 0;//reset work time for the next date
        }
    }
}
