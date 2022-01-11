package oop.aufgabe4;

public class Konto {
    int dispo = 0;
    int kontostand = 0;
    public int getKontoStand() {
        return kontostand;
    }

    public void setDispo(int neuerDispo) {
        dispo = neuerDispo;
    }

    public void einzahlen(int betrag) {
        kontostand += betrag;
    }

    public void auszahlen(int ausgezahlt) {
        if (kontostand <= dispo) {
            System.out.println("ausgezahlt: " + ausgezahlt);
            kontostand -= ausgezahlt;
        }
        else {
            System.out.println("Betrag überschreitet die Grenze");
        }
    }
}
