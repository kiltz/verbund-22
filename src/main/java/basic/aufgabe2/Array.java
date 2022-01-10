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

public class Array {
	public static void main(String[] args) {

		//double zufall = Math.random();

		int[] wurf = {1, 2, 3, 4, 5, 6};

		for (int i = 1; i <= 10000; i++) {
			double zufall = Math.random();
			wurf[i] = (int) ((zufall * 6) + 1);
			System.out.println(i + "  Ergebnis: " + i);




			}
		/*	System.out.println("1: " + );
			System.out.println("2: " + );
			System.out.println("3: " + );
			System.out.println("4: " + );
			System.out.println("5: " + );
			System.out.println("6: " + );
			*/

		}


	}

