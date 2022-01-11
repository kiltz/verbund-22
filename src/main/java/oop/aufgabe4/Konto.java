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

    public boolean auszahlen(int summe) {
        if (kontoStand >= 0 && kontoStand + dispo < summe || kontoStand < 0 && dispo < summe) {
            return false;
        }
        else if (kontoStand >= summe) {
            kontoStand -= summe;
        }
        else if (kontoStand > 0){
            kontoStand -= summe;
            dispo += kontoStand;
        }
        else {
            kontoStand -= summe;
            dispo -= summe;
        }
        return true;
    }

    public int getKontoStand() {
        return kontoStand;
    }
}
