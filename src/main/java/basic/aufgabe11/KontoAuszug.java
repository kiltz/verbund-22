package basic.aufgabe11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KontoAuszug {
    private Map<String, List<String[]>> eintraege = new HashMap<>();
    private double alleAusgaben = 0;

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
                System.out.println(String.format("\t(%s) %.2f Euro", str[0], summeTemp));
                summe += summeTemp;
            }

            System.out.println(String.format("Summe von allen Ausgaben in Kategorie %s: %.2f", e.getKey(), summe));
            System.out.println("-----------------------------------------------------");
        }
        System.out.println(String.format("Ausgaben: %.2f Euro", alleAusgaben));
    }
}
