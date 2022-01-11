package oop.erbe;

public class Parkplatz {
    public static void main(String[] args) {
        Auto a1 = new Auto();
        System.out.println(a1.getTyp());

        Cabriolet c1 = new Cabriolet();
        System.out.println(c1.getTyp());

        Auto[] buchten = new Auto[8];
        buchten[0] = a1;
        buchten[1] = c1;
        buchten[3] = new Auto();

        for (int i = 0; i < buchten.length; ++i) {
            if (buchten[i] != null) {
                System.out.println(i + ": " + buchten[i].getTyp());

                // ist das Auto nicht nur ein Auto sondern sogar ein Cabrio?
                if (buchten[i] instanceof Cabriolet) {
                    // Casten nach Cabrio
                    Cabriolet c = (Cabriolet) buchten[i];
                    c.oeffneVerdeck();
                }
            } else {
                System.out.println(i + ": ist frei!");
            }
        }

    }
}
