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

		int eins = 0;
		int zwei = 0;
		int drei = 0;
		int vier = 0;
		int fuenf = 0;
		int sechs =0;
		for (int i = 1; i <= 10000; ++i) {
			double zufall = Math.random();
			int zahl = (int) (zufall * 6) + 1;
			// System.out.println(zahl);
			if (zahl == 1){
				eins++;
			}
			else if (zahl == 2){
				zwei++;
			}
			else if (zahl == 3){
				drei++;
			}
			else if (zahl == 4){
				vier++;
			}
			else if (zahl == 5){
				fuenf++;
			}
			else{
				sechs++;
			}
		}
		System.out.println("Anzahl der gewuerfelten Zahlen:"
				+ "\n1: " + eins
				+ "\n2: " + zwei
				+ "\n3: " + drei
				+ "\n4: " + vier
				+ "\n5: " + fuenf
				+ "\n6: " + sechs);
	}
}
