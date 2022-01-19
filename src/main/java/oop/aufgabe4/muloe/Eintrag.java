package oop.aufgabe4.muloe;

public class Eintrag {
    private String datum;
    private String kategorie;
    private String betrag;

    public Eintrag() {
    }

    public Eintrag(String datum, String kategorie, String betrag) {
        this.datum = datum;
        this.kategorie = kategorie;
        this.betrag = betrag;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getBetrag() {
        return betrag;
    }

    public void setBetrag(String betrag) {
        this.betrag = betrag;
    }

    @Override
    public String toString() {
        return "Eintrag{" +
                "datum='" + datum + '\'' +
                ", kategorie='" + kategorie + '\'' +
                ", betrag='" + betrag + '\'' +
                '}';
    }
}
