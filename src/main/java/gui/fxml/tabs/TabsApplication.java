package gui.fxml.tabs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author tz
 */
public class TabsApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        URL res = getClass().getResource("tabMain.fxml");
        Parent root = FXMLLoader.load(res);
        primaryStage.setTitle("Tabs");
        primaryStage.setScene(new Scene(root, 400, 300));

        primaryStage.show();

    }
}
