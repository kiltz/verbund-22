package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datum {

    public static void main(String[] args) {

        System.out.println(dateToString(LocalDate.now()));
        System.out.println(string2Date("13.01.2022"));
    }

    private static LocalDate string2Date(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String dateToString(LocalDate date) {

        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
