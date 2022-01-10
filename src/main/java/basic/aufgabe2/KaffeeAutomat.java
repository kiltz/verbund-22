package basic.aufgabe2;
import java.util.HashMap;

public class KaffeeAutomat {


	public static void main(String[] args) {
		// Angenommen: Ein Kaffee kostet 30 Cent,
		// wir werfen eine 2-Euro Münze in den Automat
		// Welche Münzen bekommen wir als Rückgeld?

		// 1. definiere den Preis und das gezahlte Geld am Anfang der Methode

		// 2. Ermittle mit Hilfe von Modulo die Anzahl der einzelnen
		// 		Münzen und arbeite mit dem Rest weiter.

		// 3. Vereinfache die Lösung mit Schleifen

		int kaffeePreis = 30;
		int bezahlung = 200;
		int [] muenzenWerte = {200, 100, 50, 20, 10, 5, 2, 1};
		int restBetrag = bezahlung - kaffeePreis;
		int indexZaehler = 0;

		for(int a : muenzenWerte) {
			System.out.println((int)(restBetrag / muenzenWerte[indexZaehler]) + " mal " + String.valueOf(a) + "-Cent-Münze");
			restBetrag = restBetrag % muenzenWerte[indexZaehler];
			++indexZaehler;
		}

	}

}
