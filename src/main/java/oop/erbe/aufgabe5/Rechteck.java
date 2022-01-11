package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    int hoehe;
    int laenge;

    public Rechteck(int hoehe, int laenge) {
        this.hoehe = hoehe;
        this.laenge = laenge;
    }

    @Override
    public double berechneUmfang() {
        return laenge + hoehe;
    }
}


