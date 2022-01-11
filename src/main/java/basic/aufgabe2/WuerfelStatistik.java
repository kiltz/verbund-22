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
		int zahlen[] = new int[6];
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
				zahlen[0] = eins;
			}
			else if (zahl == 2){
				zwei++;
				zahlen[1] = zwei;
			}
			else if (zahl == 3){
				drei++;
				zahlen[2] = drei;
			}
			else if (zahl == 4){
				vier++;
				zahlen[3] = vier;
			}
			else if (zahl == 5){
				fuenf++;
				zahlen[4] = fuenf;
			}
			else{
				sechs++;
				zahlen[5] = sechs;
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
		for(int j=0; j<=6; j++) { // 11.01. | doppelte deklaration von "i" zu "j"
			System.out.print((j+1) + ": " + zahlen[j] + "\n");

		}
		System.out.println("--------" + "\nGesamt: " + gesamt);
	}
	// 10.01. |0 wird mit eingeschlossen, weil die "eins" auf den zweiten bzw "[1]". Stelle und nicht auf "[0]" gespeichert wird
	// 10.01. |> wurde im println mit "(i+1)" in Zeile 76:30 gelöst --> ArrayIndexOutOfBoundsException error kommt trotzdem
}
