package oop.erbe.aufgabe5.mueloe;

public class Kreis extends Form {
    int radius;
    public Kreis(int radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double berechneUmfang() {
        return 2 * Math.PI * radius;
    }
}
