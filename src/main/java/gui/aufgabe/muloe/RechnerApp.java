package gui.aufgabe.muloe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

/*
Aufgabe:
1. Kopiert die BasicApp nach RechnerApp
2. Erstellt zwei TextFelder, zwei Label und einen Button
    (TextField, Button)
    [.5.] + [.2.] (=) 7

Keine Funktionalität!
 */

public class RechnerApp extends Application {


    private TextField tfEins;
    private TextField tfZwei;
    private Label lErgebnis;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        Scene scene = new Scene(root, 250, 150);
        primaryStage.setTitle("Rechner");
        primaryStage.setScene(scene);
        primaryStage.show();
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

}
