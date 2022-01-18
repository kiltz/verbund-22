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
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zahleneingabe
 * Min, Max, Summe, Durchschnitt, Anzahl Zahlen ausgeben
 * <p>
 * Label, Textfeld, Button VBox in HBox
 * Berechnung in Label
 */

public class StatisitkApp extends Application {

    private TextField tf;
    private Label lErgebnis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setSpacing(15);
        // TODO: Buttons und Textfelder dem root hinzufügen

        // TODO: lErgebnis erzeugen und root hinzufügen

        // TODO Breite und Höhe setzen
        Scene scene = new Scene(root);
        primaryStage.setTitle("Rechner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node getButtons() {
        HBox box = new HBox();
        box.setSpacing(15);
        Button bRechne = new Button(" = ");
        bRechne.setDefaultButton(true);
        bRechne.setOnAction(e -> rechne(e));
        return box;
    }

    private void rechne(ActionEvent e) {
        String eingabe = tf.getText();
        System.out.println(eingabe);
        // TODO: eingabe in Zahl umwandeln Integer.parseInt(...)

        // TODO: Zahl mal 2 nehmen

        // TODO: Ergebnis im Label lErgebnis ausgeben (int in String umwandeln ""+zahl)

    }

    private Node getTextFelder() {
        HBox box = new HBox();
        box.setSpacing(15);
        tf = new TextField();
        tf.setPromptText("Ganzzahlige Werte eingeben!");
        tf.setOnAction(e ->
                System.out.println("Eingabe: " + tf.getText())
        );
        return box;
    }
}
