package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    int length;
    int width;

    public Rechteck(int length, int width) {
        super();
        this.length = length;
        this.width = width;
    }

    @Override
    public double berechneUmfang() {
        return length * 2 + width * 2;
    }
}