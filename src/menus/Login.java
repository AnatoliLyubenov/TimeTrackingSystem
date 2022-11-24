package menus;

import services.Validators;

import java.util.Scanner;


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
    private static void chooseOptionLoginMenu() {
        int choice = Validators.validateChoice(getUserChoice(), 1);
        if (choice == -1) {
            chooseOptionLoginMenu();
        } else if (choice == 1) {

        }
    }

    public static void loginMenu() {
        chooseOptionLoginMenu();

    }
}
