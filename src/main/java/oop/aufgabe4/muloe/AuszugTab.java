package oop.aufgabe4.muloe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

public class AuszugTab extends BasisTab {
    private final Konto konto;

    public AuszugTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        HBox box = new HBox();
        Label anzeige = new Label("Dialog für Auzüge");
        Button bEinzahlen = new Button("aktualisieren");
        Button bAuszahlen = new Button("aktualisieren");
        bEinzahlen.setOnAction(e ->
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()))
        );
        bAuszahlen.setOnAction(e ->
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand())));
        box.getChildren().addAll(anzeige, bEinzahlen
        );
        Tab tab = new Tab("Auszüge", box);
        tab.setOnSelectionChanged(e ->
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand())));
        return tab;
    }
}
