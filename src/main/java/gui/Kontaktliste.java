package gui;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Kontaktliste extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.getChildren().add(setRadioButtonElement(new String[]{"Herr", "Frau"}));
        root.getChildren().add(setTextFieldElement(new String[]{"Bitte Namen eingeben"}));
        root.getChildren().add(setCombo(new String[]{"Dr. Dr."}, "Titel"));
        root.setSpacing(20);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node setTextFieldElement(String[] promtTexte) {
        HBox box = new HBox();
        for (String promtText : promtTexte) {
            TextField t = new TextField();
            t.setPromptText(promtText);
            box.getChildren().add(t);
        }
        box.setSpacing(10);
        return box;
    }

    private Node setRadioButtonElement(String[] namen) {
        HBox box = new HBox();
        ToggleGroup radiotoggleGroup = new ToggleGroup();
        for (String name : namen) {
            RadioButton r = new RadioButton(name);
            r.setToggleGroup(radiotoggleGroup);
            box.getChildren().add(r);
        }
        box.setSpacing(10);
        return box;
    }

    private Node setCombo(String[] namen, String promtText) {
        HBox box = new HBox();
        ComboBox<String> cb = new ComboBox<>();
        cb.setPromptText(promtText);
        for (String name : namen) {
            cb.getItems().add(name);
        }
        box.getChildren().add(cb);
        return box;
    }
}
