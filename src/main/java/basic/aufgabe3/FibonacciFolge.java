package basic.aufgabe3;

public class FibonacciFolge {
    public static void main(String[] args) {
        //Gebe die Fibonacci bis 100 aus
        int zahl1 = 0;
        System.out.println(zahl1);
        int zahl2 = 1;
        System.out.println(zahl2);
        int zahl3 = zahl1 + zahl2;

        while (zahl3 <= 100){
            System.out.println(zahl3);
            zahl1 = zahl2;
            zahl2 = zahl3;
            zahl3 = zahl1 + zahl2;
        }

    }
}
