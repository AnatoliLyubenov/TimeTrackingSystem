package services;

public class CalculateWorkTimeH {
    public static String convertMtoH(int minutes) {
        String time = "";
        if (minutes < 60) {
            time = "0:" + minutes + " minutes.";
        } else if (minutes == 60) {
            time = "1 hour.";
        } else {
            int m = minutes % 60;
            int h = minutes / 60;
            if (h == 1) {
                time = "1 hour " + m + " minutes.";
            } else {
                time = h + " hours " + m + " minutes.";
            }
        }
        return time;
    }
}

