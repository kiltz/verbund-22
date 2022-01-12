package oop.aufgabe4;

import oop.aufgabe4.muloe.KeineKontoDeckungException;
import oop.aufgabe4.muloe.Konto;

/*
Bitte diese Klasse nicht verändern.
Die Klasse soll ausgeführt werden können und es erscheint keine Ausgabe.

 */
public class Bank {
    public static void main(String[] args) throws Exception {


        Konto k = new Konto();
        k.setDispo(1000);
        k.einzahlen(500);
        if (k.getKontoStand() != 500) {
            System.err.println("Fehler1");
        }
        // 3. Behandle die Fehlersituationen
        // => es darf kein Fehler auftauchen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != 200)
                System.out.println("Fehler 2");
        } catch (KeineKontoDeckungException e) {
            System.err.println("Auszahlung Fehlgeschlagen");
        }

        // 4. Behandle die Fehlersituationen
        // => es darf kein Fehler auftauchen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != -100)
                System.out.println("Fehler 3");
        } catch (KeineKontoDeckungException e) {
            System.err.println("Fehler ist aufgetreten");
        }

        // 5. Behandle die Fehlersituationen
        // => es muss ein Fehler auftauchen
        try {
            k.auszahlen(1000);
            if (k.getKontoStand() != -100)
                System.out.println("Fehler 4");
        } catch (KeineKontoDeckungException e) {
            System.err.println("Hat einen Fehler geworfen, was richtig ist.");
        }

    }


}

