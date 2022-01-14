package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Rechner extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Font myFont = new Font("Arial", 20);

        TextField f1 = new TextField();
        f1.setPrefColumnCount(2);
        f1.setFont(myFont);

        Label l1 = new Label("+");
        l1.setFont(myFont);

        TextField f2 = new TextField();
        f2.setPrefColumnCount(2);
        f2.setFont(myFont);

        Label l2 = new Label("= ?");
        l2.setFont(myFont);

        HBox hBox1 = new HBox();
        hBox1.getChildren().setAll(f1, l1, f2, l2);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(5);


        Button btn = new Button();
        btn.setText("Rechnen");
        btn.setFont(myFont);
        btn.setOnAction(event -> {
            try {
                int a = Integer.parseInt(f1.getText());
                int b = Integer.parseInt(f2.getText());

                l2.setText(String.format("= %d", a + b));
            } catch (NumberFormatException ex) {
                f1.setText("");
                f2.setText("");
                l2.setText("= ?");
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(hBox1, btn);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Scene scene = new Scene(root, 250, 200);

        primaryStage.setTitle("Coolste App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
