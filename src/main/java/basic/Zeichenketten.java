package basic;

public class Zeichenketten {
    static String kleinBuchstaben = "abcdefghijklmnopqrstuvwxyz";
    static String zahlen = "0123456789";
    static String grossBuchstaben = kleinBuchstaben.toUpperCase();
    static String sonderzeichen = "!§$%&/()=?*'@#";

    public static void main(String[] args) {
        //                        01234567890123456789012345

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
        String erlaubteZeichen = kleinBuchstaben;
        String genPasswort = "";
        int index;
        // 1. erlaubte Zeichen zusammen basteln
        if (mitGrossbuchstaben) {
            erlaubteZeichen += (grossBuchstaben);
        }
        if (mitZahlen) {
            erlaubteZeichen += (zahlen);
        }
        if (mitSonderzeichen) {
            erlaubteZeichen += (sonderzeichen);
        }
        // 2. Passwort erstellen
        for (int i = 0; i < laengePasswort; ++i) {
            index = (int) (Math.random() * erlaubteZeichen.length());
            genPasswort += erlaubteZeichen.charAt(index);
        }
        // 3. Passwort zurück geben
        return genPasswort;
    }
}
