package gui.uebung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zeigt zwei Eingabefelder für Benutzername und Passwort
 * Beschribt die Eingabefelder mit einem Label
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

    Label lBN;
    Label lPW;
    TextField benutzername;
    PasswordField passwort;
    Button login;

    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        lBN = new Label("Benutzername:");
        lPW = new Label("Passwort:");
        benutzername = new TextField();
        passwort = new PasswordField();
        login = new Button("Login");
        login.setOnAction(e -> setLogin(e, primaryStage));

        VBox root = new VBox();
        HBox inputBox = new HBox();
        VBox labels = new VBox();
        VBox textFields = new VBox();

        benutzername.setMaxWidth(250);
        passwort.setMaxWidth(250);
        labels.getChildren().addAll(lBN, lPW);
        labels.setSpacing(6);
        textFields.getChildren().addAll(benutzername, passwort);
        inputBox.getChildren().addAll(labels, textFields);
        inputBox.setSpacing(10);
        Insets insets = new Insets(10, 10, 0, 10);
        root.setPadding(insets);
        root.getChildren().add(inputBox);
        root.getChildren().add(login);
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setLogin(ActionEvent e, Stage primaryStage) {
        if (benutzername.getText().equals("benutzername") && passwort.getText().equals("passwort")) {
            System.out.println("yes");
            primaryStage.close();
            Kontaktliste kontakt = new Kontaktliste();
        } else if (benutzername.getText().isEmpty()) {
            benutzername.requestFocus();
            benutzername.setPromptText("Bitte Benutzernamen eingeben...");
        } else if (passwort.getText().isEmpty()) {
            passwort.requestFocus();
            passwort.setPromptText("Bitte Passwort eingeben...");
        } else {
            passwort.requestFocus();
            passwort.setPromptText("Falsches Passwort...");
        }
    }

}
