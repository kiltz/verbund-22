package basic;

import java.util.HashMap;

public class ZeichenkettenSplitten {
    public static void main(String[] args) {
        String text = "13.01.2022;Bar;70\n" +
                "13.01.2022;Telefon;45\n" +
                "13.01.2022;Bar;150\n" +
                "13.01.2022;Versicherung;156";
        String eineZeile = "13.01.2022;Bar;70";
        int summe = 0;
        HashMap<String, Integer> statistik = new HashMap<>();
//        String[] teile = eineZeile.split(";");
//        if (teile.length == 3) {
//            System.out.println("Betrag: " + teile[2]);
//            int zahl = Integer.parseInt(teile[2]);
//            System.out.println(zahl);
//        }

        String[] textInZeilen = text.split("\n");
        for (String t : textInZeilen) {
            String[] bestandteile = t.split(";");
            String key = bestandteile[1];
            int value = Integer.parseInt(bestandteile[2]);
            summe += value;
            if (statistik.containsKey(key)) {
                value += statistik.get(key);
            }
            statistik.put(key, value);
        }
        statistik.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
        System.out.println("Summe: " + summe);


        // Zusatz: Statistik für gleiche Bezeichnungen (Map?)
    }
}
