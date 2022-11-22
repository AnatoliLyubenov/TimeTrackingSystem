package services;

import menus.AdminMenu;
import models.Account;
import models.Protocol;
import wrapperDTO.WeeklyReportDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static services.PrintOut.showEmployeeClients;
import static services.PrintOut.showEmployeesList;

public class Statistics {

    public static String getEmployeeName() {
        System.out.println("Choose Employee Account Name to show Employee's Statistics");
        System.out.print("Enter Employee Account Name - > ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }

    public static void searchByEmployeeName() {
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        showEmployeesList(accountsList);
        String accountName = getEmployeeName();
        if (ValidateRepeatingEmployee.checkRepeatingEmployee(accountName)) {
            showEmployeeStatistics(accountsList, accountName);
        } else {
            System.out.println("Non-existent Employee Account Name!\nCheck the list closely!");
            PressEnter.promptEnterKey();
            searchByEmployeeName();
        }
    }

    public static void showEmployeeStatistics(HashMap<String, Account> accountsList, String accountName) {
        for (String str : accountsList.keySet()) {
            if (str.equalsIgnoreCase(accountName)) {
                try {
                    if (accountsList.get(str).getDailyProtocols() == null) {
                        System.out.println(accountName + "'s Protocol List is empty.");
                    } else {
                        System.out.println();
                        System.out.println("=========== " + accountsList.get(accountName).getName() + " Protocol List ===========");
                        showEmployeeClients(accountName);
                    }
                    PressEnter.promptEnterKey();
                    AdminMenu.menu();
                } catch (NullPointerException e) {
                    System.out.println(accountName + "'s Protocol List is empty.");
                    PressEnter.promptEnterKey();
                    AdminMenu.menu();
                }
            }
        }
    }

    public static void showSpecificWeekStatistics() {
        int weekNumber = requestWeekNumber();
        int totalWeekWorkTime = 0;
        ArrayList<WeeklyReportDTO> weekProtocols = collectProtocolsFromSpecificWeek(getMondayDate(weekNumber), getSundayDate(weekNumber));
        System.out.println();
        System.out.println("<<<< WEEK " + weekNumber + " STATISTICS >>>>");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < weekProtocols.size(); i++) {
            System.out.println("Employee Account Name - > " + weekProtocols.get(i).getAccountName());
            System.out.println("Client Name - > " + weekProtocols.get(i).getClientName());
            System.out.println("Project Name - > " + weekProtocols.get(i).getProject());
            System.out.println("Expiration Date - > " + weekProtocols.get(i).getDeadLine());
            System.out.println("Protocol Date - > " + weekProtocols.get(i).getProtocolDate());
            System.out.println("Work time spend during week number " + weekNumber + " - > " + CalculateWorkTimeH.convertMtoH(weekProtocols.get(i).getMinutes()));
            System.out.println("================================================================");
            totalWeekWorkTime += weekProtocols.get(i).getMinutes();
        }
        System.out.println("*******************************************************************************");
        System.out.println("Week Number " + weekNumber + " - total work time spend on Clients - > " + CalculateWorkTimeH.convertMtoH(totalWeekWorkTime));
        System.out.println("*******************************************************************************");
        System.out.println();
        PressEnter.promptEnterKey();
    }

    private static ArrayList<WeeklyReportDTO> collectProtocolsFromSpecificWeek(Date monday, Date sunday) {
        ArrayList<WeeklyReportDTO> weekProtocols = new ArrayList<>();
        HashMap<String, Account> accountsList = Load.accountsListFromFile();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (String accountName : accountsList.keySet()) {
            if (!accountsList.get(accountName).isAdmin()) {//excluding admin account, who doesn't have dailyProtocols' field
                for (String protocolDate : accountsList.get(accountName).getDailyProtocols().keySet()) {
                    try {//checking every account if protocolDate is between monday and sunday of the specific weekNumber
                        Date date = sdf.parse(protocolDate); //parse the protocolDate to Date object
                        if (date.compareTo(monday) >= 0 && date.compareTo(sunday) <= 0) {//compare if date is equal or between monday and sunday of the specific weekNumber
                            ArrayList<Protocol> employeeDailyProtocols = (accountsList.get(accountName).getDailyProtocols().get(protocolDate));//getting Protocol's List of for the specific date
                            for (Protocol employeeDailyProtocol : employeeDailyProtocols) {
                                //copying every Protocol's field to weekProtocols List
                                weekProtocols.add(new WeeklyReportDTO(accountName, employeeDailyProtocol.getClient().getClientName(), employeeDailyProtocol.getClient().getProjectName(), employeeDailyProtocol.getClient().getExpirationDate(), employeeDailyProtocol.getMinutes(), employeeDailyProtocol.getProtocolDate()));
                            }
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return SortList.sortByProjectName(weekProtocols);
    }

    public static int requestWeekNumber() {
        System.out.print("Enter desired Week Number - > ");
        Scanner sc = new Scanner(System.in);
        int weekNumber = sc.nextInt();

        Calendar calendar = Calendar.getInstance();
        int weekCount = calendar.getActualMaximum(Calendar.WEEK_OF_YEAR);

        if (weekNumber < 0 || weekNumber > weekCount) {
            System.out.println("Invalid choice!!!\nEnter digit from 1 to " + weekCount + " including!");
            PressEnter.promptEnterKey();
            weekNumber = requestWeekNumber();
        }
        return weekNumber;
    }

    private static Date getMondayDate(int weekNumber) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        try {
            return sdf.parse(sdf.format(calendar.getTime()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static Date getSundayDate(int weekNumber) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.WEEK_OF_YEAR, weekNumber);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        try {
            return sdf.parse(sdf.format(calendar.getTime()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
