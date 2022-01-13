package basic;

public class ZeichenkettenSplitten {
    public static void main(String[] args) {
        String text = "13.01.2022;Bar;70\n" +
                "13.01.2022;Telefon;45\n" +
                "13.01.2022;Bar;150\n" +
                "13.01.2022;Versicherung;156";

        String eineZeile = "13.01.2022;Bar;70";

        String[] teile = eineZeile.split(";");
        if (teile.length == 3) {
            System.out.println("Betrag: " + teile[2]);
            int zahl = Integer.parseInt(teile[2]);
            System.out.println(zahl);
        }
        // 1. Splittet den text nach dem \n => zeilen

        // (definiere eine Summe)

        // 2. für jede Zeile

        // 3. Splitte nach dem ;

        // 4. summiere die Beträge (Umwandeln String -> int, summe += betrag)


        // 5. Summe ausgeben.

        // Zusatz: Statistik für gleiche Bezeichnungen (Map?)
    }
}
