package oop.aufgabe4.muloe;

public class Konto {
    int dispo = 0;
    int kontostand = 0;

    public void setDispo(int neuerDispo) {
        dispo = neuerDispo;
    }

    public void einzahlen(int betrag) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
    }

    public int getKontoStand() {
        return kontostand;
    }

    public void auszahlen(int betrag) {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
        }
    }
}
