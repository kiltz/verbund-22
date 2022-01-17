package gui.controls;

import javafx.application.Application;
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

public class Kontaktformular extends Application {
    TextField tfVorname, tfNachname, tfEmail, tfAnfrage;
    Label lVorname, lNachname, lEmail, lAnfrage, lMeldung;
    VBox vbStart, aufgabe1_1, aufgabe1_2;
    Scene sStart, sAufgabe1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        newStart(primaryStage);

        sStart = new Scene(vbStart, 200, 250);
        ;
        primaryStage.setTitle("Aufgaben");
        primaryStage.setScene(sStart);
        primaryStage.show();
    }

    private void newStart(Stage primaryStage) {
        Font myFont = new Font("Arial", 25);

        Button bAufgabe1 = new Button("Aufgabe 1");
        bAufgabe1.setFont(myFont);
        bAufgabe1.setOnAction(event -> {
            newAufgabe1(primaryStage);

            sAufgabe1 = new Scene(aufgabe1_1, 300, 430);
            primaryStage.setTitle("Kontaktformular");
            primaryStage.setScene(sAufgabe1);
            primaryStage.show();
        });


        Button bAufgabe2 = new Button("Aufgabe 2");
        bAufgabe2.setFont(myFont);


        Button bAufgabe3 = new Button("Aufgabe 3");
        bAufgabe3.setFont(myFont);

        vbStart = new VBox(bAufgabe1, bAufgabe2, bAufgabe3);
        vbStart.setPadding(new Insets(10, 10, 10, 10));
        vbStart.setAlignment(Pos.CENTER);
        vbStart.setSpacing(10);

    }

    private void newAufgabe1(Stage primaryStage) {
        //zurück
        Button bZurueck = new Button("ZURÜCK");
        bZurueck.setFont(new Font("Arial", 10));
        bZurueck.setOnAction(event -> {
            primaryStage.setTitle("Aufgaben");
            primaryStage.setScene(sStart);
            primaryStage.show();
        });

        //erste Zeile
        Label lAnrede = new Label("Anrede: ");
        ComboBox<String> cbAnrede = new ComboBox<>();
        cbAnrede.getItems().add("Frau");
        cbAnrede.getItems().add("Herr");

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

        //sechste3 Zeile
        lMeldung = new Label();

        aufgabe1_1 = new VBox(bZurueck, hbZ1, hbZ2, vbZ3, vbZ4, bAbschicken, lMeldung);
        aufgabe1_1.setPadding(new Insets(10, 10, 10, 10));
        aufgabe1_1.setAlignment(Pos.TOP_LEFT);
        aufgabe1_1.setSpacing(10);


        //zurück
        Button bZurueck1 = new Button("ZURÜCK");
        bZurueck1.setFont(new Font("Arial", 10));
        bZurueck1.setOnAction(event -> {
            primaryStage.setTitle("Aufgaben");
            primaryStage.setScene(sStart);
            primaryStage.show();
        });

        Label lAntwort = new Label("Anfrage erfolgreich abgeschickt!");
        aufgabe1_2 = new VBox(bZurueck1, lAntwort);
        aufgabe1_2.setSpacing(10);
        aufgabe1_2.setAlignment(Pos.CENTER);
    }

    private void checkAnfrage(Stage primaryStage) {
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
            Scene scene1 = new Scene(aufgabe1_2, 300, 390);

            primaryStage.setTitle("Erfolg");
            primaryStage.setScene(scene1);
            primaryStage.show();
        } else if (checkFeld.test(tfVorname) && checkFeld.test(tfNachname) &&
                checkFeld.test(tfAnfrage) && !checkEmail.test(tfEmail)) {
            lMeldung.setText("Die E-Mail-Adresse hat ein ungültiges Format!");
            lMeldung.setTextFill(Color.RED);
        } else {
            lMeldung.setText("Pflichtfelder müssen ausgefüllt werden!");
            lMeldung.setTextFill(Color.RED);
        }
    }
}
