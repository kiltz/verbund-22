package oop.erbe.aufgabe5;

public class Kreis extends Form {

    int radiusA;

    public Kreis(int radiusA){
        super();
    this.radiusA = radiusA;
    }

    @Override

    public double berechneUmfang(){
        double umfang = 2 * Math.PI * radiusA;
        return umfang;
    }

}
