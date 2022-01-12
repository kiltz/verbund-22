package oop.erbe.aufgabe5; // & Aufgabe 6

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

        System.out.println(r1);

        /* Aufgabe 6:
            1. Erstellt eine Liste für Form-Elemente
            2. Fügt der Liste ein paar Elemente (Dreiecke, Rechtecke, Kreise) hinzu.
            3. Durchlauft die Liste und gebt die entsprechenden Umfänge aus.
            4. Zusatz: gebt aus um welche genaue Form (Dreieck, Rechteck, Kreis) es sich handelt.

         */
        List<String> formElemente = new ArrayList<>();
        formElemente.add("Dreieck: " + d1.berechneUmfang());
        formElemente.add("Rechteck: " + r1.berechneUmfang());
        formElemente.add("Kreis: " + k1.berechneUmfang());
        for (String f : formElemente) {
            System.out.println(f);
        }
    }
}
