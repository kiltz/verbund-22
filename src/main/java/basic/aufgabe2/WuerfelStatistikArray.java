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
**/

public class WuerfelStatistik {
	public static void main(String[] args) {

		//double zufall = Math.random();

		int zahleins = 0;
		int zahlzwei = 0;
		int zahldrei = 0;
		int zahlvier = 0;
		int zahlfuenf = 0;
		int zahlsechs = 0;

		for (int i = 1; i <= 10000; i++) {
			double zufall = Math.random();
			int zahl = (int) ((zufall * 6) + 1);
			System.out.println(i + "  Ergebnis: " + zahl);



			switch (zahl){
				case 1:
					zahleins = zahleins + 1;
					break;
				case 2:
					zahlzwei = zahlzwei + 1;
					break;
				case 3:
					zahldrei = zahldrei + 1;
					break;
				case 4:
					zahlvier = zahlvier + 1;
					break;
				case 5:
					zahlfuenf = zahlfuenf + 1;
					break;
				case 6:
					zahlsechs = zahlsechs + 1;
					break;
				}
			}
			System.out.println("1: " + zahleins);
			System.out.println("2: " + zahlzwei);
			System.out.println("3: " + zahldrei);
			System.out.println("4: " + zahlvier);
			System.out.println("5: " + zahlfuenf);
			System.out.println("6: " + zahlsechs);
		}


	}

