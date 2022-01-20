package basic.aufgabe11;

import java.text.NumberFormat;
import java.util.*;

public class KontoAuszug {
    private final Map<String, List<String[]>> eintraege = new HashMap<>();
    private double alleAusgaben = 0;
    NumberFormat nf = NumberFormat.getInstance();

    public void eintragHinzufuegen(String neuerEintrag) {
        String[] eintrag = neuerEintrag.split(";");
        assert eintrag.length != 3;
        if (!eintraege.containsKey(eintrag[1])) {
            eintraege.put(eintrag[1], new ArrayList<>());
        }

        String eintragTemp = eintrag[2].replace(',', '.');
        eintraege.get(eintrag[1]).add(new String[]{eintrag[0], eintragTemp});

        alleAusgaben += Double.parseDouble(eintragTemp);


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
