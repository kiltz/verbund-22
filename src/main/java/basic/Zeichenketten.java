package basic;

public class Zeichenketten {
    static String kleinBuchstaben = "abcdefghijklmnopqrstuvwxyz";
    static String zahlen = "0123456789";
    static String grossBuchstaben = kleinBuchstaben.toUpperCase();
    static String sonderzeichen = "!§$%&/()=?*'@#";

    public static void main(String[] args) {

        char einA = kleinBuchstaben.charAt(0);
        System.out.println(einA);
        String neu = "" + kleinBuchstaben.charAt(13) + kleinBuchstaben.charAt(4) + kleinBuchstaben.charAt(20);
        System.out.println(neu);

        int index = (int) (Math.random() * 26);
        System.out.println("Index: " + index + ": " + kleinBuchstaben.charAt(index));
        // nur Kleinbuchstaben
        StringBuilder passwort = new StringBuilder();
        for (int i = 0; i < 8; ++i) {
            index = (int) (Math.random() * 26);
            passwort.append(kleinBuchstaben.charAt(index));
        }
        System.out.println(passwort);
        // mit Großbuchstaben und Sonderzeichen
        String erlaubteZeichen = kleinBuchstaben + grossBuchstaben + sonderzeichen;
        passwort = new StringBuilder();
        for (int i = 0; i < 12; ++i) {
            index = (int) (Math.random() * erlaubteZeichen.length());
            passwort.append(erlaubteZeichen.charAt(index));
        }
        System.out.println(passwort);

        String passwortMitZahlen = generierePasswort(15, false,
                true, false);
        String passwortMitGrossBuchstabenUndZahlen = generierePasswort(8,
                true, true, false);
        String passwortMitSonderzeichen = generierePasswort(5,
                false, false, true);

        System.out.println(passwortMitZahlen);
        System.out.println(passwortMitGrossBuchstabenUndZahlen);
        System.out.println(passwortMitSonderzeichen);
    }

    private static String generierePasswort(int laengePasswort, boolean mitGrossbuchstaben,
                                            boolean mitZahlen, boolean mitSonderzeichen) {
        // 1. erlaubte Zeichen zusammen basteln
        laengePasswort = (int) (Math.random() * laengePasswort);
        StringBuilder pw = new StringBuilder();

        // 2. Passwort erstellen
        for (int i = 0; i < laengePasswort; i++) {
            if (mitGrossbuchstaben == true) {
                pw.append(grossBuchstaben.charAt((int) (Math.random() * laengePasswort)));
            }
            if (mitSonderzeichen == true) {
                pw.append(sonderzeichen.charAt((int) (Math.random() * laengePasswort)));
            }
            if (mitZahlen == true) {
                pw.append(zahlen.charAt((int) (Math.random() * laengePasswort)));

            }
        }
        // 3. Passwort zurück geben
        System.out.println("PASSWORT: " + pw);
        return pw.toString();
    }
}
