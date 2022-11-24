package menus;

import java.util.Scanner;

import static menus.EmployeeMenu.chooseEmployeeMenuOption;
import static services.ValidateChoice.validateChoice;
import static services.ValidateCredentials.*;
import static services.ValidateCredentials.getEnteredAccountPassword;


public class Login {
    public static String getUserChoice(){
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
        String accountName=getEnteredAccountName();

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
