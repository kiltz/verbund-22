package oop;

public class Kreis {
    // darf nicht negativ sein!
    private int radius;

    public Kreis(int radius) {
        setRadius(radius);
    }

    public Kreis() {
        System.out.println("Werde erzeugt....");
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius >= 0) {
            this.radius = radius;
        }
    }

    double berechneUmfang() {
        double umfang = 2 * Math.PI * radius;
        return umfang;
    }

    public double getPi() {
        return Math.PI;
    }
}
 