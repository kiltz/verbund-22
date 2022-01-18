package oop.aufgabe4.muloe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oop.aufgabe4.EinzahlungException;
import oop.aufgabe4.KeineKontoDeckungException;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    private String temp = "";
    private Label lKontostand;
    private Label lAnzeige;
    private TextField tfBetrag;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        lKontostand = new Label(String.format("Kontostand: %.2f", konto.getKontoStand()));
        lKontostand.setAlignment(Pos.CENTER);

        tfBetrag = new TextField();
        tfBetrag.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*(,(\\d){2})?")) {
                temp = newValue;
            } else if (newValue.matches("\\d*,(\\d)?")) {
            } else {
                tfBetrag.setText(temp);
            }
        });

        lAnzeige = new Label("");
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> einzahlen());

        Button bBezahlen = new Button("Bezahlen");
        bBezahlen.setOnAction(e -> bezahlen());


        HBox hBox = new HBox(bEinzahlen, bBezahlen);
        hBox.setSpacing(10);

        VBox box = new VBox(lKontostand, tfBetrag, hBox, lAnzeige);
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }

    private void bezahlen() {
        try {
            konto.auszahlen(Double.parseDouble(tfBetrag.getText().replace(",", ".")));
            lKontostand.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        } catch (KeineKontoDeckungException ex) {
            lAnzeige.setText(ex.getMessage());
            lAnzeige.setTextFill(Color.RED);
        } catch (NumberFormatException ex) {
            lAnzeige.setText("Unerwarteter Fehler");
            lAnzeige.setTextFill(Color.RED);
        }
    }

    private void einzahlen() {
        try {
            konto.einzahlen(Double.parseDouble(tfBetrag.getText().replace(",", ".")));
            lKontostand.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        } catch (EinzahlungException ex) {
            lAnzeige.setText(ex.getMessage());
            lAnzeige.setTextFill(Color.RED);
        } catch (NumberFormatException ex) {
            lAnzeige.setText("Unerwarteter Fehler");
            lAnzeige.setTextFill(Color.RED);
        }
    }
}
