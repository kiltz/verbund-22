package gui.uebung;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

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

        Scene scene = new Scene();
        primaryStage.setTitle("Rechner");
        primaryStage.setScene(scene);
        primaryStage.show();

        private Node getTextFelder () {
            HBox box = new HBox();
            box.setSpacing(15);
            TextField tf = new TextField();
            tf.setPromptText("Ganzzahlige Werte eingeben!");
            tf.setOnAction(e ->
                    System.out.println("Eingabe: " + tf.getText())
            );
        }
        ;

        private Node getButtons () {
            HBox box = new HBox();
            box.setSpacing(15);
            Button bRechne = new Button(" = ");
            bRechne.setDefaultButton(true);
            bRechne.setOnAction(e -> rechne(e));
        }

        private void rechne (ActionEvent e){
            String tf.getText();

        }
    }
    }
