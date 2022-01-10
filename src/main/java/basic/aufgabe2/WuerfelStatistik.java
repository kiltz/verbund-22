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
		int max = 6;
		int min = 1;
		int durchlaeufe = 10000;
		int [] statistik = {0, 0, 0, 0, 0, 0};
		double startTime = System.currentTimeMillis();

		for(int i = 0; i<durchlaeufe; i++)
		{
			int würfelzahl = (int)(Math.random() * max + min);

			switch(würfelzahl){
				case 1:
					statistik[0] = ++statistik[0];
					break;
				case 2:
					statistik[1] = ++statistik[1];
					break;
				case 3:
					statistik[2] = ++statistik[2];
					break;
				case 4:
					statistik[3] = ++statistik[3];
					break;
				case 5:
					statistik[4] = ++statistik[4];
					break;
				case 6:
					statistik[5] = ++statistik[5];
					break;
			}
		}
		for(int a : statistik){
			System.out.println(a);
		}

		System.out.println(System.currentTimeMillis() - startTime + " Millisekunden");
	}
}
