package basic.aufgabe11.mueloe;

import utils.Zahlen;
import utils.muloe.Datei;

import java.text.ParseException;

public class KontoauszugLeser {
    public static void main(String[] args) {
        // 1. Lese die Datei "kontoauszug.csv" ein
        Datei d = new Datei("kontoauszug.csv");
        String inhalt = d.lese();

        // 2.Zerlege den Text in die Zeilen
        String[] zeilen = inhalt.split("\n");

        double summe = 0;
        // 3. Zerlege jede Zeile
        for (int i = 0; i < zeilen.length; ++i) {

            String[] teile = zeilen[i].split(";");

            // 4. Summiere die Beträge auf
            try {
                double zahl = Zahlen.stringToDouble(teile[2]);
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
