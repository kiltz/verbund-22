package gui.uebung.aufgabe15;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.text.NumberFormat;
import java.text.ParseException;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    private double einzahlen;
    private double auszahlen;
    private TextField tfEingabe;
    private Label anzeige;


    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox();
        box.setPadding(new Insets(20));
        box.setSpacing(20);
        box.setMaxSize(300, 200);
        anzeige = new Label("Dialog für Buchungen");
        tfEingabe = new TextField() {

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
        tfEingabe.setFocusTraversable(false);
        tfEingabe.setPromptText("Betrag eingeben");
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> einzahlen(e));
        Button bAuszahlen = new Button("Auszahlen");
        bAuszahlen.setOnAction(e -> auszahlen(e));
        box.getChildren().addAll(tfEingabe, bEinzahlen, bAuszahlen, anzeige);
        return new Tab("Buchungen", box);
    }

    private void auszahlen(ActionEvent e) {
        String strEinAusZahlung = tfEingabe.getText();
        // Nutzung von utils irgendwie nicht möglich?
        NumberFormat nf = NumberFormat.getInstance();
        try {
            auszahlen = nf.parse(strEinAusZahlung).doubleValue();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        konto.getBuchungen().add(auszahlen);
        try {
            konto.auszahlen(auszahlen);
        } catch (KeineKontoDeckungException ex) {
            ex.printStackTrace();
        }
        anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));

    }

    private void einzahlen(ActionEvent e) {
        String strEinAusZahlung = tfEingabe.getText();
        // Nutzung von utils irgendwie nicht möglich?
        NumberFormat nf = NumberFormat.getInstance();
        try {
            einzahlen = nf.parse(strEinAusZahlung).doubleValue();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        konto.getBuchungen().add(einzahlen);
        konto.einzahlen(einzahlen);
        anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
    }
}
