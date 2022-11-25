package services;

import models.Account;
import models.Admin;
import models.Client;
import models.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateObj {
    public static int adminObj(String accountName,String accountPassword, String filePath) {
        HashMap<String, Account> accountsList = new HashMap<>();
        accountsList.put(accountName, new Admin(accountName, accountPassword, true));
        Save.accountsListToFile(accountsList,filePath);
        return 1;
    }

    public static int employeeObj(String accountName, String accountPassword, String name,String filePath) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        accountsList.put(accountName, new Employee(accountName, accountPassword, name, false));
        Save.accountsListToFile(accountsList,filePath);
        System.out.println("Employee Account "+accountName+" successfully created.");
        return 1;
    }
    public static int clientObj(String clientName, String projectName, String date,String filePath) {
        ArrayList<Client> clientsList=Load.clientListFromFile();
        clientsList.add(new Client(clientName, projectName, date));
        Save.clientListToFile(clientsList,filePath);// "ProgramFiles/ClientsList.txt"
        return 1;
    }
}