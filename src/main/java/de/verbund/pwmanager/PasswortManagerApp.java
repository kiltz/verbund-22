package de.verbund.pwmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PasswortManagerApp extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        PasswortManagerApp.primaryStage = primaryStage;
        URL res = getClass().getResource("passwortManager.fxml");
        Parent root = FXMLLoader.load(res);

        primaryStage.setTitle("Passwort Manager");
        primaryStage.setScene(new Scene(root, 790, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
