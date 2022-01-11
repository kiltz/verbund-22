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
  */

public class WuerfelStatistikArray {
	public static void main(String[] args) {

		int[] wurf = {0, 0, 0, 0, 0, 0};

		for (int i = 1; i <= 10000; ++i){
			double zufall = Math.random();
			int zahl = (int) ((zufall * 6) + 1);

			wurf[zahl - 1]++;
		}

		for (int i = 0; i < 6; ++i){
			System.out.println((i+1) + ": " + wurf[i]);
		}

		}

	}
