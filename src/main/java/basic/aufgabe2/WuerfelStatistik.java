package basic.aufgabe2;

import java.util.Arrays;

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
		int zahlen[] = new int[7];
		int eins = 0;
		int zwei = 0;
		int drei = 0;
		int vier = 0;
		int fuenf = 0;
		int sechs = 0;
		int gesamt = 0;

		for (int i = 1; i <= 10000; ++i) {

			double zufall = Math.random();
			int zahl = (int) (zufall * 6) + 1;
			if (zahl == 1){
				eins++;
				zahlen[1] = eins;
			}
			else if (zahl == 2){
				zwei++;
				zahlen[2] = zwei;
			}
			else if (zahl == 3){
				drei++;
				zahlen[3] = drei;
			}
			else if (zahl == 4){
				vier++;
				zahlen[4] = vier;
			}
			else if (zahl == 5){
				fuenf++;
				zahlen[5] = fuenf;
			}
			else{
				sechs++;
				zahlen[6] = sechs;
			}
			gesamt = ++gesamt;
		}
		/*System.out.println("Anzahl der gewuerfelten Zahlen:"
				+ "\n1: " + eins
				+ "\n2: " + zwei
				+ "\n3: " + drei
				+ "\n4: " + vier
				+ "\n5: " + fuenf
				+ "\n6: " + sechs);
		 */
		// System.out.println(Arrays.toString(zahlen));
		for(int i=0; i<=6; i++) {
			System.out.print(i + ": " + zahlen[i] + "\n");
		}
		System.out.println("--------" + "\nGesamt: " + gesamt);
	} // 0 wird mit eingeschlossen, weil die "eins" auf den zweiten bzw [1]. Stelle und nicht auf [0] gespeichert wird
}
