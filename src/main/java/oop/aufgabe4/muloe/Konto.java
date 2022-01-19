package oop.aufgabe4.muloe;

import java.util.ArrayList;
import java.util.List;

public class Konto {
    private double dispo = 0;
    private double kontostand = 0;
    private List<Buchung> buchungen;


    public Konto() {
        this(0);
    }

    public Konto(double dispo) {
        this.dispo = dispo;
        buchungen = new ArrayList<>();
    }

    public Konto(double dispo, double kontostand) {
        this.dispo = dispo;
        this.kontostand = kontostand;
    }

    public void setDispo(double neuerDispo) {
        dispo = neuerDispo;
    }

    public double getDispo() {
        return dispo;
    }

    public void einzahlen(double betrag) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
        buchungen.add(new Einzahlung(betrag));
    }

    public double getKontoStand() {
        return kontostand;
    }

    // 2. gebe die Exception weiter
    public void auszahlen(double betrag) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
            buchungen.add(new Auszahlung(betrag));
        } else {
            throw new KeineKontoDeckungException(kontostand, kontostand + dispo);
        }
    }

    public List<Buchung> getBuchungen() {
        return buchungen;
    }
}
