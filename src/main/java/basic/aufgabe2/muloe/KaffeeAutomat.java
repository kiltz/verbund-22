package basic.aufgabe2.muloe;

public class KaffeeAutomat {

    public static void main(String[] args) {
        // Angenommen: Ein Kaffee kostet 30 Cent,
        // wir werfen eine 2-Euro Münze in den Automat
        // Welche Münzen bekommen wir als Rückgeld?

        // 1. definiere den Preis und das gezahlte Geld am Anfang der Methode
        int preis = 30;
        int gegeben = 200;

        ermittleWechselgeld(preis, gegeben);

    }

    private static void ermittleWechselgeld(int preis, int gegeben) {
        // 2. Ermittle mit Hilfe von Modulo die Anzahl der einzelnen
        // 		Münzen und arbeite mit dem Rest weiter.
        int rest = gegeben - preis;
        System.out.println("Rückgeld " + rest);


        // 3. Vereinfache die Lösung mit Schleifen
        int[] muenzen = {100, 50, 20, 10, 5, 2, 1};
        String[] bezeichnung = {"1-EUR", "50-Cent", "20-Cent", "10-Cent", "5-Cent", "2-Cent", "1-Cent"};
        for (int i = 0; i < muenzen.length; ++i) {
            int anzahl = rest / muenzen[i];
            rest = rest % muenzen[i];
            System.out.println(anzahl + " " + bezeichnung[i] + "-Münzen (Rest: " + rest + ")");

        }
    }

}
