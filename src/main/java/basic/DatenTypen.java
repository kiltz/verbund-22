package basic;

public class DatenTypen {
    public static void main(String[] args) {
        // Deklarieren
        int gehalt;
        // Initialiseren
        gehalt = 5000;
        // Deklaration und Initialisierung zusammen
        int anteil = 2;

        int deinAnteil = gehalt * (1 / anteil);
        System.out.println("Dein Anteil: " + deinAnteil);

        double netterAnteil = gehalt * (1.0 / anteil);
        // Casting
        int netterAnteilAlsInt = (int)(gehalt * (1.0 / anteil));

        System.out.println(netterAnteil);

        int einfacherAnteil = gehalt / anteil;
        System.out.println(einfacherAnteil);

        float einFloat = 1.0F;
        long einLong = 1L;

        double zahl = 10.0 / 3.0;
        System.out.println(zahl);

    }
}
