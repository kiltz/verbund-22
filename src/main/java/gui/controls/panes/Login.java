package gui.controls.panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Login extends Seiten {

    private final String path = "src/main/resources/logins.txt";
    private final Predicate<TextField> checkTF = tf -> tf.getText().length() > 0;
    private Label lName, lPasswort, lMeldung;
    private Scene sLogin;
    private Map<String, String> eintraege = new HashMap<>();
    private TextField tfName;
    private PasswordField tfPasswort;

    public Node getRoot() {
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

        VBox vbLogin = new VBox(lName, tfName, lPasswort, tfPasswort, hBox, lMeldung);
        vbLogin.setPadding(new Insets(10));
        vbLogin.setAlignment(Pos.TOP_LEFT);
        vbLogin.setSpacing(10);

        return vbLogin;
    }

    private void einloggen() {
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

    private void eintragen() {
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
}
