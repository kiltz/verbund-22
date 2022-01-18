package gui.controls.panes.mueloe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class TabAufgabeApp extends Application {
    private TextField tfEins;
    private TextField tfZwei;
    private Label lErgebnis;
    private TextField tfEingabe;
    private Label lSumme;
    private Label lMin;
    private Label lMax;
    private Label lDurchschnitt;
    private Label lAnzahl;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane root = new TabPane();
        // ein Tab
        Tab tab = new Tab("Rechner", getRechnerNodes());
        tab.setClosable(true);
        root.getTabs().add(tab);
        // noch ein Tab
        Tab tab1 = new Tab("Statistik App", getStatistikNodes());
        tab.setClosable(true);
        root.getTabs().add(tab);
        //...

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Einige Tabbies!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getRechnerNodes() {
        lErgebnis = new Label("7");
        Label lPlus = new Label(" + ");
        tfEins = new TextField("5");
        tfEins.setMaxWidth(50);
        tfZwei = new TextField("2");
        tfZwei.setMaxWidth(50);
        Button bRechne = new Button(" = ");
        bRechne.setDefaultButton(true);
        bRechne.setOnAction(e -> rechne(e));

        HBox root = new HBox();
        root.setSpacing(10);
        Insets insets = new Insets(20, 10, 20, 10);
        root.setPadding(insets);
        root.getChildren().addAll(tfEins, lPlus, tfZwei, bRechne, lErgebnis);

        return root;
    }

    private Node getStatistikNodes() {
        lSumme = new Label();
        lMin = new Label();
        lMax = new Label();
        lDurchschnitt = new Label();
        lAnzahl = new Label();

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.getChildren().add(getEingabeZeile());
        root.getChildren().add(getErgebnisZeile());
        root.getChildren().addAll(lSumme, lMin, lMax, lDurchschnitt, lAnzahl);

        return root;
    }

    private void rechne(ActionEvent e) {
        // 1. Textfelder auslesen
        String textEins = tfEins.getText();
        String textZwei = tfZwei.getText();
        try {
            // 2. String in Double umwandeln
            double zahlEins = Zahlen.stringToDouble(textEins);
            double zahlZwei = Zahlen.stringToDouble(textZwei);
            // 3. Rechnen
            double ergebnis = zahlEins + zahlZwei;
            // 4. Ergebnis ausgeben
            lErgebnis.setText(Zahlen.doubleToString(ergebnis));
            // 5. Inhalt der Textfelder löschen (opt.)

            // 6. Fokus in das erste Textfeld setzen
            tfEins.requestFocus();

        } catch (ParseException ex) {
            // Mecker!
            System.out.println(ex.getMessage());
        }

    }

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
