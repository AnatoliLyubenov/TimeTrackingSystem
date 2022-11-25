package menus;



import java.util.Scanner;

import static menus.AdminMenu.menu;
import static services.Statistics.searchByEmployeeName;
import static services.Statistics.showSpecificWeekStatistics;
import static services.ValidateChoice.validateChoice;

public class StatisticsMenu {
    public static String getUserChoice(){
        System.out.println("  ===== A & A =====   ");
        System.out.println("    = Solutions =    ");
        System.out.println(" = Statistics Menu =");
        System.out.println();
        System.out.println("1. Search by Employee's Account Name.");
        System.out.println("2. Search WorkTime occupancy for specific week number.");
        System.out.println("0. < - BACK");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    private static void chooseStatisticsMenuOption(){
        int choice=validateChoice(getUserChoice(),2);
        if (choice!=-1){
            switch (choice) {
                case 0 -> menu();
                case 1 -> searchByEmployeeName();
                case 2 -> showSpecificWeekStatistics();
            }
        }else chooseStatisticsMenuOption();
    }
    public static void statisticsMenu() {
        chooseStatisticsMenuOption();
    }
}