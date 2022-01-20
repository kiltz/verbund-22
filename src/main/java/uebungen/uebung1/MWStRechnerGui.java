package uebungen.uebung1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class MWStRechnerGui extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) {
        HBox root = new HBox();

        root.getChildren().add(getLabels);
        root.getChildren().add(getTextFeld());
        root.getChildren().add(getButton());

        Scene scene = new Scene(root, 300, 400);

        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getTextFeld() {
        HBox box = new HBox();
        box.setSpacing(15);
        TextField tf = new TextField();
        tf.setPromptText("Eingabe Betrag");
        tf.setOnAction(e -> System.out.println("Eingabe: ") + tf.getText());
        box.getChildren().addAll(box, tf);
        return box;
    }

    private Node getLabels() {
        HBox box = new HBox();
        box.setSpacing(15);
        Label label1 = new Label("19 %");
        Label label2 = new Label();
        box.getChildren().addAll(box, label1, label2);
        return box;
    }

    private Node getButton() {
        HBox box = new HBox();
        box.setSpacing(15);
        Button b1 = new Button("=");
        b1.setDefaultButton(true);
        b1.setOnAction(e -> rechne(e));
        box.getChildren().addAll(box, b1);
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
}
