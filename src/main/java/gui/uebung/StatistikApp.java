package gui.uebung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zahleneingabe
 * Min, Max, Summe, Durchschnitt, anzahl Zahlen ausgeben
 * <p>
 * Beträge [2 4 6 3 ] (berechne)
 * <p>
 * Summe: 15
 * Min: 2
 * Max: 6
 * Durchschnitt: 3,...
 * Anzahl Zahlen: 4
 */
public class StatistikApp extends Application {

    private TextField tfEingabe;
    private Label lSumme;
    private Label lMin;
    private Label lMax;
    private Label lDurchschnitt;
    private Label lAnzahl;

    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.getChildren().add(getEingabeZeile());
        root.getChildren().add(getErgebnisZeile());
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("Statistik");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node getErgebnisZeile() {
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        /*
         *  Summe: 15
         *  Min: 2
         *  Max: 6
         *  Durchschnitt: 3,...
         *  Anzahl Zahlen: 4
         */
        lSumme = new Label();
        lMin = new Label();
        lMax = new Label();
        lDurchschnitt = new Label();
        lAnzahl = new Label();

        erzeugeHbox(box, "Summe: ", lSumme);
        erzeugeHbox(box, "Min: ", lMin);
        erzeugeHbox(box, "Max: ", lMax);
        erzeugeHbox(box, "Durchschnitt: ", lDurchschnitt);
        erzeugeHbox(box, "Anzahl: ", lAnzahl);
        return box;
    }

    private void erzeugeHbox(VBox box, String text, Label label) {
        label.setText("0");
        label.setTextFill(Color.web("#005091"));
        HBox hBox = new HBox();
        box.setPadding(new Insets(10));
        hBox.getChildren().addAll(new Label(text), label);
        box.getChildren().add(hBox);
    }

    private Node getEingabeZeile() {
        HBox box = new HBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        box.getChildren().add(new Label("Eingabe"));
        tfEingabe = new TextField();
        box.getChildren().add(tfEingabe);
        Button bRechne = new Button("berechne");
        bRechne.setOnAction(e -> rechne(e));
        bRechne.setDefaultButton(true);
        box.getChildren().add(bRechne);
        return box;
    }

    private void rechne(ActionEvent e) {
        // 1. Textfeld auslesen
        String eingabe = tfEingabe.getText();
        if (eingabe.isEmpty()) {
            tfEingabe.setPromptText("Bitte Zahlen Eingeben!");
        } else {
            berechneEingabe(eingabe);
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
        lSumme.setText("" + summe);
        lMax.setText("" + max);
        lMin.setText("" + min);
        lDurchschnitt.setText("" + (summe * 1.0 / zahlen.length));
        lAnzahl.setText("" + zahlen.length);
    }
}
