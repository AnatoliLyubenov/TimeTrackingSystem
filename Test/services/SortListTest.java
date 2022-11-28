package services;

import org.junit.jupiter.api.Test;
import wrapperDTO.WeeklyReportDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortListTest {

    @Test
    void sortByProjectName() {
        ArrayList<WeeklyReportDTO> weekProtocols=new ArrayList<>();
        weekProtocols.add(new WeeklyReportDTO("test", "test","Project","Test",25,"Test"));
        weekProtocols.add(new WeeklyReportDTO("test", "test","Project","Test",25,"Test"));
        weekProtocols.add(new WeeklyReportDTO("test", "test","Project222","Test",25,"Test"));
        assertEquals(weekProtocols,SortList.sortByProjectName(weekProtocols));
    }
}