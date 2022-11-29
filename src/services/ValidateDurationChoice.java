package services;

import models.Account;
import models.Client;
import models.Protocol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ValidateDurationChoice {
    private static int ifDigitInRange(int choice) {
        int result = choice;
        if (choice < 1 || choice > 720) {//is OUT of range
            System.out.println(choice + " is out of range.\nYour choice must be between 1 minute to 720 minutes(12 hours)");
            result = -1;
        }
        return result;
    }

    private static boolean ifDigit(String choice) {
        boolean ifDigit = false;
        try {
            Integer.parseInt(choice);
            ifDigit = true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice! Enter digit from 1 to 720 (12 hours)!");
        }
        return ifDigit;
    }

    private static int validateChoice(String inputChoice) {
        int result = -1;//choice value OUT of range
        if (ifDigit(inputChoice)) {//is a digit
            if (ifDigitInRange(Integer.parseInt(inputChoice)) != -1) {
                result = Integer.parseInt(inputChoice);
            }
        }
        return result;
    }

    public static int getRemainingDailyWorkTime(int totalWorkTimeForToday) {
        return 721-totalWorkTimeForToday;
    }

    private static int getTotalWorkTimeForToday(String accountName) {
        int totalWorkTimeForToday = 0;
        HashMap<String, Account> accountsList = Load.accountsListFromFile();

        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        ArrayList<Protocol> employeeDailyProtocols = accountsList.get(accountName).getDailyProtocols().get(date);
        for (Protocol protocol : employeeDailyProtocols) {
            totalWorkTimeForToday += protocol.getMinutes();
        }
        return totalWorkTimeForToday;
    }

    public static int validateDuration(String accountName, ArrayList<Client> clientsList, int clientIndex) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        int result = -1;
        System.out.println("Enter the amount of time spend today working on " + clientsList.get(clientIndex).getClientName() + "'s project - \"" + clientsList.get(clientIndex).getProjectName() + "\"");
        System.out.print("Duration in minutes - > ");
        Scanner sc = new Scanner(System.in);
        int choice = validateChoice(sc.nextLine());
        //ArrayList<Protocol> employeeDailyProtocols=accountsList.get(accountName).getDailyProtocols().get(date);
        if (choice == -1) {
            result = validateDuration(accountName, clientsList, clientIndex);

        } else {

            if (accountsList.get(accountName).getDailyProtocols().get(date) != null) {
                int totalWorkTimeForToday = getTotalWorkTimeForToday(accountName);
                int remainingDailyWorkTime = getRemainingDailyWorkTime(totalWorkTimeForToday);
                if (totalWorkTimeForToday > 720) {
                    System.out.println("You exceeded the amount of time allowed(12 hours/day) to spend on projects for " + date + " with " + CalculateWorkTimeH.convertMtoH(Math.abs(remainingDailyWorkTime)));
                    System.out.println("You won't be paid for working more then 12 hours daily!!!\nGet some rest!!!");
                    PressEnter.promptEnterKey();
                    result = remainingDailyWorkTime; //negative digit
                }else {
                    System.out.println("You still have " + CalculateWorkTimeH.convertMtoH(remainingDailyWorkTime)+" You can get more money if you work them off.");
                    result = choice;
                }
            }else {
                result = choice;
            }
        }
        return result;
    }
}
