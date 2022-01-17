package gui.uebung;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public static void main(String[] args) {
        launch(null);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(15);
        primaryStage.setTitle("Login");
        root.getChildren().addAll(getUsernameAndPassword(), loginButton());
        getUsernameAndPassword().setDisable(true);
        Scene scene = new Scene(root, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node getUsernameAndPassword() {
        HBox box = new HBox();
        box.setSpacing(15);
        TextField tfUserName = new TextField();
        tfUserName.setPromptText("Enter Username");
        tfUserName.setMaxWidth(120);
        tfUserName.setFocusTraversable(false);
        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Enter Password");
        tfPassword.setMaxWidth(120);
        tfPassword.setFocusTraversable(false);
        tfPassword.setOnAction(e -> System.out.println("Eingabe: " + tfUserName.getText() + " " + tfPassword.getText()));
        box.getChildren().addAll(tfUserName, tfPassword);
        return box;

    }

    private Node loginButton() {
        HBox box = new HBox();
        box.setSpacing(15);
        Button bLogin = new Button("Login");
        box.getChildren().addAll(bLogin);
        bLogin.setDefaultButton(true);
        bLogin.setOnAction(this::loginButtonAction);
        return box;
    }

    public void loginButtonAction(ActionEvent event) {
        // Validiert den Dialog
        // * 1. Benutzername darf nicht leer sein
        // * 2. Passwort darf nicht leer sein
        // * 3. Benutzernamen und Passwort müssen irgendwelchen festen Werten entsprechen

    }

    private Node loggedIn() {
        HBox box = new HBox();
        Label lLoggedIn = new Label("Logged in");
        // wenn Validation ok --> "Logged in"
        return box;
    }
}

