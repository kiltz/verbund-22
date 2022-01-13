package basic.aufgabe9;

public class ZeichenkettenLoesung {
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
        String erlaubteZeichen = kleinBuchstaben;
        if (mitGrossbuchstaben) {
            erlaubteZeichen += grossBuchstaben;
        }
        //erlaubteZeichen = mitZahlen ? erlaubteZeichen + zahlen : erlaubteZeichen;
        if (mitZahlen) {
            erlaubteZeichen += zahlen;
        }
        if (mitSonderzeichen) {
            erlaubteZeichen += sonderzeichen;
        }
        // 2. Passwort erstellen
        StringBuilder passwort = new StringBuilder();
        for (int i = 0; i < laengePasswort; ++i) {
            int index = (int) (Math.random() * erlaubteZeichen.length());
            passwort.append(erlaubteZeichen.charAt(index));
        }

        // 3. Passwort zurück geben
        return passwort.toString();
    }
}
