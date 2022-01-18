package oop.aufgabe4.muloe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    //private TextField tfEingabe;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox();
        Label anzeige = new Label("Dialog für Buchungen");
        Button bEinzahlen = new Button("Einzahlen");
        Button bAbheben = new Button("Abheben");
        bEinzahlen.setOnAction(e -> {
            konto.einzahlen(100);
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        });
        bAbheben.setOnAction(e -> {
            try {
                konto.auszahlen(50);
            } catch (KeineKontoDeckungException ex) {
                ex.printStackTrace();
            }
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        });
        box.setSpacing(10);
        //box.getChildren().add(tfEingabe);
        box.getChildren().add(anzeige);
        box.getChildren().add(bEinzahlen);
        box.getChildren().add(bAbheben);
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }
}
