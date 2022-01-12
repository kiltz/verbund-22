package features.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EineMap {
    public static void main(String[] args) {
        // 1. Erzeugung
        Map<Integer, String> monate = new HashMap<>();

        // 2. Füttern
        monate.put(1, "Jan");
        monate.put(2, "Feb");
        monate.put(3, "Mär");

        // Ausgeben eines bestimmten Schlüsssels
        System.out.println(monate.get(3));

        // Überschreiben
        monate.put(3, "Mar");
        System.out.println(monate.get(3));

        // durchlaufen
        for (Map.Entry e : monate.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        // System-Properties
        Properties props = System.getProperties();
        for (Map.Entry e : props.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

    }
}
