package oop.erbe.aufgabe5;

public class Kreis extends Form {
    int radius;

    public Kreis(int radius) {
        this.radius = radius;
    }

    @Override
    public double berechneUmfang() {
        return 2 * Math.PI * radius;
    }
}
