package oop;

public class Kreis {
    // darf nicht negativ sein!
    private int radius;

    public Kreis(int radius) throws RadiusZuKleinException {
        setRadius(radius);
    }

    public Kreis() {
        System.out.println("Werde erzeugt....");
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws RadiusZuKleinException {
        if (radius >= 0) {
            this.radius = radius;
        } else {
            throw new RadiusZuKleinException("Radius ist zu klein!");
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
 