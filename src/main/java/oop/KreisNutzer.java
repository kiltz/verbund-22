package oop;

public class KreisNutzer {
    public static void main(String[] args) throws RadiusZuKleinException {
        // Erzeugen einer Instanz der Klasse Kreis
        Kreis k1 = new Kreis();
        k1.setRadius(10);

        Kreis k2 = new Kreis();

        k2.setRadius(10);

        k1.setRadius(-20);
        System.out.println(k1.getRadius());
        k1 = k2;
        System.out.println(k1.getRadius());

        System.out.println(k2.berechneUmfang());
        System.out.println(k1.berechneUmfang());

    }
}
