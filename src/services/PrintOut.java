package services;

import models.Account;
import models.Protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import static services.SortMapByKey.getSortedTreeMap;

public class PrintOut {
    private static HashMap<String, Account> accountsList = Load.accountsListFromFile();

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

        HashMap<String, ArrayList<Protocol>> employeeProtocols = accountsList.get(accountName).getDailyProtocols();
        int totalDailyWorkTime = 0;
        TreeMap<String, ArrayList<Protocol>> employeeProtocolsTreeMap=getSortedTreeMap(employeeProtocols);

        for (String date : employeeProtocolsTreeMap.keySet()) {
            ArrayList<Protocol> employeeDailyProtocols = employeeProtocols.get(date);
            for (int i = 0; i < employeeDailyProtocols.size(); i++) {
                System.out.println("Client Name - > " + employeeDailyProtocols.get(i).getClient().getClientName());
                System.out.println("Project Name - > " + employeeDailyProtocols.get(i).getClient().getProjectName());
                System.out.println("Expiration Date - > " + employeeDailyProtocols.get(i).getClient().getExpirationDate());
                System.out.println("Work time spend on " + date + " - > " + CalculateWorkTimeH.convertMtoH(employeeDailyProtocols.get(i).getMinutes()));
                System.out.println("================================================================");
                totalDailyWorkTime += employeeDailyProtocols.get(i).getMinutes();
            }
            System.out.println("*******************************************************************************");
            System.out.println(date + " - " + accountsList.get(accountName).getName() + " work time spend on Clients - > " + CalculateWorkTimeH.convertMtoH(totalDailyWorkTime));
            System.out.println("*******************************************************************************");
            System.out.println();
            totalDailyWorkTime = 0;//reset work time for the next date
        }
    }
}
