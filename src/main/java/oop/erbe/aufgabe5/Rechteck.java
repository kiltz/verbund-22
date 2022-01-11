package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    double length;
    double width;

    public Rechteck(double length, double width) {
        super();
        this.length = length;
        this.width = width;
    }

    @Override
    public double berechneUmfang() {
        return length * 2 + width * 2;
    }
}