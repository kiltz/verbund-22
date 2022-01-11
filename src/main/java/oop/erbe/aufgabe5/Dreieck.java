package oop.erbe.aufgabe5;

public class Dreieck extends Form {
    double seiteA;
    double seiteB;
    double seiteC;
    public Dreieck(double seiteA, double seiteB, double seiteC) {
        super();
        this.seiteA = seiteA;
        this.seiteB = seiteB;
        this.seiteC = seiteC;
    }
    @Override
    public double berechneUmfang() {
        return seiteA + seiteB + seiteC;
    }
}
