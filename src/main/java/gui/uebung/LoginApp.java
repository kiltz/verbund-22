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
    private Label eingabeErr = new Label("");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(20, 10, 0, 10));
        root.setSpacing(15);
        primaryStage.setTitle("Login");
        // tz: ausgelagert in extra Methoden: gut!
        root.getChildren().addAll(getUsernameAndPassword(), loginButton(), buttonClicked());
        Scene scene = new Scene(root, 300, 110);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node loginButton() {
        HBox box = new HBox();
        box.setSpacing(10);
        Button bLogin = new Button("Login");
        box.getChildren().addAll(bLogin);
        bLogin.setDefaultButton(true);
        tfUserName.setPromptText("Enter Username");
        tfPassword.setPromptText("Enter Password");
//        bLogin.setStyle("-fx-background-color: #dfdfdf; ");
        eingabeErr.setMaxHeight(200);
        box.getChildren().add(eingabeErr);
        bLogin.setOnAction(event -> buttonClicked());
        return box;

    }

    private Node buttonClicked() {
        VBox vBox = new VBox();
        eingabeErr.setText("");
        pruefeEingabe();
        return vBox;
    }

    private void pruefeEingabe() {
        eingabeErr.setStyle("-fx-text-fill: red;");
        if (tfUserName.getText().trim().isEmpty()) {
            eingabeErr.setText("Username can't be empty");
        } else if (tfPassword.getText().trim().isEmpty()) {
            eingabeErr.setText("Password can't be empty");
        } else if (tfPassword.getText().trim().length() < 4) {
            eingabeErr.setText("Password must be longer\nthen 4 characters");
        } else {
            eingabeErr.getStyleClass().clear();
            eingabeErr.setStyle(null);
            eingabeErr.setText("Logged in as: " + tfUserName.getText());
            tfUserName.clear();
            tfPassword.clear();
//            System.exit(0); // braucht timer
        }
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

