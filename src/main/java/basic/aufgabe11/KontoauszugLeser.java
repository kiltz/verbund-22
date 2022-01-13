package basic.aufgabe11;

import utils.Datei;
import utils.Zahlen;

import java.text.ParseException;

public class KontoauszugLeser {
    public static void main(String[] args) throws ParseException {
        double summe = 0.0;
        // 1. Lese die Datei "kontoauszug.csv" ein
        Datei d = new Datei("kontoauszug.csv");
        String text = d.lese();
        // 2. Zerlege den Text in die Zeilen
        String[] zeilen = text.split("\n");
        // 3. Zerlege jede Zeile
        for (int i = 0; i < zeilen.length; ++i) {
            String[] parts = zeilen[i].split(";");
            // 4. Summiere die Beträge auf
            if (parts.length == 3) {
                // System.out.println("| + €" + parts[2]);
                double betrag = Zahlen.stringToDouble(parts[2]);
                summe += betrag;
            } else {
                System.out.println("Fehler!");
            }

        }
        // 5. gebe die Summe aus
        System.out.println("Summe: €" + Zahlen.doubleToString(summe) + "\n");
        // Variiere die Datei!
        String inhalt = d.lese();
        if (!inhalt.equals(text)) {
            System.out.println("Fehler: das was gelesen wurde ist nicht gleich dem was geschrieben wurde!");
        }
        // Zusatzaufgabe:
        // Erstellt 500 Buchungen mit unterschiedlichen Buchungstexten und Beträgen
    }
}

