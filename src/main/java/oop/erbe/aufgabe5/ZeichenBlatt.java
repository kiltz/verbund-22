package oop.erbe.aufgabe5;

import oop.erbe.aufgabe5.muloe.Dreieck;
import oop.erbe.aufgabe5.muloe.Form;
import oop.erbe.aufgabe5.muloe.Kreis;
import oop.erbe.aufgabe5.muloe.Rechteck;

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
