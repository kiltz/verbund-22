package basic.aufgabe11;

import features.inout.aufgabe.Datei;
import features.inout.aufgabe.DateiTester;
import utils.Zahlen;

import java.text.ParseException;

public class KontoauszugLeser extends DateiTester {
    public static void main(String[] args) {
        // 1. Lese die Datei "kontoauszug.csv" ein

        Datei d = new Datei("kontoauszug.csv");
        //String datei =   "12.01.2022;Bar;150,00 \n" +
        //               "13.01.2022;Versicherungen;125,54\n" +
        //              "13.01.2022;Telefon;45,12";
        //String eineZeile = "13.01.2022;Bar;70";
        String[] teile = d.split(";");
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
        // 2.Zerlege den Text in die Zeilen
        String[] zeilen = d.split("\n");
        // 3. Zerlege jede Zeile
        double summe = 0;
        for (int i = 0; i < zeilen.length; ++i) {
            // 3. Splitte nach dem ;
            teile = zeilen[i].split(";");
            // 4. Summiere die Beträge auf
            if (teile.length == 3) {
                double zahl = 0;
                try {
                    zahl = Zahlen.stringToDouble(teile[2]);
                    summe += zahl;
                } catch (ParseException e) {
                    System.err.println("Die Zahl " + teile[2] + " ist nicht umwandelbar: " + e.getMessage());
                }
            }
            // 5. gebe die Summe aus
            System.out.println("Summe: " + Zahlen.doubleToString(summe));
            // Variiere die Datei!

            // Zusatzaufgabe:
            // Erstellt 500 Buchungen mit unterschiedlichen Buchungstexten und Beträgen
        }
    }
}
