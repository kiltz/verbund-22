package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Rechner extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Label l = new Label("5 + 2 = ?");
        l.setFont(new Font("Arial", 30));
        l.setTextFill(Color.web("#0076a3"));

        Button btn = new Button();
        btn.setText("Rechnen");
        btn.setFont(new Font("Arial", 30));
        btn.setOnAction(event -> {
            l.setText("5 + 2 = 7");
            l.setTextFill(Color.web("#FF0000"));
        });

        VBox root = new VBox();
        root.getChildren().addAll(l, btn);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Scene scene = new Scene(root, 250, 200);

        primaryStage.setTitle("Coolste App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
