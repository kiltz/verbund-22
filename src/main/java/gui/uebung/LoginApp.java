package gui.uebung;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zeigt zwei Eingabefelder für Benutzername und Passwort
 * Beschreibt die Eingabefelder mit einem Label
 *
 * Erzeugt einen Button (Login)
 *
 * Macht den Dialog hübsch
 *
 * Validiert den Dialog
 * 1. Benutzername darf nicht leer sein
 * 2. Passwort darf nicht leer sein
 * 3. Benutzernamen und Passwort müssen irgendwelchen festen Werten entsprechen
 *
 * Hinweis: Schachtelt VBox und HBox
 *
 */
public class LoginApp extends Application {

    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField tf_eingabe1 = new TextField("Benutzername");
        TextField tf_eingabe2 = new TextField("Passwort");
        Integer i_laenge1 = 0;
        Integer i_laenge2 = 0;
        Label l_beschreibung1 = new Label("Bitte geben Sie Ihren Benutzernamen ein:");
        Label l_beschreibung2 = new Label("Bitte geben Sie Ihr Passwort ein:");
        Button b_login = new Button("Login");
        VBox eingabe = new VBox();
        eingabe.setSpacing(15);
        primaryStage.setTitle("Login");
        eingabe.getChildren().addAll(l_beschreibung1, tf_eingabe1, l_beschreibung2, tf_eingabe2, b_login);
        if (b_login.isPressed() == true) {
            i_laenge1 = tf_eingabe1.getLength();
            i_laenge2 = tf_eingabe2.getLength();
            if (i_laenge1 == 0) {
                Label l_fehlerbenutzer1 = new Label("Ihr Benutzername darf nicht leer sein.\nBitte geben Sie Ihren Benutzernamen ein.");
                eingabe.getChildren().add(l_fehlerbenutzer1);
            }
            if (i_laenge1 < 8) {
                Label l_fehlerbenutzer2 = new Label("Ihr Benutzername muss mindestens 8 Zeichen lang sein.");
                eingabe.getChildren().add(l_fehlerbenutzer2);
            }
            if (i_laenge2 == 0) {
                Label l_fehlerpass2 = new Label("Ihr Passwort darf nicht leer sein.\nBitte geben Sie Ihr Passwort ein.");
                eingabe.getChildren().add(l_fehlerpass2);
            }
            if (i_laenge2 < 8) {
                Label l_fehlerpass2 = new Label("Ihr Passwort muss mindestens 8 Zeichen lang sein.");
                eingabe.getChildren().add(l_fehlerpass2);
            } else {
                b_login.setDefaultButton(true);
                b_login.setOnAction(exit -> Platform.exit());
            }
        }

        Scene scene = new Scene(eingabe, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
