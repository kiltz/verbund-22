package basic.aufgabe11;

import features.inout.aufgabe.Datei;
import features.inout.aufgabe.DateiTester;
import utils.Zahlen;

import java.text.ParseException;

public class KontoauszugLeser extends DateiTester {
    public static void main(String[] args) {
        // 1. Lese die Datei "kontoauszug.csv" ein

        Datei d = new Datei("kontoauszug.csv");
        String inhalt = d.lese();
        String[] zeilen = inhalt.split("\n");
        // 3. Zerlege jede Zeile
        double summe = 0;
        for (int i = 0; i < zeilen.length; ++i) {
            // 3. Splitte nach dem ;
            String[] teile = zeilen[i].split(";");
            // 4. Summiere die Beträge auf
            try {
                double zahl = Zahlen.stringToDouble(teile[2]);
                summe += zahl;
            } catch (ParseException e) {
                    System.err.println("Die Zahl " + teile[2] + " ist nicht umwandelbar: " + e.getMessage());
                }

            // 5. gebe die Summe aus
            System.out.println("Summe: " + Zahlen.doubleToString(summe));
            // Variiere die Datei!

            // Zusatzaufgabe:
            // Erstellt 500 Buchungen mit unterschiedlichen Buchungstexten und Beträgen
        }
    }
}
