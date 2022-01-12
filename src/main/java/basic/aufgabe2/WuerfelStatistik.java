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

		int anzahlEinser = 0;
		int anzahlZweier = 0;
		int anzahlDreier = 0;
		int anzahlVierer = 0;
		int anzahlFuenfer = 0;
		int anzahlSechser = 0;

		for (int i = 1; i <= 10000; ++i) {
			double zufall = Math.random();

			int i = (int) (zufall * 6) + 1;
			if (i == 1) {
				anzahlEinser++;
			}
			if (i == 2) {
				anzahlZweier++;
			}
			if (i == 3) {
				anzahlDreier++;
			}
			if (i == 4) {
				anzahlVierer++;
			}
			if (i == 5) {
				anzahlFuenfer++;
			}
			if (i == 6) {
				anzahlSechser++;
			}
			System.out.println("Einser:" + anzahlEinser);
			System.out.println("Zweier:" + anzahlZweier);
			System.out.println("Dreier:" + anzahlDreier);
			System.out.println("Vierer:" + anzahlVierer);
			System.out.println("Fuenfer:" + anzahlFuenfer);
			System.out.println("Sechser:" + anzahlSechser);
		}
	}
}