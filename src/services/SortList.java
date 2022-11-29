package services;

import wrapperDTO.WeeklyReportDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {
    public static ArrayList<WeeklyReportDTO> sortByProjectName(ArrayList<WeeklyReportDTO> weekProtocols) {
        weekProtocols.sort(new Comparator<>() {
            @Override
            public int compare(WeeklyReportDTO o1, WeeklyReportDTO o2) {
                return o1.getProtocol().getClient().getProjectName().compareTo(o2.getProtocol().getClient().getProjectName());
            }
        });
        return weekProtocols;
    }
}