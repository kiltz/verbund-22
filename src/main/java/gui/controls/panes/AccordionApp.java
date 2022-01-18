package gui.controls.panes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AccordionApp extends Application {

    private StackPane root = new StackPane();
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        List<Seiten> seiten = new ArrayList<>();
        Accordion root = new Accordion();
        for (int i = 1; i <= 1; ++i) {
            for (Seiten o : seiten) {
                HBox box = new HBox();
                box.getChildren().add(new Label("Label der Box " + i));
                //TitledPane pane = new TitledPane("Box "+i, box);
                box.getChildren().add(o.getRoot());
                //TitledPane pane = new TitledPane(o.getRoot(), box);
                // root.getPanes().add(pane);

            }
        }
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mo's Akkordeon!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
