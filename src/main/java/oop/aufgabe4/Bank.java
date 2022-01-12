package oop.aufgabe4;

/*
Bitte diese Klasse nicht verändern.
Die Klasse soll ausgeführt werden können und es erscheint keine Ausgabe.

 */
public class Bank {
    public static void main(String[] args) throws AuszahlSummeZuGrossException {
        Konto k = new Konto();
        k.setDispo(1000);
        k.einzahlen(500);
        if (k.getKontoStand() != 500) {
            System.out.println("Fehler 1");
        }
        // 3. Behandle die Fehlersituationen
        // => es darf kein Fehler auftauchen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != 200) {
                System.out.println("Fehler 2");
            }
        } catch (AuszahlSummeZuGrossException e) {
            System.out.println("Die Exception ist falsch.");
        }

        // 4. Behandle die Fehlersituationen
        try {
            k.auszahlen(300);
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 3");
            }
        } catch (AuszahlSummeZuGrossException e) {
            System.out.println("Die Exception ist falsch.");
        }
        // 5. Behandle die Fehlersituationen
        // => es muss ein Fehler auftauchen
        try {
            k.auszahlen(1000);
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 4");
            }
        } catch (AuszahlSummeZuGrossException e) {
            System.out.println("Die Exception ist richtig.");
        }


    }
}
