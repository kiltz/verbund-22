package gui.uebung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Aufgabe:
 * Zahleneingabe
 * Min, Max, Summe, Durchschnitt, anzahl Zahlen ausgeben
 */
public class StatisitkApp extends Application {

    TextField zahlEingabe;
    ArrayList<Integer> alleZahlen = new ArrayList<>();
    Label min;
    Label max;
    Label summe;
    Label durchschnitt;
    Label anz;

    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        zahlEingabe = new TextField();
        min = new Label();
        max = new Label();
        summe = new Label();
        durchschnitt = new Label();
        anz = new Label();
        Button hinzufuegenButton = new Button("Zahl hinzufügen");
        hinzufuegenButton.setOnAction(e -> zahlHinzufuegen(e));
        Button eingebenButton = new Button("Statistik ausgeben");
        eingebenButton.setOnAction(e -> statistikAusgeben(e));
        Button leerenButton = new Button("Statistik leeren");
        leerenButton.setOnAction(e -> statistikLeeren(e));
        VBox root = new VBox();
        HBox box1 = new HBox();
        box1.getChildren().addAll(zahlEingabe, hinzufuegenButton, eingebenButton, leerenButton);
        box1.setSpacing(10);
        VBox box2 = new VBox();
        box2.getChildren().addAll(min, max, summe, durchschnitt, anz);
        root.getChildren().addAll(box1, box2);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void statistikLeeren(ActionEvent e) {
        alleZahlen.clear();
        min.setText("");
        max.setText("");
        summe.setText("");
        durchschnitt.setText("");
        anz.setText("");
        zahlEingabe.requestFocus();
        zahlEingabe.setPromptText("Bitte eingeben");
    }

    private void zahlHinzufuegen(ActionEvent e) {
        try {
            alleZahlen.add(Integer.parseInt(zahlEingabe.getText()));
            zahlEingabe.requestFocus();
        } catch (NumberFormatException ex) {
            zahlEingabe.requestFocus();
            zahlEingabe.setPromptText("Bitte gültige Zahl eingeben");
        }
    }

    private void statistikAusgeben(ActionEvent e) {
        try {
            int maxZahl = alleZahlen.get(0);
            int minZahl = alleZahlen.get(0);
            int summeZahl = 0;
            int anzZahlen = 0;
            double durchschnittZahl = 0;
            for (int zahl : alleZahlen) {
                if (maxZahl < zahl) {
                    maxZahl = zahl;
                } else if (minZahl > zahl) {
                    minZahl = zahl;
                }
                summeZahl += zahl;
            }
            anzZahlen = alleZahlen.size();
            durchschnittZahl = summeZahl / anzZahlen;
            max.setText("Max: " + maxZahl);
            min.setText("Min: " + minZahl);
            summe.setText("Summe: " + summeZahl);
            anz.setText("Anzahl: " + anzZahlen);
            durchschnitt.setText("Durchschnitt: " + durchschnittZahl);
        } catch (IndexOutOfBoundsException ex) {
            zahlEingabe.requestFocus();
            zahlEingabe.setPromptText("Bitte eingeben");
        }
    }
}
