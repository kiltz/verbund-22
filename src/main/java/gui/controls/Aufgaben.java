package gui.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Aufgaben extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static void showStart(Stage primaryStage) {
        Font myFont = new Font("Arial", 25);

        Button bAufgabe1 = new Button("Aufgabe 1");
        bAufgabe1.setFont(myFont);
        bAufgabe1.setOnAction(event -> Aufgabe1.show(primaryStage));

        Button bAufgabe2 = new Button("Aufgabe 2");
        bAufgabe2.setFont(myFont);
        bAufgabe2.setOnAction(event -> Aufgabe2.show(primaryStage));

        Button bAufgabe3 = new Button("Aufgabe 3");
        bAufgabe3.setFont(myFont);

        VBox vbStart = new VBox(bAufgabe1, bAufgabe2, bAufgabe3);
        vbStart.setPadding(new Insets(10, 10, 10, 10));
        vbStart.setAlignment(Pos.CENTER);
        vbStart.setSpacing(10);

        Scene sStart = new Scene(vbStart, 200, 250);
        primaryStage.setTitle("Aufgaben");
        primaryStage.setScene(sStart);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        showStart(primaryStage);
    }
}
