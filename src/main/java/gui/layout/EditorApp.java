package gui.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EditorApp extends Application {
    private TextField tfEingabe;
    private Button button;
    private ScrollPane scrolli;
    private TextField tfNeu;
    private Label langerLabel;
    private Button save;
    private Button help;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        tfEingabe = new TextField();
        button = new Button();
        tfNeu = new TextField();
        langerLabel = new Label();

        scrolli = new ScrollPane();
        scrolli.setMaxWidth(200);
        scrolli.setMaxHeight(200);
        scrolli.setContent(langerLabel);
        //scrolli.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        root.setVgap(5);
        root.setHgap(8);
        root.setPadding(new Insets(10));
        langerLabel.setContentDisplay(ContentDisplay.CENTER);


        root.add(new Label("Datei"), 0, 0);
        root.add(new TextField(""), 1, 0);
        root.add(new Button("Lesen"), 2, 0);
        //root.getChildren().add(scrolli);
        //root.getChildren().add(langerLabel);
        root.add(new ScrollPane(), 1, 5);
        root.add(new HBox(), 5, 17);

        Scene scene = new Scene(root, 300, 250);
        scrolli.setContent(langerLabel);
        primaryStage.setTitle("Mo's Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void anker() {
        AnchorPane root = new AnchorPane();
        save = new Button("Speichern");
        help = new Button("Beenden");

        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.getChildren().addAll(save, help);
        root.getChildren().add(buttons);
        AnchorPane.setRightAnchor(buttons, 10.0);
        AnchorPane.setBottomAnchor(buttons, 20.0);


    }
}
