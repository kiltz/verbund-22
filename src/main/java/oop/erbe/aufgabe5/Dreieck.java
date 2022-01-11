package oop.erbe.aufgabe5;

public class Dreieck extends Form {
    private double l1;
    private double l2;
    private double l3;

    public Dreieck(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    protected double berechneUmfang(){
        return (l1 + l2 + l3);
    }

}
