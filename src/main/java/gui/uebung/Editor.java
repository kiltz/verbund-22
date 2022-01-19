package gui.uebung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;


public class Editor extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Label lDateiName = new Label();
        TextField eingabeFeld = new TextField();
        Button bDateiAuswaehlen = new Button();
        HBox obereBox = new HBox();
        obereBox.getChildren().addAll(new Label());
        root.setTop(obereBox);
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
