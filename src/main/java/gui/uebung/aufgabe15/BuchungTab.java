package gui.uebung.aufgabe15;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.text.NumberFormat;
import java.text.ParseException;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    private double einAusZahlung;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        HBox box = new HBox();
        Label anzeige = new Label("Dialog für Buchungen");
        TextField tfEinzahlen = new TextField() {

            @Override
            public void replaceText(int start, int end, String text) {
                if (text.isEmpty() || !text.matches("[a-ü\\.]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (text.matches("[0-9,]")) {
                    super.replaceSelection(text);
                }
            }
        };
        tfEinzahlen.setPromptText("Betrag eingeben");
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> {
            String strEinAusZahlung = tfEinzahlen.getText();
            // Nutzung von utils irgendwie nicht möglich?
            NumberFormat nf = NumberFormat.getInstance();
            try {
                einAusZahlung = nf.parse(strEinAusZahlung).doubleValue();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            konto.einzahlen(einAusZahlung);
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        });
        Button bAuszahlen = new Button("Auszahlen");
        bAuszahlen.setOnAction(e -> {
            String strEinAusZahlung = tfEinzahlen.getText();
            // Nutzung von utils irgendwie nicht möglich?
            NumberFormat nf = NumberFormat.getInstance();
            try {
                einAusZahlung = nf.parse(strEinAusZahlung).doubleValue();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            try {
                konto.auszahlen(einAusZahlung);
            } catch (KeineKontoDeckungException ex) {
                ex.printStackTrace();
            }
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        });
        box.getChildren().addAll(tfEinzahlen, bEinzahlen, bAuszahlen, anzeige);
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }
}
