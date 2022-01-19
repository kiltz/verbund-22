package gui.uebung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zahleneingabe
 * Min, Max, Summe, Durchschnitt, anzahl Zahlen ausgeben
 */
public class StatisitkApp extends Application {

    private Label lSumme;
    private Label lMin;
    private Label lMax;
    private Label lDurchschnitt;
    private TextField tfEingabe;
    private Label lAnzahl;
    private Button button;


    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setSpacing(15);

        //root.getChildren().add(getTextFelder());
        root.getChildren().add(getButtons());
        root.getChildren().add(getLabels());

        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(root);

        Scene scene = new Scene(scrolli, 700, 200);
        root.setSpacing(10);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mo's Statistik");
        primaryStage.show();
    }

    private Node getButtons() {
        HBox box = new HBox();
        button = new Button("Ergebnis");
        tfEingabe = new TextField();
        //tfEingabe.


        button.setOnAction(e -> rechne(e));

        box.getChildren().add(tfEingabe);
        box.getChildren().add(button);
        button.setDefaultButton(true);

        return box;
    }

    private void rechne(ActionEvent e) {
        // 1. Textfeld auslesen
        String eingabe = tfEingabe.getText();
        if (eingabe.isEmpty()) {
            tfEingabe.setPromptText("Bitte Zahlen Eingeben!");
        } else {
            berechneEingabe(eingabe);
            button.setText("Done");
        }

    }

    private void berechneEingabe(String eingabe) {
        // 2. Zahlen ermittlen (splitten und Umwandeln)
        String[] teile = eingabe.split(" ");
        int[] zahlen = new int[teile.length];
        for (int i = 0; i < teile.length; ++i) {
            zahlen[i] = Integer.parseInt(teile[i]);
        }
        // 3. Werte berechnen
        int max = 0;
        int min = zahlen[0];
        int summe = 0;
        for (int zahl : zahlen) {
            summe += zahl;
            if (zahl > max) {
                max = zahl;
            }
            if (zahl < min) {
                min = zahl;
            }
        }
        // 4. Werte ausgeben
        lSumme.setText("Summe: " + summe);
        lMax.setText("Maximum: " + max);
        lMin.setText("Minimum: " + min);
        lDurchschnitt.setText("Durchschnitt: " + (summe * 1.0 / zahlen.length));
        lAnzahl.setText("Anzahl: " + zahlen.length);

    }


    private Node getLabels() {
        VBox box = new VBox();
        lSumme = new Label("Summe: ", lSumme);
        lMax = new Label("Maximum: ", lMax);
        lMin = new Label("Minimum: ", lMin);
        lDurchschnitt = new Label("Durchschnitt: ", lDurchschnitt);
        lAnzahl = new Label("Anzahl: ", lAnzahl);

        // Integer.parseInt();

        box.getChildren().addAll(lSumme, lMin, lMax, lDurchschnitt, lAnzahl);
        return box;
    }  // end main

}
