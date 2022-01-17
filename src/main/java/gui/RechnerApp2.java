package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class RechnerApp2 extends Application {


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField t = new TextField("5");
        TextField r = new TextField("2");
        Button button2 = new Button("=");
        Label l = new Label(" + ");
        Label e = new Label("  7 ");
        //YourButton d = new YourButton();

        HBox root = new HBox();
        root.setSpacing(10);
        Insets insets = new Insets(20, 10, 20, 10);
        root.setPadding(insets);
        root.getChildren().add(t);
        root.getChildren().add(l);
        root.getChildren().add(r);
        root.getChildren().add(button2);
        root.getChildren().add(e);

        Scene scene = new Scene(root, 440, 250);
        primaryStage.setTitle("Mo's Rechner");
        primaryStage.setScene(scene);
        primaryStage.show();


        button2.setDefaultButton(true);
        button2.setOnAction(h -> {

            Integer num1 = Integer.parseInt(t.getText());
            Integer num2 = Integer.parseInt(r.getText());
            Integer res;
            res = num1 + num2;
            e.setText(String.format("%d", res));
        });


    }


}

