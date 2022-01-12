package oop.erbe.aufgabe5;

public class Dreieck extends Form {
    private double seiteA;
    private double seiteB;
    private double seiteC;

    public Dreieck(double seiteA, double seiteB, double seiteC) {
        this.seiteA = seiteA;
        this.seiteB = seiteB;
        this.seiteC = seiteC;
    }

    protected double berechneUmfang() {
        return (seiteA + seiteB + seiteC);
    }

}
