package gui.controls;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Kontaktangaben extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setSpacing(15);

        root.getChildren().add(getCombo());
        root.getChildren().add(getTextFelder());


        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(root);

        Scene scene = new Scene(scrolli, 260, 400);
        primaryStage.setTitle("Kontaktformular");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getCombo() {
        HBox box = new HBox();
        box.setSpacing(15);

        ComboBox<String> anrede = new ComboBox<>();
        anrede.getItems().add("Frau");
        anrede.getItems().add("Herr");


        ListView<String> liste = new ListView<>();
        liste.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String o, String n) ->
                        System.out.println("Liste: " + n));
//        liste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        liste.setMaxWidth(100);


        box.getChildren().addAll(anrede);
        return box;
    }

    private Node getTextFelder() {
        VBox box = new VBox();
        box.setSpacing(15);
        TextField nachname = new TextField();
        nachname.setPromptText("Nachname");
        nachname.setOnAction(e ->
                System.out.println("Eingabe: " + nachname.getText())
        );


        TextField vorname = new TextField();
        vorname.setPromptText("Vorname");
        vorname.setOnAction(e ->
                System.out.println("Eingabe: " + vorname.getText())
        );

        TextField alter = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                if (text.isEmpty() || text.matches("[0-9]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (text.matches("[0-9]")) {
                    super.replaceSelection(text);
                }
            }
        };
        alter.setPromptText("Alter");

        TextField email = new TextField();
        email.setPromptText("E-Mail");
        email.setOnAction(e ->
                System.out.println("Eingabe: " + email.getText())
        );

        TextArea nachricht = new TextArea();
        nachricht.setPromptText("Ihre Nachricht:");
        nachricht.setPrefRowCount(4);
        nachricht.setPrefColumnCount(20);
        nachricht.setWrapText(true);

        box.getChildren().addAll(nachname, vorname, alter, email, nachricht);
        return box;
    }


}


