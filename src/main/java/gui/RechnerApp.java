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
        HBox root = new HBox();
        TextField text1 = new TextField("");
        root.getChildren().add(text1);
        TextField text2 = new TextField("");
        root.getChildren().add(text2);
        Button button5 = new Button("5");
        root.getChildren().add(button5);
        Label plus = new Label(" + ");
        root.getChildren().add(plus);
        Button button2 = new Button("2");
        root.getChildren().add(button2);
        Label l = new Label(" = 7");
        root.getChildren().add(l);
        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
