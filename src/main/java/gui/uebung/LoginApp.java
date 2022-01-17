package gui.uebung;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
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
    private StackPane root = new StackPane();
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        Button button = new Button("OPEN");
        VBox vBox = new VBox();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        vBox.getChildren().addAll(
                new Label("Your Username"),
                new TextField(),
                new Label("Your Password"),
                new PasswordField(),
                new Button("LOGIN"));
        root.getChildren().addAll(vBox);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setTitle("UniversalMode");

    }
}
