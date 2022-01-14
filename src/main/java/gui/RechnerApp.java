package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class RechnerApp extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Rechner");
        HBox root = new HBox();

        //5
        TextField TextField1 = new TextField("5");
        root.getChildren().add(TextField1);

        //+
        Label l = new Label(" + ");
        root.getChildren().add(l);

        //2
        TextField TextField2 = new TextField("2");
        root.getChildren().add(TextField2);

        //=
        Button button1 = new Button("=");
        root.getChildren().add(button1);

        //7
        Label l2 = new Label(" 7 ");
        root.getChildren().add(l2);

        Scene scene = new Scene(root, 400, 50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
