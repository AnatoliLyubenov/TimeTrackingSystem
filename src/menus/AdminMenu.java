package menus;

import services.*;

import java.util.HashMap;
import java.util.Scanner;

import static menus.StatisticsMenu.statisticsMenu;
import static services.ValidateChoice.validateChoice;
import static services.ValidateClientFieldsAreNotEmpty.validateEnterClientFieldsAreNotEmpty;
import static services.ValidateDate.validateExpirationDate;
import static services.ValidateRepeatingClientProject.checkRepeatingClientProject;

public class AdminMenu {
    public static String getUserChoice() {
        System.out.println("  ===== A & A =====   ");
        System.out.println("   == Solutions ==    ");
        System.out.println("    = Admin Menu=     ");
        System.out.println();
        System.out.println("1. Create New Client.");
        System.out.println("2. Register New Employee.");
        System.out.println("3. Employee Statistics");
        System.out.println("0. < - BACK");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static void chooseAdminMenuOption() {
        int choice = validateChoice(getUserChoice(), 3);
        if (choice == -1) {//choice value OUT of range
            chooseAdminMenuOption();
        } else {
            switch (choice) {
                case 0 -> {
                    System.out.println();
                    Login.loginMenu();
                }
                case 1 -> {
                    System.out.println();
                    enterClient();
                }
                case 2 -> {
                    System.out.println();
                    enterEmployee();
                }
                case 3 -> {
                    System.out.println();
                    statisticsMenu();
                    menu();
                }
            }
        }
    }

    private static void projectExistsMessage(String clientName) {
        System.out.println("Specified Project already exists for client \"" + clientName + "\".");
        System.out.println("Register another Project.");
    }

    private static void enterClient() {
        System.out.print("Client's Name - > ");
        Scanner sc = new Scanner(System.in);
        String clientName = sc.nextLine();
        System.out.print("Project's Name - > ");
        String projectName = sc.nextLine();
        System.out.print("Expiration date - > ");
        String expirationDate = sc.nextLine();
        if (validateEnterClientFieldsAreNotEmpty(clientName, projectName, expirationDate)) {
            if (!validateExpirationDate(expirationDate).equals("not valid")) { // if the expiration date is VALID
                if (checkRepeatingClientProject(clientName, projectName)) { //if Project already exists
                    projectExistsMessage(clientName);
                    PressEnter.promptEnterKey();
                } else {
                    if (CreateObj.clientObj(clientName, projectName, expirationDate, "ProgramFiles/ClientsList.txt") == 1) {
                        System.out.println("Client successfully created.");
                    }
                }
            } else {            // if the expiration date is NOT valid
                System.out.println("Entered date MUST be equal or greater than today.");
            }
            System.out.println();
            AdminMenu.menu();
        } else enterClient();
    }

    private static void enterEmployee() {
        System.out.print("Enter Employee Account Name - > ");
        Scanner sc = new Scanner(System.in);
        String accountName = sc.nextLine();
        if (!ValidateRepeatingEmployee.checkRepeatingEmployee(accountName)) {
            System.out.print("Enter Password - > ");
            String accountPassword = sc.nextLine();
            System.out.print("Enter Employee Names- > ");
            String name = sc.nextLine();

            if (CreateObj.employeeObj(accountName.toUpperCase(), accountPassword, name, "ProgramFiles/AccountsList.txt") == 1) {
                System.out.println();
            }
        } else {
            System.out.println("Specified Employee Account Name already Exists.\nUse another one.");
            PressEnter.promptEnterKey();
        }
        AdminMenu.menu();
    }

    public static void menu() {
        chooseAdminMenuOption();
    }
}
