package oop.aufgabe4;

public class Bank {
    public static void main(String[] args) {
        Konto k = new Konto();
        k.setDispo(1000);
        k.einzahlen(500);
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
    }
}
