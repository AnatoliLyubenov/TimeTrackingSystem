package menus;

import services.CreateObj;

import java.util.Scanner;

import static menus.EmployeeMenu.chooseEmployeeMenuOption;
import static services.ValidateChoice.validateChoice;
import static services.ValidateCredentials.*;
import static services.ValidateIfFileIsEmpty.ifFileIsEmpty;

public class Login {
    public static String getUserChoiceAdmin() {
        System.out.println("Admin Account NOT created.");
        System.out.println("1. Create Admin Account.");
        System.out.println("0. EXIT.");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static void chooseMenuOptionInitialLogin() {
        int choice = validateChoice(getUserChoiceAdmin(), 1);
        if (choice == -1) {
            chooseMenuOptionInitialLogin();
        } else if (choice == 1) {
            if (CreateObj.adminObj(getAdminAccountName(), getAdminAccountPassword(), "ProgramFiles/AccountsList.txt") == 1) {
                System.out.println("Admin Account created successfully.\n");
            }
            AdminMenu.menu();
        }
    }

    public static String getAdminAccountName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Admin Account Name - > ");
        return sc.next().toUpperCase();
    }

    public static String getAdminAccountPassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Password - > ");
        return sc.next();
    }


    public static void initialLogin() {
        if (ifFileIsEmpty("ProgramFiles/AccountsList.txt")) {
            chooseMenuOptionInitialLogin();
        } else {
            Login.loginMenu();
        }
    }

    public static String getUserChoice() {
        System.out.println("  ===== A & A =====   ");
        System.out.println("    = Solutions =    ");
        System.out.println("   == Login Menu ==    ");
        System.out.println();
        System.out.println("1. Login.");
        System.out.println("0. EXIT.");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static void validateLoginCredentials() {
        String accountName = getEnteredAccountName();

        if (ifAccountNameIsValid(accountName)) {
            int result = checkPassword(accountName, getEnteredAccountPassword());
            if (result == 1) {
                System.out.println();
                AdminMenu.menu();
            } else if (result == 2) {
                chooseEmployeeMenuOption(accountName);
            } else {
                System.out.println("Wrong password!!!");

                Login.loginMenu();
            }
        } else {
            System.out.println("Such Account does NOT exist in our System.");
            System.out.println();
            Login.loginMenu();
        }
    }

    private static void chooseOptionLoginMenu() {
        int choice = validateChoice(getUserChoice(), 1);
        if (choice == -1) {
            chooseOptionLoginMenu();
        } else if (choice == 1) {
            validateLoginCredentials();
        }
    }

    public static void loginMenu() {
        chooseOptionLoginMenu();
    }
}
