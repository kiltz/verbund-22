package oop.erbe.aufgabe5.mueloe;

public class Rechteck extends Form {
    int breite;
    int laenge;

    public Rechteck(int breite, int laenge) {
        super();
        this.breite = breite;
        this.laenge = laenge;
    }

    @Override
    public double berechneUmfang() {
        return 2 * (breite + laenge);
    }
}
