package basic.aufgabe3;

public class FibonacciFolge {
    public static void main(String[] args) {
        //Gebe die Fibonacci bis 100 aus
        int x = 0;
        System.out.println(x);
        int y = 1;
        System.out.println(y);
        int z = x + y;

        while (z < 100){
            System.out.println(z);
            x = y;
            y = z;
            z = x + y;

        }
    }
}
