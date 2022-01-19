package oop.aufgabe4.muloe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

public class AuszugTab extends BasisTab {
    private final KontoAuszug kontoAuszug;

    public AuszugTab(Konto konto) {
        kontoAuszug = konto.getKontoAuszug();
    }

    @Override
    public Tab getTab() {
        HBox box = new HBox();
        Label anzeige = new Label("Dialog für Auzüge");
        Button bEinzahlen = new Button("aktualisieren");

        box.getChildren().addAll(anzeige, bEinzahlen);
        Tab tab = new Tab("Auszüge", box);
        return tab;
    }
}
