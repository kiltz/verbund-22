package basic.aufgabe11;

import utils.muloe.Datei;

import java.text.ParseException;
import java.util.HashMap;

import static utils.Zahlen.doubleToString;
import static utils.Zahlen.stringToDouble;

public class KontoauszugLeser {

    public static void main(String[] args) {

        double summe = 0;
        double value = 0.0;
        String[] zahlungszwecke = {"Miete", "Bar", "Versicherung", "Strom- und Wasserkosten", "Klamotten"};
        HashMap<String, Double> statistik = new HashMap<>();
        Datei datei = new Datei("kontoauszug.csv");

        for (int i = 0; i < 501; ++i) {
            int tag = (int) (Math.random() * 31);
            int indexZahlungszweck = (int) (Math.random() * 5);
            double betrag = Math.random() * 500;
            String datumDateiEintrag = tag + ".12.2021";
            String text = datumDateiEintrag + ";" + zahlungszwecke[indexZahlungszweck] + ";" + doubleToString(betrag) + "\n";
            datei.schreibe(text, true);
        }

        String inhalt = datei.lese();
        String[] textInZeilen = inhalt.split("\n");
        for (String t : textInZeilen) {

            try {
                String[] bestandteile = t.split(";");
                String key = bestandteile[1];
                value = stringToDouble(bestandteile[2]);
                summe += value;
                if (statistik.containsKey(key)) {
                    value += statistik.get(key);
                }
                statistik.put(key, value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        statistik.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + doubleToString(entry.getValue()));
        });
        System.out.println("Summe: " + doubleToString(summe));
    }
}
