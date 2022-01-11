package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    private int hoehe;
    private int breite;
    public Rechteck(int hoehe, int breite) {
        if (hoehe > 0 && breite > 0) {
            this.hoehe = hoehe;
            this.breite = breite;
        }
    }

    @Override
    public double berechneUmfang() {
        return 2 * hoehe + 2 * breite;
    }
    @Override
    public String toString() {
        return String.format("Rechteck (%d, %d)", hoehe, breite);
    }
}
