package basic;

public class ZeichenkettenSplitten {
    public static void main(String[] args) {
        String text = "13.01.2022;Bar;70\n" +
                "13.01.2022;Telefon;45\n" +
                "13.01.2022;Bar;150\n" +
                "13.01.2022;Versicherung;156";
        /*
        String eineZeile = "13.01.2022;Bar;70";

        String[] teile = eineZeile.split(";");
        if (teile.length == 3) {
            System.out.println("Betrag: " + teile[2]);
            int zahl = Integer.parseInt(teile[2]);
            System.out.println(zahl);
        }
        */

        // 1. Splittet den text nach dem \n => zeilen
        String[] zeilen = text.split("\n");
        // (definiere eine Summe)
        int summe = 0;
        // 2. für jede Zeile
        System.out.println(zeilen);
        int zeilenAnzahl = 0;
        String[] parts;
        int betrag;
        for (int i = 0; i < zeilen.length; ++i) {
            // 3. Splitte nach dem ;
            parts = zeilen[i].split(";");
            // 4. summiere die Beträge (Umwandeln String -> int, summe += betrag)
            System.out.println();
            if (parts.length == 3) {
                betrag = Integer.parseInt(parts[2]);
                summe += betrag;
            } else {
                System.out.println("Da ist etwas schief gelaufen");
            }
        }
        // 5. Summe ausgeben.
        System.out.println("Summe = " + summe);

        // Zusatz: Statistik für gleiche Bezeichnungen (Map?)
    }
}
