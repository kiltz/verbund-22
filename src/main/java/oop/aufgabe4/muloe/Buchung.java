package oop.aufgabe4.muloe;

abstract class Buchung {
    String buchungArt;
    String datum;
    double betrag;

    public String getBuchungArt() {
        return buchungArt;
    }

    public void setBuchungArt(String buchungArt) {
        this.buchungArt = buchungArt;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String buchungInfosGeben() {
        return String.format("%s;%s;%.2f\n", buchungArt, datum, betrag);
    }
}
