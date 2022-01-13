package features.inout.aufgabe;

/**
 * Invariante: Ändere diese Klasse nicht!
 * 
 * 1. Mach IntelliJ glücklich!
 * 
 * 2. Sorge dafür das der Fehler nicht ausgegeben wird.
 * 
 * 3. Optional: die Zusatzaufgabe
 * 
 * @author fk
 *
 */
public class DateiTester {

	public static void main(String[] args) throws Exception {
		String zeile1 = "13.01.2022;Bar;100,00\n";
		String zeile2 = "28.01.2022;Versicherung;860";

		// eine Instanz von "Datei" erzeugen
		Datei d = new Datei("kontoauszug.csv");
		d.schreibe(zeile1);
		d.schreibe(zeile2, true); // anfügen!

		String inhalt = d.lese();
		System.out.println("'" + inhalt + "'");
		//System.out.println("'" + zeile1 + zeile2 + "'");
		if (!inhalt.equals(zeile1 + zeile2)) {
			System.err.println("Fehler: das was gelesen wurde ist nicht gleich dem was geschrieben wurde!");
		}


	}

}
