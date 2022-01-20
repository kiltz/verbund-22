package de.verbund.pwmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author tz
 */
public class StarterApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        URL res = getClass().getResource("password.fxml");
        Parent root = FXMLLoader.load(res);
        primaryStage.setTitle("Login-Text");
        primaryStage.setScene(new Scene(root, 400, 300));

        primaryStage.show();

    }
}