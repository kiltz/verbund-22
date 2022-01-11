package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    private double l;
    private double b;

    public Rechteck(double l, double b) {
        this.l = l;
        this.b = b;
    }

    protected double berechneUmfang(){
        return (2 * (l + b));
    }
}
