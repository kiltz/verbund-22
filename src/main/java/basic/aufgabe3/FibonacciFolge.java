package basic.aufgabe3;

public class FibonacciFolge {
    public static void main(String[] args) {

        int zahl1 = 0;
        int zahl2 = 1;
        int ergebnis;
        while (zahl1 <= 100) {
            System.out.println(zahl1);
            ergebnis = zahl1 + zahl2;
            zahl1 = zahl2;
            zahl2 = ergebnis;
        }
    }
}