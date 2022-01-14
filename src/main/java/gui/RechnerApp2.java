package gui;

import javafx.application.Application;
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


        HBox root = new HBox();
        root.getChildren().add(t);
        root.getChildren().add(l);
        root.getChildren().add(r);
        root.getChildren().add(button2);
        root.getChildren().add(e);

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

