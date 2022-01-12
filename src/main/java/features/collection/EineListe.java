package features.collection;

import java.util.ArrayList;
import java.util.List;

public class EineListe {
    public static void main(String[] args) {
        // Erzeugung
        List<String> liste = new ArrayList<>();

        // füttern
        liste.add("Eins");
        liste.add("Zwei");
        liste.add("Drei");

        // durchlaufen
        for (String s : liste) {
            System.out.println(s);
        }

    }
}
