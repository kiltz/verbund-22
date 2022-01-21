package de.verbund.pwmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author JK
 */
public class StarterApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL res = getClass().getResource("/gui/fxml/pwmanager.fxml");
        Parent root = FXMLLoader.load(res);
        primaryStage.setTitle("Password Manager");
        primaryStage.setScene(new Scene(root, 560, 425));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
