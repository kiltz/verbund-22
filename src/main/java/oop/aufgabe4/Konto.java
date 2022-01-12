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

    public void einzahlen(int betrag) throws BetragIstNegativException {
        //kontostand = kontostand + betrag;
        if (betrag > 0) {
            kontostand += betrag;
        } else {
            throw new BetragIstNegativException("Geben Sie einen validen Betrag, größer als 0, an.");
        }
    }

    public int getKontoStand() {
        return kontostand;
    }

    // 2. gebe die Exception weiter
    public void auszahlen(int betrag) throws KeineKontoDeckungException, BetragIstNegativException {
        if (betrag > 0) {
            if (kontostand + dispo >= betrag) {
                kontostand -= betrag;
            } else {
                // mecker!
                // 1. Wirf eine "KeineKontoDeckungException"
                // analog zu den "RadiusZuKleinException"
                throw new KeineKontoDeckungException("Das Kontolimit wurde überschritten. Die Summe kann nicht ausgezahlt werden.");
            }
        } else {
            throw new BetragIstNegativException("Geben Sie einen validen Betrag, größer als 0, an.");
        }

    }
}
