package oop.erbe.aufgabe5;

public class Kreis extends Form {
    private int r;

    public Kreis(int r) {
        this.r = r;
    }

    protected double berechneUmfang(){
        return (2 * Math.PI * r);
    }
}
