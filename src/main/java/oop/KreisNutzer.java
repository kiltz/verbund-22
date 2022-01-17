package oop;

public class KreisNutzer {
    public static void main(String[] args) throws RadiusZuKleinException {

        // Erzeugen einer Instanz der Klasse Kreis
        Kreis k1 = new Kreis();
        k1.setRadius(10);

        Kreis k2 = null;
        try {
            k2 = new Kreis(-20);
            System.out.println("Fehler: Hier müsste eine Ex geworfen worden sein.");
        } catch (RadiusZuKleinException e) {
            System.out.println("Hat einen Fehler geworfen, was richtig ist.");
        }
        k2 = new Kreis(10);
        k1.setRadius(20);
        System.out.println(k1.getRadius());
        k1 = k2;
        //k2 = null;
        System.out.println(k1.getRadius());

        System.out.println(k2.berechneUmfang());
        System.out.println(k1.berechneUmfang());

    }
}
