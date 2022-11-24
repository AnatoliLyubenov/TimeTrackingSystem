package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ValidateDate {
    public static boolean validateDateIsNotEmpty(String inputDate) {
        boolean isNotEmpty = true;
        if (inputDate.equals("")) { // if NO date is entered
            System.out.println("Empty Date is NOT acceptable!!!");
            isNotEmpty = false;
        }
        return isNotEmpty;
    }


    public static String validateExpirationDate(String inputDate) {
        String result = "not valid";          // inputDate is NOT valid
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));// converting to String

        df.setLenient(false);
        try {
            Date todayDate = df.parse(date);//parse date to Date object to be able later to use  compareTo()// check if the date is valid. Compare the date with the Calendar
            Date enteredDate = df.parse(inputDate);// if the date format is as "MM.dd.yyyy"
            if (enteredDate.compareTo(todayDate) >= 0) {// if >0 enteredDate is after today date, if ==0 enteredDate is equal to today date
                result = inputDate; //inputDate is VALID
                System.out.println(inputDate + " is valid date format");
            }
        } catch (ParseException e) {
            System.out.println(inputDate + " is NOT valid date format");
        }
        return result;
    }
}
