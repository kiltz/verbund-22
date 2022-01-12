package oop.erbe.aufgabe5;

/*
Bitte nichts an der Klasse ZeichenBlatt ändern.
Dafür sorgen, dass gültige Werte bei den berechneUmfang zurück gegeben werden.

Bitte nicht den Kreis aus oop nutzen!

 */


import java.util.ArrayList;
import java.util.List;

public class ZeichenBlatt {

    public static void main(String[] args) {

        // Seitenlängen
        Form d1 = new Dreieck(10, 20, 14);
        System.out.println(d1.berechneUmfang());

        Form r1 = new Rechteck(10, 20);
        System.out.println(r1.berechneUmfang());

        Form k1 = new Kreis(14);
        System.out.println(k1.berechneUmfang());

        System.out.println();

        /* Aufgabe:
            1. Erstellt eine Liste für Form-Elemente
            2. Fügt der Liste ein paar Elemente (Dreiecke, Rechtecke, Kreise) hinzu.
            3. Durchlauft die Liste und gebt die entsprechenden Umfänge aus.

         */
        List<Form> liste = new ArrayList<>();
        liste.add(new Dreieck(10, 20, 14));
        liste.add(new Kreis(14));
        liste.add(new Rechteck(10, 20));

        //@Override
        for (Form a : liste) {
            System.out.println(a.berechneUmfang());
        }
    }
}
