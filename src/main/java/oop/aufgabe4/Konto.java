package oop.aufgabe4;

public class Konto {
    int kontoDispo = 0;
    int kontostand = 0;

    public void setDispo(int dispo) {
        kontoDispo = -dispo;
    }

    public void einzahlen(int betrag) {
        kontostand = kontostand + betrag;
    }

    public int getKontoStand() {
        return kontostand;
    }

    public void auszahlen(int betrag) {
        if((kontostand - betrag) < kontoDispo) {
            System.out.println("Maximale Ausgabesumme liegt bei " + (kontostand - kontoDispo) + " Euro.");
        } else {
            kontostand = kontostand - betrag;
        }
    }
}
