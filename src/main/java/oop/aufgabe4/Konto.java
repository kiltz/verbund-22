package oop.aufgabe4;

public class Konto {
    int dispo = 0;
    int kontostand = 0;

    public int setDispo(int neuerDispo) {
         return dispo = neuerDispo;
    }

    public int einzahlen(int betrag) {
        return kontostand += betrag;
    }

    public double getKontoStand() {
        return kontostand;
    }

    public void auszahlen(int betrag) {

        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
        }


    }
}

