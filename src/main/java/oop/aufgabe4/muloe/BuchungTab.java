package oop.aufgabe4.muloe;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    //private TextField tfEingabe;
    private TextField tfEingabe;
    private Label anzeige;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox();
        anzeige = new Label("Dialog für Buchungen");
        Button bEinzahlen = new Button("Einzahlen");
        Button bAbheben = new Button("Abheben");
        bEinzahlen.setDefaultButton(true);

        tfEingabe = new TextField();

        bEinzahlen.setOnAction(e -> einzahlen(e));
        bAbheben.setOnAction(e -> abheben(e));
        anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        box.setSpacing(10);

        box.getChildren().add(tfEingabe);
        box.getChildren().add(anzeige);
        box.getChildren().add(bEinzahlen);
        box.getChildren().add(bAbheben);
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }

    private void einzahlen(ActionEvent e) {
        String eingabe = tfEingabe.getText();
        if (eingabe.isEmpty()) {
            tfEingabe.setPromptText("Bitte Zahlen Eingeben!");
        } else {
            berechneEingabe(eingabe);

        }
    }

    private void abheben(ActionEvent e) {
        String eingabe = tfEingabe.getText();
        if (eingabe.isEmpty()) {
            tfEingabe.setPromptText("Bitte Zahlen Eingeben!");
        } else {
            berechneAbhebung(eingabe);

        }
    }

    private void berechneEingabe(String eingabe) {
        konto.einzahlen(Double.parseDouble(eingabe));
        anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        anzeige.setTextFill(Color.web("#000000"));

    }

    private void berechneAbhebung(String eingabe) {
        try {
            konto.auszahlen(Double.parseDouble(eingabe));
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
            anzeige.setTextFill(Color.web("#000000"));
        } catch (KeineKontoDeckungException e) {
            anzeige.setText("Auszahlung nicht möglich: " + e.getMessage());
            anzeige.setTextFill(Color.web("#990000"));
        }

    }
}
