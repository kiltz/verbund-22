package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    private double länge;
    private double breite;

    public Rechteck(double länge, double breite) {
        this.länge = länge;
        this.breite = breite;
    }

    protected double berechneUmfang() {
        return (2 * (länge + breite));
    }
}
