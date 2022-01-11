package oop;

public class Kreis {
    // darf nicht negativ sein!
    private int radius;

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
}
