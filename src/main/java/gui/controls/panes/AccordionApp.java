package gui.controls.panes;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class AccordionApp  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<Seiten> seiten = Arrays.asList(new Kontaktformular(), new Statistik(), new Login());

        Accordion root = new Accordion();
        for (Seiten o : seiten) {
            HBox box = new HBox();
            box.getChildren().add(o.getRoot());
            TitledPane pane = new TitledPane(o.getClass().getSimpleName(), box);
            root.getPanes().add(pane);
        }

        Scene scene = new Scene(root, 300, 470);
        primaryStage.setTitle("Akkordeon");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
