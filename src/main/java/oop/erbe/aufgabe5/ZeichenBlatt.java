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
        Form r1 = new Rechteck(10, 20);
        Form k1 = new Kreis(14);


        List<Form> forms = new ArrayList<>();
        forms.add(d1);
        forms.add(r1);
        forms.add(k1);

        for (Form f : forms) {
            System.out.printf("%s hat einen Umfang von %.2f cm%n", f, f.berechneUmfang());
        }
    }
}
