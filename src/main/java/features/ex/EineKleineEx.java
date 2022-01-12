package features.ex;

public class EineKleineEx {
    public static void main(String[] args) {
        int index = 2;
        int[] zahlen = {1, 2, 3};


        try { // versuche das zu tun:
            System.out.println(zahlen[index]);
            System.out.println("Alles gut");

        } catch (ArrayIndexOutOfBoundsException e) { // fange den Fehler ArrayIndexOutOfBoundsException
            System.err.println("Fehler: " + e.getMessage());

        } finally { // auf alle Fälle tu dies:
            System.out.println("Fertig");
        }
    }
}
