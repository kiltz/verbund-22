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
		long bevor = System.currentTimeMillis();
		int[] statistik = wuerfeln(100000);
		long danach = System.currentTimeMillis();

		for (int j = 1; j < 7; j++) {
			System.out.print(String.format("Die zahl %d wurde %d Mal gewürfelt.\n", j, statistik[j-1]));
		}
		System.out.println(String.format("Der Durchlauf hat %d Millisekunden gedauert.", (danach - bevor)));

	}

	static int[] wuerfeln(int bereich) {
		int zufall;
		int[] versuche = {0, 0, 0, 0, 0, 0};

		for (int i = 0; i < bereich; i++) {
			zufall = (int)(Math.random() * 6 + 1);
			versuche[zufall-1]++;
		}
		return versuche;
	}
}
