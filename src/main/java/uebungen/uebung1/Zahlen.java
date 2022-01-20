package uebungen.uebung1;

import java.text.NumberFormat;
import java.text.ParseException;

public class Zahlen {
    public static void main(String[] args) {
        String zahlAlsString = "123,54";
        try {
            double zahlAlsDouble = stringToDouble(zahlAlsString);
            System.out.println(zahlAlsDouble);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String doubleToString(double zahl) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        return nf.format(zahl);
    }

    public static double stringToDouble(String zahlAlsString) throws ParseException {
        NumberFormat nf = NumberFormat.getInstance();

        double zahl = nf.parse(zahlAlsString).doubleValue();

        return zahl;
    }
}
