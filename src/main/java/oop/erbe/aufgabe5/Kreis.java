package oop.erbe.aufgabe5;

public class Kreis extends Form {
    private double radius;

    public Kreis(double radius) {
        this.radius = radius;
    }

    protected double berechneUmfang() {
        return (2 * Math.PI * radius);
    }
}
