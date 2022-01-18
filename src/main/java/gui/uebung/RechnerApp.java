package gui.uebung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RechnerApp extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        TextField tf1 = new TextField("5");
        root.getChildren().add(tf1);
        Label l1 = new Label("+");
        root.getChildren().add(l1);
        TextField tf2 = new TextField("2");
        root.getChildren().add(tf2);
        Button bGleich = new Button("Berechne");
        root.getChildren().add(bGleich);
        Label lErgebnis = new Label("7");
        root.getChildren().add(lErgebnis);


        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}