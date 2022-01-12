package oop.aufgabe4;

/*
Aufgabe 4:
Bitte diese Klasse nicht verändern.
Die Klasse soll ausgeführt werden können und es erscheint keine Ausgabe.

 */
public class Bank {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws Exception {
        Konto k = new Konto();
        k.setDispo(1000);
        k.einzahlen(500);
        if (k.getKontoStand() != 500) {
            System.out.println("Fehler 1");
        } else {
            System.out.println("500 eingezahlt!");
        }
        // 3. Behandle die Fehlersituationen
        // => es darf kein Fehler auftauchen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != 200) {
                System.out.println("Fehler 2");
            } else {
                System.out.println("300 ausgezahlt!");
            }
        } catch (KeineKontoDeckungException e) {
            System.out.println("Konto wird zu weit überzogen");
        }
        // 4. Behandle die Fehlersituationen
        // => es darf kein Fehler auftauchen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 3");
            } else {
                System.out.println("300 ausgezahlt!");
            }
        } catch (KeineKontoDeckungException e) {
            System.out.println("Konto wird zu weit überzogen");
        }
        // 5. Behandle die Fehlersituationen
        // => es muss ein Fehler auftauchen
        try {
            k.auszahlen(1000);
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 4");
            } else {
                System.out.println("1000 ausgezahlt!");
            }
        } catch (KeineKontoDeckungException e) {
            System.out.println(ANSI_GREEN + "Konto wird zu weit überzogen, was richtig ist!" + ANSI_RESET);
        }
    }
}
