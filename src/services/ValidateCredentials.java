package services;

import models.Account;

import java.util.HashMap;
import java.util.Scanner;

public class ValidateCredentials {
    public static boolean ifAccountNameIsValid(String inputName) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        boolean isValid = false;

        String accountName = inputName.toUpperCase();
        if (accountsList.containsKey(accountName)) {
            isValid = true;
        }
        return isValid;
    }

    public static int checkPassword(String inputName, String password) {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        int result = 0;
        String accountName = inputName.toUpperCase();

        if (accountsList.get(accountName).getPassword().equals(password)) {//if password matches

            if (accountsList.get(accountName).isAdmin()) {//if account is Admin
                System.out.println("Admin Account successfully authenticated.");
                result = 1;
            } else {
                System.out.println(accountsList.get(accountName).getName() + " successfully authenticated.");
                result = 2;
            }
        }
        return result;
    }

    public static String getEnteredAccountName() {
        System.out.print("Enter Account Name - > ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String getEnteredAccountPassword() {
        System.out.print("Enter password - > ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
