package oop.aufgabe4.muloe;

import oop.aufgabe4.DispoException;
import oop.aufgabe4.EinzahlungException;
import oop.aufgabe4.KeineKontoDeckungException;

public class Konto {
    private double kontoStand;
    private int dispo;

    private final KontoAuszug kontoAuszug = new KontoAuszug();

    public KontoAuszug getKontoAuszug() {
        return kontoAuszug;
    }

    public Konto() {
        this.kontoStand = 0;
        this.dispo = 0;
    }

    public Konto(double kontoStand, int dispo) throws DispoException, EinzahlungException {
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

    public void einzahlen(double summe) throws EinzahlungException {
        if (summe > 0) {
            kontoStand += summe;
        } else {
            throw new EinzahlungException("Summe ist zu klein!");
        }

    }

    public void auszahlen(double summe, String kategorie) throws KeineKontoDeckungException {
        summe = summe >= 0 ? summe : summe * -1;
        if (kontoStand + dispo >= summe) {
            kontoStand -= summe;
            kontoAuszug.eintragHinzufuegen(summe, kategorie);
        } else {
            throw new KeineKontoDeckungException("Nicht ausreichende Kontodeckung!");
        }
    }

    public double getKontoStand() {
        return kontoStand;
    }
}
