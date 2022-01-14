package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RechnerApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField tf_eingabe1 = new TextField("5");
        TextField tf_eingabe2 = new TextField("2");
        Label l_plus = new Label("+");
        Label l_ergebnis = new Label("7");
        Button b_berechne = new Button("=");
        HBox root = new HBox();
        VBox rechner = new VBox();
        rechner.getChildren().addAll(tf_eingabe1, l_plus, tf_eingabe2, b_berechne, l_ergebnis);
        Scene scene = new Scene(rechner, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
