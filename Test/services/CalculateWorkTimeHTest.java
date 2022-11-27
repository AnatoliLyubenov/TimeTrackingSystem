package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateWorkTimeHTest {

    @Test
    void convertMtoHLessThen60() {
        int minutes=55;
        assertEquals("0:"+minutes+" minutes.", CalculateWorkTimeH.convertMtoH(minutes));
    }
    @Test
    void convertMtoHEquals60() {
        int minutes=60;
        assertEquals("1 hour.", CalculateWorkTimeH.convertMtoH(minutes));
    }
    @Test
    void convertMtoHAbove1Hour() {
        int minutes=125;
        assertEquals("2 hours 5 minutes.", CalculateWorkTimeH.convertMtoH(minutes));
    }
    @Test
    void convertMtoHBellow1Hour() {
        int minutes=85;
        assertEquals("1 hour 25 minutes.", CalculateWorkTimeH.convertMtoH(minutes));
    }
}