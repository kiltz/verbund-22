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
import utils.Zahlen;

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
        lErgebnis = new Label("0");
        VBox root = new VBox();
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setSpacing(15);
        root.getChildren().add(getTextFelder());
        root.getChildren().add(getButtons());
        root.getChildren();
        Scene scene = new Scene(root, 300, 200);
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
        // TODO: eingabe in Zahl umwandeln Integer.parseInt(...)
        int zahlInt = Integer.parseInt(eingabe);
        // TODO: Zahl mal 2 nehmen
        System.out.println(zahlInt * 2);
        // TODO: Ergebnis im Label lErgebnis ausgeben (int in String umwandeln ""+zahl)
        System.out.println("Before conversion: " + zahlInt);
        System.out.println("After conversion: " + ("" + zahlInt));
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
