package gui.aufgabe.muloe;

import javafx.application.Application;
import javafx.geometry.Insets;
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
        Label lErgebnis = new Label("7");
        Label lPlus = new Label(" + ");
        TextField tfEins = new TextField("5");
        tfEins.setMaxWidth(50);
        TextField tfZwei = new TextField("2");
        tfZwei.setMaxWidth(50);
        Button bRechne = new Button(" = ");

        HBox root = new HBox();
        root.setSpacing(10);
        Insets insets = new Insets(20, 10, 20, 10);
        root.setPadding(insets);
        root.getChildren().addAll(tfEins, lPlus, tfZwei, bRechne, lErgebnis);
        Scene scene = new Scene(root, 250, 150);
        primaryStage.setTitle("Rechner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
