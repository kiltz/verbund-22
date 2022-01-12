package oop.aufgabe4;

public class Konto {
    int dispo = 0;
    int kontostand = 0;

    public Konto() {
    }

    public Konto(int dispo) {
        this.dispo = dispo;
    }

    public Konto(int dispo, int kontostand) {
        this.dispo = dispo;
        this.kontostand = kontostand;
    }

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

    // 2. gebe die Exception weiter
    public void auszahlen(int betrag) throws AuszahlSummeZuGrossException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
        } else {
            // mecker!
            // 1. Wirf eine "KeineKontoDeckungException"
            // analog zu den "RadiusZuKleinException"
            throw new AuszahlSummeZuGrossException("Das Kontolimit wurde überschritten. Die Summe kann nicht ausgezahlt werden.");
        }
    }
}
