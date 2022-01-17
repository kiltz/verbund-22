package oop.erbe.aufgabe5;

public class Rechteck extends Form {

    int seiteX;
    int seiteY;
    public Rechteck(int seiteX, int seiteY) {
        super();
    this.seiteX = seiteX;
    this.seiteY = seiteY;
    }

    @Override

    public double berechneUmfang() {
        double umfangr = 2 * (seiteX + seiteY);
        return umfangr;
    }

}
