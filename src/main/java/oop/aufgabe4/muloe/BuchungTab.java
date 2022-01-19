package oop.aufgabe4.muloe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
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
    private ComboBox<String> cbKategorien;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox(getKontostandZeile(),
                getBetragZeile(),
                getEinzahlungZeile(),
                getAuszahlungZeile());

        box.setSpacing(10);
        box.setPadding(new Insets(10));

        return new Tab("Buchungen", box);
    }

    private void checkEingabe(String newValue) {
        if (newValue.matches("\\d*,?(\\d{1,2})?")) {
            temp = newValue;
        } else {
            tfBetrag.setText(temp);
        }
    }

    private void auszahlen(String kategorie) {
        if (tfBetrag.getText().length() > 0) {
            try {
                konto.auszahlen(Double.parseDouble(tfBetrag.getText().replace(",", ".")), kategorie);
                lKontostand.setText(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
            } catch (KeineKontoDeckungException ex) {
                lAnzeige.setText(ex.getMessage());
            } catch (NumberFormatException ex) {
                lAnzeige.setText("Unerwarteter Fehler");
            }
            tfBetrag.setText("");
        }
    }

    private void einzahlen() {
        if (tfBetrag.getText().length() > 0) {
            try {
                konto.einzahlen(Double.parseDouble(tfBetrag.getText().replace(",", ".")));
                lKontostand.setText(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
            } catch (EinzahlungException ex) {
                lAnzeige.setText(ex.getMessage());
            } catch (NumberFormatException ex) {
                lAnzeige.setText("Unerwarteter Fehler");
            }
            tfBetrag.setText("");
        }
    }

    private Node getKontostandZeile() {
        lKontostand = new Label(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
        lKontostand.setAlignment(Pos.CENTER);
        return lKontostand;
    }

    private Node getBetragZeile() {
        tfBetrag = new TextField();
        tfBetrag.textProperty().addListener((observable, oldValue, newValue) -> checkEingabe(newValue));
        return tfBetrag;
    }

    private Node getEinzahlungZeile() {
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> {
            lAnzeige.setText("");
            einzahlen();
        });

        HBox hBox = new HBox(bEinzahlen, getMeldungenZeile());
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setSpacing(15);
        return hBox;
    }

    private Node getAuszahlungZeile() {
        Button bAuszahlen = new Button("Auszahlen");
        bAuszahlen.setOnAction(e -> {
            lAnzeige.setText("");
            if (cbKategorien.getSelectionModel().isEmpty()) {
                lAnzeige.setText("Wählen Sie eine Kategorie");
            } else {
                auszahlen(cbKategorien.getValue());
            }
        });

        Label lKategorien = new Label("Kategorie: ");
        cbKategorien = new ComboBox<>();
        cbKategorien.getItems().addAll("Kleidung", "Lebensmittel", "Auto",
                "Fast-Food", "Sport", "Miete", "Sonstiges");

        HBox hBox = new HBox(bAuszahlen, lKategorien, cbKategorien);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);
        return hBox;
    }

    private Node getMeldungenZeile() {
        lAnzeige = new Label("");
        lAnzeige.setTextFill(Color.RED);
        return lAnzeige;
    }
}
