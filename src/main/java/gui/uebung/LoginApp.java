package gui.uebung;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
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

    private TextField tfUserName;
    private TextField tfPassword;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(15);
        primaryStage.setTitle("Login");
        root.getChildren().addAll(getUsernameAndPassword(), loginButton(), pruefeEingabe());
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node pruefeEingabe() {
        VBox vBox = new VBox();
//        if (loginButton().isPressed()) { // Funktioniert vielleicht nicht?
        if (tfUserName.getText().trim().isEmpty()) {
            Label unErr = new Label();
            vBox.getChildren().add(unErr);
        } else {
            vBox = new VBox();
        }
        if (tfPassword.getText().trim().isEmpty()) {
            Label pwErr = new Label();
            vBox.getChildren().add(pwErr);

        } else {
            vBox = new VBox();
        }
        tfUserName.setPromptText("Enter Username");
        tfPassword.setPromptText("Enter Password");
        return vBox;
    }

    private Node loginButton() {
        HBox box = new HBox();
        box.setSpacing(10);
        Button bLogin = new Button("Login");
        box.getChildren().addAll(bLogin);
        bLogin.setDefaultButton(true);
        bLogin.setStyle("-fx-background-color: #dfdfdf; ");
        bLogin.setOnAction(event -> pruefeEingabe());
        return box;

    }

    private Node getUsernameAndPassword() {
        HBox hBox = new HBox();
        hBox.setSpacing(15);
        tfUserName = new TextField();
        tfUserName.setMaxWidth(120);
        tfUserName.setFocusTraversable(false);
        tfPassword = new PasswordField();
        tfPassword.setMaxWidth(120);
        tfPassword.setFocusTraversable(false);
        hBox.getChildren().add(tfUserName);
        hBox.getChildren().add(tfPassword);
        return hBox;
    }
}

