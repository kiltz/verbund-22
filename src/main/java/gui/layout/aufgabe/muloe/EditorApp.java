package gui.layout.aufgabe.muloe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EditorApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(getOberenBereich());
        root.setBottom(getButtonLeiste());
        root.setCenter(getTextArea());

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getTextArea() {
        return new HBox();
    }

    private Node getButtonLeiste() {
        return new HBox();
    }

    private Node getOberenBereich() {
        FlowPane node = new FlowPane();
        node.setHgap(10);
        node.setVgap(10);
        node.setAlignment(Pos.CENTER);
        node.getChildren().addAll(new Label("Datei"), new TextField(), new Button("lesen"));
        return node;
    }
}

