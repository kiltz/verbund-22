package oop.erbe.aufgabe5;

import oop.erbe.aufgabe5.mueloe.Dreieck;
import oop.erbe.aufgabe5.mueloe.Form;
import oop.erbe.aufgabe5.mueloe.Kreis;
import oop.erbe.aufgabe5.mueloe.Rechteck;
import oop.wdh.Azubi;
import oop.wdh.AzubiAE;
import oop.wdh.AzubiSI;

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

        Form[] forms = new Form[6];
        forms[0] = new Dreieck(10, 20, 14);
        forms[1] = new Rechteck(10, 20);
        forms[2] = new Kreis(14);
        System.out.println(r1);

        /* Aufgabe:
            1. Erstellt eine Liste für Form-Elemente
            2. Fügt der Liste ein paar Elemente (Dreiecke, Rechtecke, Kreise) hinzu.
            3. Durchlauft die Liste und gebt die entsprechenden Umfänge aus.
            4. Zusatz: gebt aus um welche genaue Form (Dreieck, Rechteck, Kreis) es sich handelt.

         */
        List<Form> liste = new ArrayList<>();
        liste.add(new Dreieck(10, 20, 14));
        liste.add(new Rechteck(10, 20));
        liste.add(new Kreis(14));

        for (Form f : liste) {
            System.out.println(f.berechneUmfang());
        }
    }
}
