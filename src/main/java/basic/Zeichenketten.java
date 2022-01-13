package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zeichenketten {
    static String kleinBuchstaben = "abcdefghijklmnopqrstuvwxyz";
    static String zahlen = "0123456789";
    static String grossBuchstaben = kleinBuchstaben.toUpperCase();
    static String sonderzeichen = "!§$%&/()=?*'@#";

    public static void main(String[] args) {
//        char einA = kleinBuchstaben.charAt(0);
//        System.out.println(einA);
//        String neu = "" + kleinBuchstaben.charAt(13) + kleinBuchstaben.charAt(4) + kleinBuchstaben.charAt(20);
//        System.out.println(neu);
//
//        int index = (int) (Math.random() * 26);
//        System.out.println("Index: " + index + ": " + kleinBuchstaben.charAt(index));
//        // nur Kleinbuchstaben
//        StringBuilder passwort = new StringBuilder();
//        for (int i = 0; i < 8; ++i) {
//            index = (int) (Math.random() * 26);
//            passwort.append(kleinBuchstaben.charAt(index));
//        }
//        System.out.println(passwort);
        // mit Großbuchstaben und Sonderzeichen
//        String erlaubteZeichen = kleinBuchstaben + grossBuchstaben + sonderzeichen;
//        passwort = new StringBuilder();
//        for (int i = 0; i < 12; ++i) {
//            index = (int) (Math.random() * erlaubteZeichen.length());
//            passwort.append(erlaubteZeichen.charAt(index));
//        }
//        System.out.println(passwort);

        String passwortMitZahlen = generierePasswort(15, false,
                true, false);
        String passwortMitGrossBuchstabenUndZahlen = generierePasswort(8,
                true, true, false);
        String passwortMitSonderzeichen = generierePasswort(5,
                false, false, true);

        System.out.println(passwortMitZahlen);
        System.out.println(passwortMitGrossBuchstabenUndZahlen);
        System.out.println(passwortMitSonderzeichen);

        String passwortCheck = generierePasswort(3,
                true, true, true);
        System.out.println(passwortCheck);
    }

    private static String generierePasswort(int laengePasswort, boolean mitGrossbuchstaben,
                                            boolean mitZahlen, boolean mitSonderzeichen) {
        List<String> zeichensets = new ArrayList<>();
        if (mitGrossbuchstaben) {
            zeichensets.add(grossBuchstaben);
        }
        if (mitZahlen) {
            zeichensets.add(zahlen);
        }
        if (mitSonderzeichen) {
            zeichensets.add(sonderzeichen);
        }

        if (laengePasswort < zeichensets.size()) {
            throw new IllegalArgumentException("Passwort ist  zu kurz!");
        }

        List<Integer> zeichenStelleInPasswort = new ArrayList<>(Collections.nCopies(zeichensets.size(), -1));
        StringBuilder passwort = new StringBuilder();

        for (int i = 0, indexZeichenset, indexChar; i < laengePasswort; ++i) {
            indexZeichenset = (int) (Math.random() * zeichensets.size());
            indexChar = (int) (Math.random() * zeichensets.get(indexZeichenset).length());

            passwort.append(zeichensets.get(indexZeichenset).charAt(indexChar));
            zeichenStelleInPasswort.set(indexZeichenset, i);
        }

        for (int i = 0, indexInPasswort, indexChar; i < zeichenStelleInPasswort.size(); i++) {
            if (zeichenStelleInPasswort.get(i) == -1) {
                while (true) {
                    indexInPasswort = (int) (Math.random() * passwort.length());
                    if (!zeichenStelleInPasswort.contains(indexInPasswort)) {
                        indexChar = (int) (Math.random() * zeichensets.get(i).length());
                        passwort.setCharAt(indexInPasswort, zeichensets.get(i).charAt(indexChar));
                        zeichenStelleInPasswort.set(i, indexInPasswort);
                        break;
                    }
                }
            }
        }

        return passwort.toString();
    }
}
