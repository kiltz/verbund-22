package oop.erbe.aufgabe5;

/*
Bitte nichts an der Klasse ZeichenBlatt ändern.
Dafür sorgen, dass gültige Werte bei den berechneUmfang zurück gegeben werden.

Bitte nicht den Kreis aus oop nutzen!

 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ZeichenBlatt {

    public static void main(String[] args) {
        // Seitenlängen
        List<Form> liste = new ArrayList<Form>();

        liste.add(new Dreieck(10, 20, 14));
        liste.add(new Rechteck(11, 18));
        liste.add(new Dreieck(9, 7, 14));
        liste.add(new Kreis(16));
        liste.add(new Kreis(10));
        liste.add(new Dreieck(10, 20, 14));
        liste.add(new Rechteck(23, 9));

        for (Form elem : liste) {
            String fullClassName = elem.getClass().toString();
            String[] split = fullClassName.split(Pattern.quote("."));
            System.out.println(elem.berechneUmfang() + " " + split[3]);
        }
    }
}
