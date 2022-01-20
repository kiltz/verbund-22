package oop.aufgabe4.muloe;

abstract class Buchung {
    String buchungArt;
    String datum;
    double betrag;
    String zweck;

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

    public String getZweck() {
        return zweck;
    }

    public void setZweck(String zweck) {
        this.zweck = zweck;
    }

    public String buchungInfosGeben() {
        return String.format("%s;%s;%.2f;%s\n", buchungArt, datum, betrag, zweck);
    }
}
