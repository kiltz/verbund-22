package gui.aufgabe.muloe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        root.getChildren().add(getButtons());
        root.getChildren().add(getLabels());
        root.getChildren().add(getFuttons());

        Scene scene = new Scene(root, 950, 350);
        primaryStage.setTitle("Rechner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node getButtons() {
        HBox box = new HBox(40);
        box.setSpacing(15);
        Hyperlink link = new Hyperlink("Klick mich nicht!");
        link.setOnAction(e -> Platform.exit());
        box.getChildren().addAll(link);
        return box;
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

    private Node getLabels() {
        HBox box = new HBox();
        box.setSpacing(15);
        Label einLabel = new Label("Wer klickt ist Doof!");
        einLabel.setFont(Font.font("Verdana", 18));
        einLabel.setTextFill(Color.web("#005091"));
        einLabel.setOnMouseClicked(e -> einLabel.setText("Knew it!"));

        box.getChildren().addAll(einLabel);

        return box;

    }

    private Node getFuttons() {
        HBox box = new HBox();
        box.setSpacing(15);
        Button b1 = new Button("TuNix!");
        Button b2 = new Button("Kauf was!");
        b2.setOnAction(e -> b2.setText("Eine Rechnung von 1.200€ wurde hinterlegt!"));
        Button b3 = new Button("Default");
        b3.setDefaultButton(true);
        Button b4 = new Button("Abbruch");
        b4.setOnAction(g -> b2.setText("Kauf was!"));

        b4.setCancelButton(true);

        box.getChildren().addAll(b1, b2, b3, b4);
        return box;
    }

}
