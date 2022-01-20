package uebungen.uebung1;
/*
Aufgabe 1: 2 Punkte
Aufgabe 2: 2 Punkte
Aufgabe 3: 2 Punkte
Aufgabe 4: 3 Punkte
Aufgabe 5: 7 Punkte
Aufgabe 6: 3 Punkte
Aufgabe 7: 5 Punkte

Resultat: 24 Punkte => Du Viech! :-o
*/


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class MWStRechnerGui extends Application {

    TextField eingabeBetrag;
    Label lErgebnis;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        eingabeBetrag = new TextField();
        lErgebnis = new Label();
        Label lProzent = new Label("19 %");
        Button bErgebnis = new Button("=");
        bErgebnis.setDefaultButton(true);
        bErgebnis.setOnAction(e -> rechne());
        HBox root = new HBox();
        root.getChildren().addAll(eingabeBetrag, lProzent, bErgebnis, lErgebnis);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.show();
    }

    private void rechne() {
        try {
            double ergebnis = Zahlen.stringToDouble(eingabeBetrag.getText()) * 0.19;
            lErgebnis.setText(String.format("%.2f", ergebnis));
        } catch (ParseException e) {
            lErgebnis.setText("Das ist kein gültiger Betrag");
        }
    }
}
