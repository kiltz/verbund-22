package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeichenkettenSplitten {
    public static void main(String[] args) {
        String text = "13.01.2022;Bar;70\n" +
                "13.01.2022;Telefon;45\n" +
                "13.01.2022;Bar;150\n" +
                "13.01.2022;Versicherung;156";

//        String eineZeile = "13.01.2022;Bar;70";
//
//        String[] teile = eineZeile.split(";");
//        if (teile.length == 3) {
//            System.out.println("Betrag: " + teile[2]);
//            int zahl = Integer.parseInt(teile[2]);
//            System.out.println(zahl);
//        }
        // 1. Splittet den text nach dem \n => zeilen

        // (definiere eine Summe)

        // 2. für jede Zeile

        // 3. Splitte nach dem ;

        // 4. summiere die Beträge (Umwandeln String -> int, summe += betrag)


        // 5. Summe ausgeben.

        // Zusatz: Statistik für gleiche Bezeichnungen (Map?)


        String[] eintrag;
        Map<String, List<String[]>> statistik = new HashMap<>();


        for (String s : text.split("\n")) {
            eintrag = s.split(";");
            if (!statistik.containsKey(eintrag[1])) {
                statistik.put(eintrag[1], new ArrayList<String[]>());
            }
            statistik.get(eintrag[1]).add(new String[]{eintrag[0], eintrag[2]});
        }

        int alleAusgaben = 0;
        for (Map.Entry<String, List<String[]>> e : statistik.entrySet()) {
            int summe = 0;
            System.out.println("Kategorie: " + e.getKey());
            for (String[] str : e.getValue()) {
                System.out.println(String.format("\t(%s) %s Euro", str[0], str[1]));
                summe += Integer.parseInt(str[1]);
            }
            alleAusgaben += summe;

            System.out.println(String.format("Summe von allen Ausgaben in Kategorie %s: %d", e.getKey(), summe));
            System.out.println("-----------------------------------------------------");
        }
        System.out.println("Ausgaben: " + alleAusgaben);
    }
}
