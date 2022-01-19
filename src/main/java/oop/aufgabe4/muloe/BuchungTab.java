package oop.aufgabe4.muloe;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    Label lWarnung;
    TextField betrag;
    private Label lDispo;
    private Label lKontostand;
    private Label lKontostandAntrag;
    private Label lDispoAntrag;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        Tab tab = new Tab("Buchungen", erstelleFenster());
        return tab;
    }

    private Node erstelleFenster() {
        lDispo = new Label(String.format("Dispo: %.2f Euro", konto.getDispo()));
        lKontostand = new Label(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
        lKontostandAntrag = new Label(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
        lDispoAntrag = new Label(String.format("Dispo: %.2f Euro", konto.getDispo()));
        lWarnung = new Label();
        betrag = new TextField();
        Button bDispoSetzen = buttonHinzufuegen("Antrag auf Dispoänderung", 175);
        bDispoSetzen.setOnAction(e -> dispoSetzenAntrag());
        Button bEinzahlenAntrag = buttonHinzufuegen("Antrag auf Einzahlung", 175);
        bEinzahlenAntrag.setOnAction(e -> einzahlenAntrag());
        Button bAuszahlenAntrag = buttonHinzufuegen("Antrag auf Auszahlung", 175);
        bAuszahlenAntrag.setOnAction(e -> auszahlenAntrag());
        VBox buttonBox = new VBox();
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(bDispoSetzen, bEinzahlenAntrag, bAuszahlenAntrag);
        VBox labelBox = new VBox();
        labelBox.setSpacing(10);
        labelBox.getChildren().addAll(lDispo, lKontostand);
        HBox box = new HBox();
        box.setSpacing(20);
        Insets insets = new Insets(10, 10, 20, 10);
        box.setPadding(insets);
        box.getChildren().addAll(labelBox, buttonBox);
        return box;
    }

    private Button buttonHinzufuegen(String text, double width) {
        Button button = new Button(text);
        button.setMaxWidth(width);
        return button;
    }

    private void dispoSetzenAntrag() {
        lWarnung.setText("");
        Button bDispoSetzen = buttonHinzufuegen("Dispo setzen", 3150);
        bDispoSetzen.setOnAction(e -> {
            try {
                konto.setDispo(Zahlen.stringToDouble((betrag.getText())), true);
                lDispoAntrag.setText(String.format("Dispo: %.2f Euro", konto.getDispo()));
                lDispo.setText(lDispoAntrag.getText());
                lWarnung.setText("");
            } catch (ParseException ex) {
                lWarnung.setText("Geben Sie bitte einen gültigen Betrag an.");
            } finally {
                betrag.requestFocus();
            }
        });
        erstelleAntragFenster(bDispoSetzen, "Dispo setzen", betrag, new Label[]{lDispoAntrag, lWarnung});
    }

    private void einzahlenAntrag() {
        lWarnung.setText("");
        Button bEinzahlen = buttonHinzufuegen("Einzahlen", 150);
        bEinzahlen.setOnAction(e -> {
            try {
                konto.einzahlen(Zahlen.stringToDouble((betrag.getText())), true);
                lKontostandAntrag.setText(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
                lKontostand.setText(lKontostandAntrag.getText());
                lWarnung.setText("");
            } catch (ParseException ex) {
                lWarnung.setText("Geben Sie bitte einen gültigen Betrag an.");
            } finally {
                betrag.requestFocus();
            }
        });
        erstelleAntragFenster(bEinzahlen, "Einzahlen", betrag, new Label[]{lKontostandAntrag, lWarnung});
    }

    private void auszahlenAntrag() {
        lWarnung.setText("");
        Button bAuszahlen = buttonHinzufuegen("Auszahlen", 150);
        bAuszahlen.setOnAction(e -> {
            try {
                konto.auszahlen(Zahlen.stringToDouble(betrag.getText()), true);
                lKontostandAntrag.setText(String.format("Kontostand: %.2f Euro", konto.getKontoStand()));
                lKontostand.setText(lKontostandAntrag.getText());
                lWarnung.setText("");
            } catch (ParseException ex) {
                lWarnung.setText("Geben Sie bitte einen gültigen Betrag an.");
            } catch (KeineKontoDeckungException ex) {
                lWarnung.setText("Die Auszahlung überschreitet Ihr Kontolimit.");
            } finally {
                betrag.requestFocus();
            }
        });
        erstelleAntragFenster(bAuszahlen, "Auszahlen", betrag, new Label[]{lKontostandAntrag, lDispoAntrag, lWarnung});

    }

    private void erstelleAntragFenster(Button zusätzlicherButton, String titel, TextField betrag, Label[] labels) {

        Button bSchließen = buttonHinzufuegen("Schließen", 500);
        VBox box = new VBox();
        box.setSpacing(10);
        Insets insets = new Insets(10, 10, 20, 10);
        box.setPadding(insets);
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);
        buttonBox.getChildren().addAll(zusätzlicherButton, bSchließen);
        box.getChildren().add(betrag);
        for (Label label : labels) {
            box.getChildren().add(label);
        }
        box.getChildren().add(buttonBox);
        Stage stage = new Stage();
        stage.setTitle(titel);
        StackPane pane = new StackPane(box);
        stage.setScene(new Scene(pane, 250, 150));
        stage.show();
        bSchließen.setOnAction(e -> schließen(stage));
    }

    private void schließen(Stage stage) {
        stage.close();
    }
}
