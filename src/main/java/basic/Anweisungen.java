package basic;

public class Anweisungen {

    public static void main(String[] args) {
        int stunde = 11;
        boolean norddeutsch = false;

        if (norddeutsch) {
            System.out.println("Moin");
        } else if (stunde < 12) {
            System.out.println("Guten Morgen!");
        } else if (stunde == 12) {
            System.out.println("Mahlzeit");
        } else {
            System.out.println("Guten Tag!");
            System.out.println("Nach 12");
        }

        String monat = "Januar";
        switch (monat) {

            case "Januar":
            case "Februar":
                System.out.println("Winter");
                break;
            case "März":
            case "April":
            case "Mai":
                System.out.println("Frühling");
                break;
            case "Juni":
                System.out.println("Sommer");
                break;
            default:
                System.out.println("Keine Ahnung");

        }

        for (int i = 1; i <= 100; ++i) {
            System.out.println(i + " * "+ i +" = " + (i*i));
        }

        String[] monate = {"Jan", "Feb", "Mär"};
        // For-Each-Schleife
        for (String m : monate) {
            System.out.println(m);
        }

        int i = 1;
        while (i <= 100) {
            System.out.println(i + " * "+ i +" = " + (i*i));
            i++; // i = i + 1;
        }

        int zahl = 1;
        System.out.println(zahl++); // 1
        System.out.println(++zahl); // 3

        do {
            System.out.println(i + " * "+ i +" = " + (i*i));
            i++; // i = i + 1;

        } while ( i <= 100);

    }
}
