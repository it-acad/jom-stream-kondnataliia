package jom.com.softserve.s6.task1;

import java.time.LocalDate;
import java.time.Year;

public class MyUtils {

    public static boolean isLeapYear(int year) {
        return LocalDate.ofYearDay(year, 1).isLeapYear();
    }
}
