package basic.aufgabe2.mueloe;

/**
 * Aufgabe:
 * <p>
 * Würfle 10000 mal, nutze dazu die Klasse Math, die eine Methode random()
 * anbietet die eine Zufallszahl erzeugt.
 * <p>
 * Wandele die Zufallszahl in eine Zahl zwischen 1 und 6 um.
 * <p>
 * Merke Dir in einem Array wie oft welche Zahl gewürfelt wurde.
 * <p>
 * Gebe die Statistik aus.
 * <p>
 * Zusatzaufgabe:
 * <p>
 * Stoppe die Zeit, die für den Durchlauf gebraucht wird.
 * ( System.currentTimeMillis() )
 * Gebe das Ergebnis in ansprechender Form aus.
 * <p>
 * Variiere die Anzahl der Durchläufe, gehe in die Masse.
 */

public class WuerfelStatistik {
    public static void main(String[] args) {


        int[] anzahl = new int[6];

        // tue es 10.000 mal
        for (int i = 1; i <= 10000; ++i) {
            double zufall = Math.random();  // etwas zwischen 0.0 und 0.999
            int zahl = (int) (zufall * 6) + 1; // etwas zwischen 1 und 6

            int index = zahl - 1;
            anzahl[index]++;

        }
        for (int i = 0; i < 6; ++i) {
            System.out.println((i + 1) + ": " + anzahl[i]);
        }


    }
}
