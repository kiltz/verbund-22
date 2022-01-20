package oop.aufgabe4.muloe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

public class BuchungTab extends BasisTab {
    private final Konto konto;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        HBox box = new HBox();
        Label anzeige = new Label("Dialog für Buchungen");
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> {
            konto.einzahlen(100);
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        });
        box.getChildren().addAll(bEinzahlen, anzeige);
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }
}
