package oop.aufgabe4;

public class Konto {
    private int kontoStand;
    private int dispo;

    public Konto() {
        this.kontoStand = 0;
        this.dispo = 0;
    }

    public Konto(int kontoStand, int dispo) throws DispoException, EinzahlungException {
        einzahlen(kontoStand);
        setDispo(dispo);
    }

    public void setDispo(int dispo) throws DispoException {
        if (dispo >= 0) {
            this.dispo = dispo;
        } else {
            throw new DispoException("Dispo kann nicht negativ sein!");
        }
    }

    public void einzahlen(int summe) throws EinzahlungException {
        if (summe > 0) {
            kontoStand += summe;
        } else {
            throw new EinzahlungException("Summe ist zu klein!");
        }

    }

    public void auszahlen(int summe) throws KeineKontoDeckungException {
        summe = summe >= 0 ? summe : summe * -1;
        if (kontoStand + dispo >= summe) {
            kontoStand -= summe;
        } else {
            throw new KeineKontoDeckungException("Nicht ausreichende Kontodeckung!");
        }
    }

    public int getKontoStand() {
        return kontoStand;
    }
}
