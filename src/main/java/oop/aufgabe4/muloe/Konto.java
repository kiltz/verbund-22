package oop.aufgabe4.muloe;

import java.util.ArrayList;
import java.util.List;

public class Konto {
    private double dispo = 0;
    private double kontostand = 0;
    private List<Double> buchungen = new ArrayList<>();
    private List<Double> al_einzahlungen = new ArrayList<>();
    private List<Double> al_auszahlungen = new ArrayList<>();


    public Konto() {
        this(0);
    }

    public Konto(double dispo) {
        this.dispo = dispo;
    }

    public Konto(double dispo, double kontostand) {
        this.dispo = dispo;
        this.kontostand = kontostand;
    }

    public void setDispo(double neuerDispo) {
        dispo = neuerDispo;
    }

    public void einzahlen(double betrag) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
        buchungen.add(betrag);
        al_einzahlungen.add(betrag);
    }

    public double getKontoStand() {
        return kontostand;
    }

    // 2. gebe die Exception weiter
    public void auszahlen(double betrag) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
            buchungen.add(betrag * -1);
            al_auszahlungen.add(betrag * -1);
        } else {
            throw new KeineKontoDeckungException(kontostand, betrag);
        }
    }

    public List<Double> getBuchungen() {
        return buchungen;
    }

    public List<Double> getEinzahlungen() {
        return al_einzahlungen;
    }

    public List<Double> getAuszahlungen() {
        return al_auszahlungen;
    }
}
