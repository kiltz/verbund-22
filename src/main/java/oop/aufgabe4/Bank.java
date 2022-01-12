package oop.aufgabe4;



/*
Bitte diese Klasse nicht verändern.
Die Klasse soll ausgeführt werden können und es erscheint keine Ausgabe.

 */
public class Bank {
    public static void main(String[] args) throws EinzahlungException, DispoException {

        Konto k = new Konto(500, 1000);

        if (k.getKontoStand() != 500) {
            System.err.println("Fehler 1");
        }

        try {
            k.auszahlen(300);
            if (k.getKontoStand() != 200) {
                System.err.println("Fehler 2");
            }
        } catch (KontoException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            k.auszahlen(300);
            if (k.getKontoStand() != -100) {
                System.err.println("Fehler 3");
            }
        } catch (KontoException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            k.auszahlen(1000);
            if (k.getKontoStand() != -100) {
                System.err.println("Fehler 4");
            }
        } catch (KontoException ignore) {
        }
    }
}
