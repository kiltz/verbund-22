package oop.aufgabe4.muloe;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class KontoAuszug {
    private final String path = "src/main/java/oop/aufgabe4/muloe/auszug.txt";
    NumberFormat nf = NumberFormat.getInstance();
    private List<Eintrag> eintraege;
    private List<Eintrag> eintraegeList;

    private void eintraegeLesen() {
        eintraege = new ArrayList<>();
        try {
            for (String zeile : Files.readAllLines(Paths.get(path))) {
                String[] temp = zeile.split(";");
                eintraege.add(new Eintrag(temp[0], temp[1], temp[2]));
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

    public List<Eintrag> getEintraege() {
        eintraegeLesen();
        return eintraege;
    }

    public List<Eintrag> getEintraege(String kategorie) {
        eintraegeLesen();
        eintraegeList = new ArrayList<>();

        for (Eintrag eintrag : eintraege) {
            if (eintrag.getKategorie().equals(kategorie)) {
                eintraegeList.add(eintrag);
            }
        }
        return eintraegeList;
    }


    //    public void eintraegeSortieren(String flag) {
//        Comparator<String[]> vergleich;
//        if (flag.equalsIgnoreCase("betrag")) {
//            vergleich = new betragComparator();
//        }
//        else if (flag.equalsIgnoreCase("datum")) {
//            vergleich = new datumComparator();
//        }
//        else {
//            throw new IllegalArgumentException();
//        }
//
//        for (Map.Entry<String, List<String[]>> e : eintraege.entrySet()) {
//                e.getValue().sort(vergleich);
//            }
//    }
//    public static class datumComparator implements Comparator<String[]> {
//        @Override
//        public int compare(String[] first, String[] second) {
//            String[] a = first[0].split("\\.");
//            String[] b = second[0].split("\\.");
//            String a1 = String.format("%s%s%s", a[2], a[1], a[0]);
//            String b1 = String.format("%s%s%s", b[2], b[1], b[0]);
//            return  a1.compareTo(b1);
//        }
//
//    }
//
//    public static class betragComparator implements Comparator<String[]> {
//        @Override
//        public int compare(String[] first, String[] second) {
//            double a = Double.parseDouble(first[1]);
//            double b = Double.parseDouble(second[1]);
//            return  (int)(a - b);
//        }
//
//    }
}
