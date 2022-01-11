package basic.aufgabe2;

/**
 * Aufgabe:
 * (mit Moritz erarbeitet)
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

public class WuerfelStatistikSwitch {
	public static void main(String[] args) {

		int zahl1 = 0;
		int zahl2 = 0;
		int zahl3 = 0;
		int zahl4 = 0;
		int zahl5 = 0;
		int zahl6 = 0;

		for (int i = 1; i <= 10000; i++) {
			double zufall = Math.random();
			int zahl = (int) ((zufall * 6) + 1);
			System.out.println("Versuch: " + i + "\t\tWurf: " + zahl);

			switch (zahl) {
				case 1:
					zahl1++;
					break;
				case 2:
					zahl2++;
					break;
				case 3:
					zahl3++;
					break;
				case 4:
					zahl4++;
					break;
				case 5:
					zahl5++;
					break;
				case 6:
					zahl6++;
					break;
			}
		}

		System.out.println("1: " + zahl1);
		System.out.println("2: " + zahl2);
		System.out.println("3: " + zahl3);
		System.out.println("4: " + zahl4);
		System.out.println("5: " + zahl5);
		System.out.println("6: " + zahl6);

		}

	}
