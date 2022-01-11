package oop.erbe.aufgabe5;

public class Kreis extends Form {
    private int radius;

    public Kreis(int radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double berechneUmfang() {
        return 2 * Math.PI * radius;
    }
}