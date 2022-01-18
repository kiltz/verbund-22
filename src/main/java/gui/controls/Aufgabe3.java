package gui.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Aufgabe3 {

    private static Label lName, lPasswort, lMeldung;
    private static final String path = "src/main/resources/logins.txt";
    private static final Predicate<TextField> checkTF = tf -> tf.getText().length() > 0;
    private static Scene sAufgabe3;
    private static Map<String, String> eintraege = new HashMap<>();
    private static TextField tfName;
    private static PasswordField tfPasswort;

    private static Scene newAufgabe3(Stage primaryStage) {
        //zurück
        Button bZurueck = new Button("ZURÜCK");
        bZurueck.setFont(new Font("Arial", 10));
        bZurueck.setOnAction(event -> Aufgaben.showStart(primaryStage));

        lName = new Label("Name:");
        tfName = new TextField();
        tfName.setAlignment(Pos.TOP_LEFT);

        lPasswort = new Label("Passwort:");
        tfPasswort = new PasswordField();
        tfPasswort.setAlignment(Pos.TOP_LEFT);

        Button bRegistrieren = new Button("Registrieren");
        Button bEinlogen = new Button("Einloggen");
        bEinlogen.setOnAction(event -> einloggen());
        bRegistrieren.setOnAction(event -> eintragen());

        HBox hBox = new HBox(bRegistrieren, bEinlogen);
        hBox.setSpacing(10);

        lMeldung = new Label();

        VBox vbAufgabe3 = new VBox(bZurueck, lName, tfName, lPasswort, tfPasswort, hBox, lMeldung);
        vbAufgabe3.setPadding(new Insets(10));
        vbAufgabe3.setAlignment(Pos.TOP_LEFT);
        vbAufgabe3.setSpacing(10);

        return new Scene(vbAufgabe3, 300, 230);
    }

    private static void einloggen() {
        if (checkTF.test(tfName) || checkTF.test(tfPasswort)) {
            List<String> logins = null;
            try {
                logins = Files.readAllLines(Paths.get(path));
            } catch (IOException ignore) {
            }

            String[] temp;
            for (String s : logins) {
                temp = s.split(";");
                eintraege.putIfAbsent(temp[0], temp[1]);
            }

            if (eintraege.containsKey(tfName.getText()) && eintraege.get(tfName.getText()).equals(tfPasswort.getText())) {
                lMeldung.setText("Erfolgreich eingeloggt");
                lMeldung.setTextFill(Color.BLUE);
            } else {
                lMeldung.setText("Falsche Eingabe");
                lMeldung.setTextFill(Color.RED);
            }
        } else {
            lMeldung.setText("Nicht alle Felder ausgefüllt!");
            lMeldung.setTextFill(Color.RED);
        }
    }

    private static void eintragen() {
        if (tfName.getText().length() < 1 || tfPasswort.getText().length() < 1) {
            lMeldung.setText("Nicht alle Felder ausgefüllt!");
            lMeldung.setTextFill(Color.RED);
        } else {
            List<String> logins = null;
            try {
                logins = Files.readAllLines(Paths.get(path));
            } catch (IOException ignore) {
            }

            String[] temp;
            for (String s : logins) {
                temp = s.split(";");
                eintraege.putIfAbsent(temp[0], temp[1]);
            }

            if (eintraege.containsKey(tfName.getText())) {
                lMeldung.setText("Name schon existiert");
                lMeldung.setTextFill(Color.RED);
            } else {
                try (FileWriter fw = new FileWriter(new File(path), true)) {
                    fw.write("\n" + tfName.getText() + ";" + tfPasswort.getText());
                    lMeldung.setText("Erfolgreich registriert!");
                    lMeldung.setTextFill(Color.BLUE);
                    tfPasswort.setText("");
                    tfName.setText("");
                } catch (IOException ignore) {
                }
            }
        }
    }

    public static void show(Stage primaryStage) {
        if (sAufgabe3 == null) {
            sAufgabe3 = newAufgabe3(primaryStage);
        }

        primaryStage.setTitle("Login");
        primaryStage.setScene(sAufgabe3);
        primaryStage.show();
    }
}
