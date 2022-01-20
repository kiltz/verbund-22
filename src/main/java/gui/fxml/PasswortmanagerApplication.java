package gui.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class PasswortmanagerApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL res = getClass().getResource("/fxml/passwortmanager.fxml");
        Parent root = FXMLLoader.load(res);
        primaryStage.setTitle("PasswortManager");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

}
