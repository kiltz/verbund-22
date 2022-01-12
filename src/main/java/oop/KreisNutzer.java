package oop;

public class KreisNutzer {
    public static void main(String[] args) {

        // Erzeugen einer Instanz der Klasse Kreis
        Kreis k1 = new Kreis();
        k1.setRadius(10);

        Kreis k2 = new Kreis(-20);

        k1.setRadius(-20);
        System.out.println(k1.getRadius());
        k1 = k2;
        //k2 = null;
        System.out.println(k1.getRadius());

        System.out.println(k2.berechneUmfang());
        System.out.println(k1.berechneUmfang());

    }
}
