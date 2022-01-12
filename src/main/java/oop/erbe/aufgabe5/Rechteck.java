package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    private int laenge;
    private int breite;

    public Rechteck(int laenge, int breite) {
        if (laenge > 0 && breite > 0) {
            this.laenge = laenge;
            this.breite = breite;
        }
    }

    @Override
    public double berechneUmfang() {
        return 2 * laenge + 2 * breite;
    }

    @Override
    public String toString() {
        return "Rechteck{" +
                "laenge=" + laenge +
                ", breite=" + breite +
                '}';
    }
}
