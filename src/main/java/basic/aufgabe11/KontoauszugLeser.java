package basic.aufgabe11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class KontoauszugLeser {
    public static void main(String[] args) throws IOException {
        // 1. Lese die Datei "kontoauszug.csv" ein

        // 2.Zerlege den Text in die Zeilen

        // 3. Zerlege jede Zeile

        // 4. Summiere die Beträge auf

        // 5. gebe die Summe aus

        // Variiere die Datei!

        // Zusatzaufgabe:
        // Erstellt 500 Buchungen mit unterschiedlichen Buchungstexten und Beträgen

//        String datum, kategorie, betrag;
//        String[] kategorien = {"Kleidung", "Lebensmittel", "Auto", "Fast-Food", "Sport"};
//
//        DateTimeFormatter muster = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate heute = LocalDate.now();
//
//        for (int i = 0; i < 500; i++) {
//            kategorie = kategorien[(int) (Math.random() * kategorien.length)];
//            datum = heute.minusDays((int) (Math.random() * 500)).format(muster);
//            betrag = String.format("%.2f", (Math.random() * 500));
//            Files.writeString(Paths.get("auszug.txt"), String.format("%s;%s;%s\n", datum, kategorie, betrag), StandardOpenOption.APPEND);
//        }


        List<String> eintraege = Files.readAllLines(Paths.get("auszug.txt"));

        KontoAuszug kontoAuszug = new KontoAuszug();

        for (String s : eintraege) {
            kontoAuszug.eintragHinzufuegen(s);
        }

        kontoAuszug.eintraegeSortieren("betrag");
        kontoAuszug.alleAusgabenZeigen();

    }
}
