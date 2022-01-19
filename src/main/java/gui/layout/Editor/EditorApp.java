package gui.layout.Editor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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

        root.setPadding(new Insets(10, 10, 10, 10));

        root.setTop(getOberenBereich());
        root.setBottom(getUnterenBereich());
        root.setCenter(getTextArea());
        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(root);


        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mo's Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getTextArea() {
        ScrollPane scrolli = new ScrollPane();

        scrolli.setMaxWidth(250);
        scrolli.setMaxHeight(150);

        scrolli.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrolli.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        return scrolli;
    }

    private Node getUnterenBereich() {
        AnchorPane pane = new AnchorPane();
        Button save = new Button("Speichern");
        Button help = new Button("Beenden");


        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.getChildren().addAll(save, help);
        pane.getChildren().add(buttons);
        pane.setPadding(new Insets(10, 10, 10, 10));
        AnchorPane.setRightAnchor(buttons, 10.0);
        AnchorPane.setBottomAnchor(buttons, 20.0);

        return pane;
    }

    private Node getOberenBereich() {
        FlowPane node = new FlowPane();
        node.setVgap(10.0);
        node.setHgap(10.0);
        node.setPadding(new Insets(10, 10, 10, 10));
        node.setAlignment(Pos.CENTER);
        node.getChildren().addAll(new Label("Datei"), new TextField(), new Button("Lesen"));

        return node;
    }

}
