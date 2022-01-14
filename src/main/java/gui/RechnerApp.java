package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
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


    private TextField TF1;
    private TextField TF2;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Rechner");
        HBox root = new HBox();

        //5
        TF1 = new TextField("5");
        root.getChildren().add(TF1);

        //+
        Label l = new Label(" + ");
        root.getChildren().add(l);

        //2
        TF2 = new TextField("2");
        root.getChildren().add(TF2);

        //=
        Button button1 = new Button("=");
        button1.setOnAction(e -> berechne(e));
        root.getChildren().add(button1);

        //Ergebnis
        Label l2 = new Label(berechne());
        root.getChildren().add(l2);

        Scene scene = new Scene(root, 400, 50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void berechne(ActionEvent e) {
        int zahl1 = Integer.parseInt(String.valueOf(TF1));
        int zahl2 = Integer.parseInt(String.valueOf(TF2));
        System.out.println(zahl1 + zahl2);
    }
}
