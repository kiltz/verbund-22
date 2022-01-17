package gui.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Predicate;

public class Aufgabe1 {
    private static TextField tfVorname;
    private static TextField tfNachname;
    private static TextField tfEmail;
    private static TextField tfAnfrage;
    private static Label lVorname;
    private static Label lNachname;
    private static Label lEmail;
    private static Label lAnfrage;
    private static Label lMeldung;
    private static Scene sAufgabe1;

    private static Scene newAufgabe1(Stage primaryStage) {
        //zurück
        Button bZurueck = new Button("ZURÜCK");
        bZurueck.setFont(new Font("Arial", 10));
        bZurueck.setOnAction(event -> Aufgaben.showStart(primaryStage));

        //erste Zeile
        Label lAnrede = new Label("Anrede: ");
        ComboBox<String> cbAnrede = new ComboBox<>();
        cbAnrede.getItems().add("Frau");
        cbAnrede.getItems().add("Herr");
        cbAnrede.getItems().add("Divers");

        HBox hbZ1 = new HBox(lAnrede, cbAnrede);
        hbZ1.setSpacing(10);
        hbZ1.setAlignment(Pos.CENTER_LEFT);

        //zweite Zeile
        lVorname = new Label("Vorname *");
        lNachname = new Label("Nachname *");

        tfVorname = new TextField();
        tfVorname.setPrefColumnCount(13);
        tfNachname = new TextField();
        tfNachname.setPrefColumnCount(13);

        VBox vbZ2_1 = new VBox(lVorname, tfVorname);
        VBox vbZ2_2 = new VBox(lNachname, tfNachname);

        HBox hbZ2 = new HBox(vbZ2_1, vbZ2_2);
        hbZ2.setSpacing(10);
        hbZ2.setAlignment(Pos.CENTER_LEFT);


        //dritte Zeile
        lEmail = new Label("Email *");
        tfEmail = new TextField();

        VBox vbZ3 = new VBox(lEmail, tfEmail);
        vbZ3.setAlignment(Pos.CENTER_LEFT);


        //vierte Zeile
        lAnfrage = new Label("Anfrage *");
        tfAnfrage = new TextField();
        tfAnfrage.setMinHeight(150);
        tfAnfrage.setAlignment(Pos.TOP_LEFT);

        VBox vbZ4 = new VBox(lAnfrage, tfAnfrage);
        vbZ4.setAlignment(Pos.CENTER_LEFT);
        vbZ4.setPrefWidth(100);

        //fünfte Zeile

        Button bAbschicken = new Button("Anfrage abschicken");
        bAbschicken.setOnAction(event -> checkAnfrage(primaryStage));

        //sechste Zeile
        lMeldung = new Label();

        VBox vbAufgabe1_1 = new VBox(bZurueck, hbZ1, hbZ2, vbZ3, vbZ4, bAbschicken, lMeldung);
        vbAufgabe1_1.setPadding(new Insets(10));
        vbAufgabe1_1.setAlignment(Pos.TOP_LEFT);
        vbAufgabe1_1.setSpacing(10);

        return new Scene(vbAufgabe1_1, 300, 430);
    }

    private static void checkAnfrage(Stage primaryStage) {
        Predicate<TextField> checkFeld = tf -> tf.getText().length() > 0;
        Predicate<TextField> checkEmail = email ->
                email.getText().matches("(\\S.*\\S)(@)(\\S.*\\S)(.\\S[a-z]{2,3})");

        if (checkFeld.test(tfVorname)) {
            lVorname.setTextFill(Color.BLACK);
        } else {
            lVorname.setTextFill(Color.RED);
        }

        if (checkFeld.test(tfNachname)) {
            lNachname.setTextFill(Color.BLACK);
        } else {
            lNachname.setTextFill(Color.RED);
        }

        if (checkEmail.test(tfEmail)) {
            lEmail.setTextFill(Color.BLACK);
        } else {
            lEmail.setTextFill(Color.RED);
        }

        if (checkFeld.test(tfAnfrage)) {
            lAnfrage.setTextFill(Color.BLACK);
        } else {
            lAnfrage.setTextFill(Color.RED);
        }

        if (checkFeld.test(tfVorname) && checkFeld.test(tfNachname) &&
                checkFeld.test(tfAnfrage) && checkEmail.test(tfEmail)) {
            showAufgabe1Antwort(primaryStage);
        } else if (checkFeld.test(tfVorname) && checkFeld.test(tfNachname) &&
                checkFeld.test(tfAnfrage) && !checkEmail.test(tfEmail)) {
            lMeldung.setText("Die E-Mail-Adresse hat ein ungültiges Format!");
            lMeldung.setTextFill(Color.RED);
        } else {
            lMeldung.setText("Pflichtfelder müssen ausgefüllt werden!");
            lMeldung.setTextFill(Color.RED);
        }
    }

    private static void showAufgabe1Antwort(Stage primaryStage) {
        //zurück
        Button bZurueck1 = new Button("ZURÜCK");
        bZurueck1.setFont(new Font("Arial", 10));
        bZurueck1.setOnAction(event -> Aufgaben.showStart(primaryStage));

        Label lAntwort = new Label("Anfrage erfolgreich abgeschickt!");
        VBox vbAufgabe1_2 = new VBox(bZurueck1, lAntwort);
        vbAufgabe1_2.setSpacing(10);
        vbAufgabe1_2.setAlignment(Pos.CENTER);

        Scene sAufgabe1_2 = new Scene(vbAufgabe1_2, 300, 430);

        primaryStage.setTitle("Erfolg");
        primaryStage.setScene(sAufgabe1_2);
        primaryStage.show();
    }

    public static void show(Stage primaryStage) {
        if (sAufgabe1 == null) {
            sAufgabe1 = newAufgabe1(primaryStage);
        }

        primaryStage.setTitle("Kontaktformular");
        primaryStage.setScene(sAufgabe1);
        primaryStage.show();

    }
}
