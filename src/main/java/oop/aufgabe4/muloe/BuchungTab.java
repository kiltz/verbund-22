package oop.aufgabe4.muloe;

import javafx.geometry.Insets;
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

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox();
        box.setSpacing(10);
        Insets insets = new Insets(10, 10, 20, 10);
        box.setPadding(insets);
        Button bDispoSetzen = new Button("Antrag aufs Dispoänderung");
        bDispoSetzen.setMaxWidth(175);
        bDispoSetzen.setOnAction(e -> dispoSetzen());
        Button bEinzahlenAntrag = new Button("Antrag aufs Einzahlen");
        bEinzahlenAntrag.setMaxWidth(175);
        bEinzahlenAntrag.setOnAction(e -> einzahlenAntrag());
        Button bAuszahlenAntrag = new Button("Antrag aufs Auszahlen");
        bAuszahlenAntrag.setOnAction(e -> auszahlenAntrag());
        bAuszahlenAntrag.setMaxWidth(175);
        box.getChildren().addAll(bEinzahlenAntrag, bAuszahlenAntrag, bDispoSetzen);
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }

    private void dispoSetzen() {
        TextField betrag = new TextField();
        Label lWarnung = new Label("");
        Button bSchließen = new Button("Schließen");
        Button bDispoSetzen = new Button("Dispo setzen");
        bDispoSetzen.setOnAction(e -> {
            try {
                konto.setDispo(Zahlen.stringToDouble((betrag.getText())));
                lWarnung.setText(String.format("Dispo: %.2f", konto.getDispo()));
            } catch (ParseException ex) {
                lWarnung.setText("Geben Sie bitte einen gültigen Betrag an.");
            }
        });
        VBox box = new VBox();
        box.setSpacing(10);
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(bDispoSetzen, bSchließen);
        box.getChildren().addAll(betrag, lWarnung, buttonBox);
        buttonBox.setSpacing(10);
        Stage stage = new Stage();
        stage.setTitle("Einzahlen");
        StackPane pane = new StackPane(box);
        stage.setScene(new Scene(pane));
        stage.show();
        bSchließen.setOnAction(e -> schließen(stage));
    }

    private void einzahlenAntrag() {
        TextField betrag = new TextField();
        Label lWarnung = new Label("");
        Button bSchließen = new Button("Schließen");
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> {
            try {
                konto.einzahlen(Zahlen.stringToDouble((betrag.getText())));
                lWarnung.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
            } catch (ParseException ex) {
                lWarnung.setText("Geben Sie bitte einen gültigen Betrag an.");
            }
        });
        VBox box = new VBox();
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(bEinzahlen, bSchließen);
        box.getChildren().addAll(betrag, lWarnung, buttonBox);
        Stage stage = new Stage();
        stage.setTitle("Einzahlen");
        StackPane pane = new StackPane(box);
        stage.setScene(new Scene(pane));
        stage.show();
        bSchließen.setOnAction(e -> schließen(stage));
    }

    private void auszahlenAntrag() {
        TextField betrag = new TextField();
        Label lWarnung = new Label("");
        Button bSchließen = new Button("Schließen");
        Button bEinzahlen = new Button("Auszahlen");
        bEinzahlen.setOnAction(e -> {
            try {
                konto.auszahlen(Zahlen.stringToDouble(betrag.getText()));
                lWarnung.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
            } catch (ParseException ex) {
                lWarnung.setText("Geben Sie bitte einen gültigen Betrag an.");
            } catch (KeineKontoDeckungException ex) {
                lWarnung.setText("Die Auszahlung überschreitet Ihr Kontolimit.");
            }
        });
        VBox box = new VBox();
        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(bEinzahlen, bSchließen);
        box.getChildren().addAll(betrag, lWarnung, buttonBox);
        Stage stage = new Stage();
        stage.setTitle("Auszahlen");
        StackPane pane = new StackPane(box);
        stage.setScene(new Scene(pane));
        stage.show();
        bSchließen.setOnAction(e -> schließen(stage));
    }

    private void schließen(Stage stage) {
        stage.close();
    }
}
