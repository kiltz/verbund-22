package basic.aufgabe11;

import utils.muloe.Datei;

public class KontoauszugLeser {
    public static void main(String[] args) {
        double d_summe = 0.0d;
        double d_betrag = 0.0d;

        // 1. Lese die Datei "kontoauszug.csv" ein
        Datei d = new Datei("kontoauszug.csv");

        // 2.Zerlege den Text in die Zeilen

        // 3. Zerlege jede Zeile

        // 4. Summiere die Beträge auf
        d_summe = d_summe + d_betrag;

        // 5. gebe die Summe aus
        System.out.println(d_summe);

        // Variiere die Datei!

        // Zusatzaufgabe:
        // Erstellt 500 Buchungen mit unterschiedlichen Buchungstexten und Beträgen

    }
}
