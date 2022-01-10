package basic.aufgabe2;

/**
 * Aufgabe:
 *
 * Würfle 10000 mal, nutze dazu die Klasse Math, die eine Methode random()
 * anbietet die eine Zufallszahl erzeugt.
 *
 * Wandele die Zufallszahl in eine Zahl zwischen 1 und 6 um.
 *
 * Merke Dir in einem Array wie oft welche Zahl gewürfelt wurde.
 *
 * Gebe die Statistik aus.
 *
 * Zusatzaufgabe:
 *
 * Stoppe die Zeit, die für den Durchlauf gebraucht wird.
 * ( System.currentTimeMillis() )
 * Gebe das Ergebnis in ansprechender Form aus.
 *
 * Variiere die Anzahl der Durchläufe, gehe in die Masse.
 *
 */

public class WuerfelStatistik {
	public static void main(String[] args) {

		for (int i = 1; i <= 10000; ++i) {
			double zufall = Math.random();

			int zahl = (int)(zufall * 6) + 1;
			String[] wuerfe = {"Jan", "Feb", "Mär"};

			String[] wuerfe = {"Einser", "Zweier", "Dreier", "Vierer", "Fünfer", "Sechser"};
			for (String i : wuerfe) {
				System.out.println(i);
			}
		}
	}
}
