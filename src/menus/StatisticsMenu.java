package menus;

import services.CalculateWorkTimeH;
import services.PressEnter;
import wrapperDTO.WeeklyReportDTO;

import java.util.ArrayList;
import java.util.Scanner;

import static menus.AdminMenu.menu;
import static services.Statistics.requestWeekNumber;
import static services.Statistics.searchByEmployeeName;

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
    public static void showSpecificWeekStatistics() {
        int weekNumber=requestWeekNumber();
        int totalWeekWorkTime=0;
        ArrayList<WeeklyReportDTO> weekProtocols=collectProtocolsFromSpecificWeek(getMondayDate(weekNumber),getSundayDate(weekNumber));
        System.out.println();
        System.out.println("<<<< WEEK "+weekNumber+" STATISTICS >>>>");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < weekProtocols.size(); i++) {
            System.out.println("Employee Account Name - > " + weekProtocols.get(i).getAccountName());
            System.out.println("Client Name - > " + weekProtocols.get(i).getClientName());
            System.out.println("Project Name - > " + weekProtocols.get(i).getProject());
            System.out.println("Expiration Date - > " + weekProtocols.get(i).getDeadLine());
            System.out.println("Protocol Date - > "+weekProtocols.get(i).getProtocolDate());
            System.out.println("Work time spend during week number " + weekNumber + " - > " + CalculateWorkTimeH.convertMtoH(weekProtocols.get(i).getMinutes()));
            System.out.println("================================================================");
            totalWeekWorkTime += weekProtocols.get(i).getMinutes();
        }
        System.out.println("*******************************************************************************");
        System.out.println("Week Number " + weekNumber+" - total work time spend on Clients.txt - > " + CalculateWorkTimeH.convertMtoH(totalWeekWorkTime));
        System.out.println("*******************************************************************************");
        System.out.println();
        PressEnter.promptEnterKey();
    }

}
