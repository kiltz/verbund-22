package basic;

import utils.Zahlen;

import java.text.ParseException;

public class ZeichenkettenSplitten {
    public static void main(String[] args) {
        String text = "13.01.2022;Bar;70,00\n" +
                "13.01.2022;Telefon;45,12\n" +
                "13.01.2022;Bar;müll\n" +
                "#ein Kommentar\n" +
                "13.01.2022;Versicherung;156,85";

        String eineZeile = "13.01.2022;Bar;70";

        String[] teile = eineZeile.split(";");
        if (teile.length == 3) {
            System.out.println("Betrag: " + teile[2]);
            double zahl = 0;
            try {
                zahl = Zahlen.stringToDouble(teile[2]);
                System.out.println(zahl);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        // 1. Splittet den text nach dem \n => zeilen
        String[] zeilen = text.split("\n");

        // (definiere eine Summe)
        double summe = 0;

        // 2. für jede Zeile
        for (int i = 0; i < zeilen.length; ++i) {
            // 3. Splitte nach dem ;
            teile = zeilen[i].split(";");

            // 4. summiere die Beträge (Umwandeln String -> int, summe += betrag)
            if (teile.length == 3) {
                double zahl = 0;
                try {
                    zahl = Zahlen.stringToDouble(teile[2]);
                    summe += zahl;
                } catch (ParseException e) {
                    System.err.println("Die Zahl " + teile[2] + " ist nicht umwandelbar: " + e.getMessage());
                }
            }

        }

        // 5. Summe ausgeben.
        System.out.println("Summe: " + Zahlen.doubleToString(summe));
        // Zusatz: Statistik für gleiche Bezeichnungen (Map?)
    }
}
