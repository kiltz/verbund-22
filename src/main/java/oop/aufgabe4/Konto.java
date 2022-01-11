package oop.aufgabe4;

public class Konto {
    int kontoStand = 0;
    int dispo = 0;

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public void einzahlen(int summe) {
        kontoStand += summe;
    }

    public void auszahlen(int summe) {
        if (kontoStand + dispo >= summe) {
            kontoStand -= summe;
        }
    }

    public int getKontoStand() {
        return kontoStand;
    }
}
