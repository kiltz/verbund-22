package oop.aufgabe4;



/*
Bitte diese Klasse nicht verändern.
Die Klasse soll ausgeführt werden können und es erscheint keine Ausgabe.

 */
public class Bank {
    public static void main(String[] args) {

        try {
            Konto k = new Konto(500, 1000);

            if (k.getKontoStand() != 500) {
                System.out.println("Fehler 1");
            }
            k.auszahlen(300);
            if (k.getKontoStand() != 200) {
                System.out.println("Fehler 2");
            }
            k.auszahlen(300);
            if (k.getKontoStand() != -100) {
                System.out.println(k.getKontoStand());
                System.out.println("Fehler 3");
            }
            k.auszahlen(1000);
            if (k.getKontoStand() != -100) {
                System.out.println("Fehler 4");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
