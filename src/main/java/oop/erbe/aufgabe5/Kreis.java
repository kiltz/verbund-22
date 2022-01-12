package oop.erbe.aufgabe5;

public class Kreis extends Form {
    private int radius;

    public Kreis(int radius) {
        if (radius >= 0){
            this.radius = radius;
        }
    }

    @Override
    public double berechneUmfang() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Kreis";
    }


}
