package oop.aufgabe4;

/*
Bitte diese Klasse nicht verändern.
Die Klasse soll ausgeführt werden können und es erscheint keine Ausgabe.

 */
public class Bank {
    public static void main(String[] args) throws KeineKontoDeckungException, BetragIstNegativException {
        Konto k = new Konto();
        k.setDispo(1000);
        try {
            k.einzahlen(500);
            if (k.getKontoStand() != 500) {
                System.out.println("Fehler 1");
            }
        } catch (BetragIstNegativException e) {
            System.out.println("Betrag ist zu klein.");
        }
        // 3. Behandle die Fehlersituationen
        // => es darf kein Fehler auftauchen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != 200) {
                System.out.println("Fehler 2");
            }
        } catch (KeineKontoDeckungException e) {
            System.out.println("Die Exception ist falsch.");
        } catch (BetragIstNegativException e) {
            System.out.println("Betrag ist zu klein.");
        }

        // 4. Behandle die Fehlersituationen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 3");
            }
        } catch (KeineKontoDeckungException e) {
            System.out.println("Die Exception ist falsch.");
        } catch (BetragIstNegativException e) {
            System.out.println("Betrag ist zu klein.");
        }
        // 5. Behandle die Fehlersituationen
        // => es muss ein Fehler auftauchen
        try {

            k.auszahlen(1000);
            System.out.println("Das ist ein Fehler");
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 4");
            }
        } catch (KeineKontoDeckungException e) {
            //Die Exception ist richtig und sollte nicht behandelt werden ==> Es sollte keine Ausgabe geschehen
        } catch (BetragIstNegativException e) {
            System.out.println("Betrag ist zu klein.");
        }


    }
}
