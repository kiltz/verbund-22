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

    // 2. gebe die Exception weiter
    public void auszahlen(int betrag) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
        } else {
            throw new KeineKontoDeckungException("Konto wird zu weit überzogen");
        }
    }
}
