package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
Aufgabe:
1. Kopiert die BasicApp nach RechnerApp
2. Erstellt zwei TextFelder, zwei Label und einen Button
    (TextField, Button)
    [.5.] + [.2.] (=) 7

Keine Funktionalität!
 */

public class BasicApp extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l = new Label("Hallo JavaFX!");
        HBox root = new HBox();
        root.getChildren().add(l);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
