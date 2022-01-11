package basic.aufgabe3;

public class FibonacciFolge {
    public static void main(String[] args) {
        for (int i, j = 1, k = 2; k < 100; i = j, j = k, k = i + j) {
            System.out.println(k);
        }
    }
}
