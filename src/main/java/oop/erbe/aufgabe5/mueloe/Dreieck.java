package oop.erbe.aufgabe5.mueloe;

public class Dreieck extends Form {
    int seiteA;
    int seiteB;
    int seiteC;

    public Dreieck(int seiteA, int seiteB, int seiteC) {
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
