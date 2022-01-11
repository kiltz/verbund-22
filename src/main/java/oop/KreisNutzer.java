package oop;

public class KreisNutzer {
    public static void main(String[] args) {
        // Erzeugen einer Instanz der Klasse Kreis
        Kreis k1 = new Kreis();
        k1.radius = 10;

        Kreis k2 = new Kreis();
        k2.radius = 10;

        k1.radius = 20;

        k1 = k2;
        System.out.println(k1.radius);

        System.out.println(k2.berechneUmfang());
        System.out.println(k1.berechneUmfang());

    }
}
