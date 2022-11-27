package menus;

import models.Account;
import models.Client;
import models.Protocol;
import services.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static models.Client.getChosenClientIndex;
import static services.ValidateProtocol.checkIfDailyProtocolExists;
import static services.ValidateProtocol.checkIfProjectRecordExists;

public class EmployeeMenu {
    public static String getUserChoice(String accountName) {
        System.out.println();
        System.out.println("  ===== A & A =====   ");
        System.out.println("    = Solutions =    ");
        System.out.println("  = Employee Menu =  ");
        System.out.println();
        System.out.println("Logged in as " + accountName + ":");
        System.out.println("1. Add Client to Daily Protocol.");
        System.out.println("2. Show Today's Protocol.");
        System.out.println("0. < - BACK.");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static void chooseEmployeeMenuOption(String name) {
        String accountName = name.toUpperCase();

        int choice = ValidateChoice.validateChoice(getUserChoice(accountName), 2);
        if (choice == -1) {
            chooseEmployeeMenuOption(accountName);
        } else {
            switch (choice) {
                case 0 -> {
                    System.out.println();
                    Login.loginMenu();
                }
                case 1 -> {
                    writeToDailyProtocol(accountName);
                    chooseEmployeeMenuOption(accountName);
                }
                case 2 -> showEmployeeDailyProtocols(accountName);
            }
        }
    }

    private static void showEmployeeDailyProtocols(String accountName) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        LocalDate date = LocalDate.now();
        String today = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println();

        if (accountsList.containsKey(accountName)) {
            try {
                if (accountsList.get(accountName).getDailyProtocols().get(today) != null) {
                    System.out.println("=== " + accountsList.get(accountName).getName() + " Daily Protocol for " + today + " ===");
                    showEmployeeTodayClients(accountName, today);
                } else {
                    System.out.println(accountName + "'s Daily Protocol list is empty.");
                }
                PressEnter.promptEnterKey();
                chooseEmployeeMenuOption(accountName);
            } catch (NullPointerException e) {
                System.out.println(accountName + "'s Daily Protocol list is empty.");
                PressEnter.promptEnterKey();
                chooseEmployeeMenuOption(accountName);
            }
        }
    }

    private static void showEmployeeTodayClients(String accountName, String protocolDate) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        ArrayList<Protocol> employeeDailyProtocols = accountsList.get(accountName).getDailyProtocols().get(protocolDate);
        int totalDailyWorkTime = 0;

        for (int i = 0; i < employeeDailyProtocols.size(); i++) {
            System.out.println("ID - > " + (i + 1));
            System.out.println("Client Name - > " + employeeDailyProtocols.get(i).getClientName());
            System.out.println("Project Name - > " + employeeDailyProtocols.get(i).getProject());
            System.out.println("Expiration Date - > " + employeeDailyProtocols.get(i).getDeadLine());
            System.out.println("Work time spend on " + protocolDate + " - > " + CalculateWorkTimeH.convertMtoH(employeeDailyProtocols.get(i).getMinutes()));
            System.out.println("================================================================");
            totalDailyWorkTime += employeeDailyProtocols.get(i).getMinutes();
        }
        System.out.println(protocolDate + " - " + accountsList.get(accountName).getName() + " work time spend on Clients.txt - > " + CalculateWorkTimeH.convertMtoH(totalDailyWorkTime));
    }

    private static void writeToDailyProtocol(String accountName) {
        LocalDate today = LocalDate.now();

        String protocolDate = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println();
        int clientIndex = getChosenClientIndex();
        ArrayList<Client> clientsList = Load.clientListFromFile();
        System.out.println("Enter the amount of time spend today working on " + clientsList.get(clientIndex).getClientName() + "'s project - \"" + clientsList.get(clientIndex).getProjectName() + "\"");
        System.out.print("Duration in minutes - > ");
        Scanner sc = new Scanner(System.in);
        int duration = sc.nextInt();

        addClientToDailyProtocol(accountName, clientIndex, duration, protocolDate);
    }

    private static void addClientToDailyProtocol(String accountName, int clientIndex, int durationMinutes, String protocolDate) {
        ArrayList<Client> clientsList = Load.clientListFromFile();
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        HashMap<String, ArrayList<Protocol>> employeeDailyProtocols = accountsList.get(accountName).getDailyProtocols();

        if (employeeDailyProtocols.size() == 0) {//if there aren't any daily Protocols
            employeeDailyProtocols.put(protocolDate, new ArrayList<>());
            employeeDailyProtocols.get(protocolDate).add(new Protocol(clientsList.get(clientIndex).getClientName(), clientsList.get(clientIndex).getProjectName(), clientsList.get(clientIndex).getExpirationDate(), durationMinutes, protocolDate));

            System.out.println("List of Daily Protocols successfully created for " + accountsList.get(accountName).getName() + ".");
            System.out.println("The 1st Record successfully added to the Daily Protocol.");
        } else {
            if (checkIfDailyProtocolExists(protocolDate, employeeDailyProtocols)) {
                addMinutesToAlreadyExistingDailyProtocolRecord(accountsList, employeeDailyProtocols, clientsList, clientIndex, accountName, protocolDate, durationMinutes);
            } else {//if we create NEW Daily Protocol
                employeeDailyProtocols.get(protocolDate).add(new Protocol(clientsList.get(clientIndex).getClientName(), clientsList.get(clientIndex).getProjectName(), clientsList.get(clientIndex).getExpirationDate(), durationMinutes, protocolDate));
                System.out.println("Record successfully added to the New Daily Protocol.");
            }
        }
        Save.accountsListToFile(accountsList, "ProgramFiles/AccountsList.txt");
        PressEnter.promptEnterKey();
    }

    private static void addMinutesToAlreadyExistingDailyProtocolRecord(HashMap<String, Account> accountsList, HashMap<String, ArrayList<Protocol>> employeeDailyProtocols, ArrayList<Client> clientsList, int clientIndex, String accountName, String protocolDate, int durationMinutes) {
        ArrayList<Protocol> todayProtocols = accountsList.get(accountName).getDailyProtocols().get(protocolDate);
        int protocolRecordIndex = checkIfProjectRecordExists(clientsList, todayProtocols, clientIndex);

        if (protocolRecordIndex != -1) {//if DailyProtocol list contains Client with the same project name
            todayProtocols.get(protocolRecordIndex).setMinutes(todayProtocols.get(protocolRecordIndex).getMinutes() + durationMinutes);
            System.out.println("Record of Daily Protocol successfully edited.");
        } else {
            employeeDailyProtocols.get(protocolDate).add(new Protocol(clientsList.get(clientIndex).getClientName(), clientsList.get(clientIndex).getProjectName(), clientsList.get(clientIndex).getExpirationDate(), durationMinutes, protocolDate));
            System.out.println("Record successfully added to the Daily Protocol.");
        }
    }
}