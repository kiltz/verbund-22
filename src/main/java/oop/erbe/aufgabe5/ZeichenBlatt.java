package oop.erbe.aufgabe5;

/*
Bitte nichts an der Klasse ZeichenBlatt ändern.
Dafür sorgen, dass gültige Werte bei den berechneUmfang zurück gegeben werden.

Bitte nicht den Kreis aus oop nutzen!

 */

public class ZeichenBlatt {

    public static void main(String[] args) {
        // Seitenlängen
        Form d1 = new Dreieck(10,20,14);
        System.out.println(d1.berechneUmfang());

        Form r1 = new Rechteck(10,20);
        System.out.println(r1.berechneUmfang());

        Form k1 = new Kreis(14);
        System.out.println(k1.berechneUmfang());

        System.out.println(r1);
    }
}
