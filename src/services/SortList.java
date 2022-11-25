package services;

import wrapperDTO.WeeklyReportDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortList {
    public static ArrayList<WeeklyReportDTO> sortByProjectName(ArrayList<WeeklyReportDTO> weekProtocols){
        weekProtocols.sort(Comparator.comparing(WeeklyReportDTO::getProject));
        return weekProtocols;
    }
}