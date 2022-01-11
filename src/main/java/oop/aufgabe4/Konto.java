package oop.aufgabe4;

public class Konto {
    int dispo = 0;
    int kontostand = 0;

    public void setDispo(int neuerDispo) {dispo = neuerDispo;}

    public void einzahlen(int betrag){
        kontostand += betrag;
    }

    public void auszahlen(int betrag) {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
        }
    }

    public int getKontoStand(){
        return kontostand;
    }
}
