package oop.aufgabe4.muloe;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KontoAuszug {
    private final String path = "src/main/java/oop/aufgabe4/muloe/auszug.txt";
    NumberFormat nf = NumberFormat.getInstance();
    private Map<String, List<String[]>> eintraege;
    private double alleAusgaben = 0;

    private void ausgabenLesen() {
        eintraege = new HashMap<>();
        try {
            for (String zeile : Files.readAllLines(Paths.get(path))) {
                eintragHinzufuegen(zeile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eintragHinzufuegen(String neuerEintrag) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(neuerEintrag);
        } catch (IOException ignore) {
        }
    }

    public void eintraegeSortieren(String flag) {
        Comparator<String[]> vergleich;
        if (flag.equalsIgnoreCase("betrag")) {
            vergleich = new betragComparator();
        } else if (flag.equalsIgnoreCase("datum")) {
            vergleich = new datumComparator();
        } else {
            throw new IllegalArgumentException();
        }

        for (Map.Entry<String, List<String[]>> e : eintraege.entrySet()) {
            e.getValue().sort(vergleich);
        }
    }

    public double getAusgaben(String kategorie) {
        double summe = 0;
        for (String[] str : eintraege.get(kategorie)) {
            summe += Double.parseDouble(str[1]);
        }
        return summe;
    }

    public double getAusgaben() {
        return alleAusgaben;
    }

    public void alleAusgabenZeigen() {
        for (Map.Entry<String, List<String[]>> e : eintraege.entrySet()) {
            double summe = 0, summeTemp;
            System.out.println("Kategorie: " + e.getKey());
            for (String[] str : e.getValue()) {
                summeTemp = Double.parseDouble(str[1]);
                System.out.println(String.format("\t(%s) %-6.2f Euro", str[0], summeTemp));
                summe += summeTemp;
            }

            System.out.println(String.format("Summe von allen Ausgaben in Kategorie %s: %.2f", e.getKey(), summe));
            System.out.println("-----------------------------------------------------");
        }
        System.out.println(String.format("Ausgaben: %.2f Euro", alleAusgaben));
    }

    public static class datumComparator implements Comparator<String[]> {
        @Override
        public int compare(String[] first, String[] second) {
            String[] a = first[0].split("\\.");
            String[] b = second[0].split("\\.");
            String a1 = String.format("%s%s%s", a[2], a[1], a[0]);
            String b1 = String.format("%s%s%s", b[2], b[1], b[0]);
            return a1.compareTo(b1);
        }

    }

    public static class betragComparator implements Comparator<String[]> {
        @Override
        public int compare(String[] first, String[] second) {
            double a = Double.parseDouble(first[1]);
            double b = Double.parseDouble(second[1]);
            return (int) (a - b);
        }

    }
}
