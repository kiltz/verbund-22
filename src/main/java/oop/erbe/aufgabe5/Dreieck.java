package oop.erbe.aufgabe5;

public class Dreieck extends Form {
    private int seiteA;
    private int seiteB;
    private int seiteC;

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

