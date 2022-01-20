package gui.layout.Editor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        root.setPadding(new Insets(10, 1, 10, 1));

        root.setTop(getOberenBereich());
        root.setBottom(getUnterenBereich());
        root.setCenter(getTextArea());

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mo's Editor");


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getTextArea() {
        HBox box = new HBox();
        TextArea tf = new TextArea();

        tf.setPromptText("Hier ist ein Böser Smilie >:((");

        ScrollPane scrolli = new ScrollPane();

        scrolli.setPadding(new Insets(10, 10, 10, 10));
        scrolli.setFitToWidth(true);
        scrolli.setFitToHeight(true);
        scrolli.setContent(tf);

        box.setAlignment(Pos.CENTER);


        scrolli.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrolli.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        box.getChildren().addAll(tf, scrolli);
        return box;
    }

    private Node getUnterenBereich() {
        AnchorPane pane = new AnchorPane();
        Button save = new Button("Speichern");
        Button help = new Button("Beenden");


        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.getChildren().addAll(save, help);
        pane.getChildren().add(buttons);
        pane.setPadding(new Insets(10, 10, 5, 10));
        AnchorPane.setRightAnchor(buttons, 10.0);
        AnchorPane.setBottomAnchor(buttons, 10.0);
        help.setOnAction(e -> Platform.exit());

        return pane;
    }

    private Node getOberenBereich() {
        FlowPane node = new FlowPane();
        node.setVgap(10.0);
        node.setHgap(10.0);

        node.setPadding(new Insets(10, 1, 10, 1));
        node.setAlignment(Pos.CENTER);
        node.getChildren().addAll(new Label("Datei"), new TextField(), new Button("Lesen"));

        return node;
    }


}
