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

public class SammelApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setSpacing(15);

        root.getChildren().add(getLabels());
        root.getChildren().add(getButtons());
        root.getChildren().add(getTextFelder());
        root.getChildren().add(getBoxAndButts());
        root.getChildren().add(getCombo());

        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(root);

        Scene scene = new Scene(scrolli, 600, 450);
        primaryStage.setTitle("Control-Sammlung");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node getCombo() {
        HBox box = new HBox();
        box.setSpacing(15);
        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().add("Combo");
        cb.getItems().add("Zwei");
        cb.getItems().add("Drei");

        ChoiceBox<String> cb2 = new ChoiceBox<>();
        cb2.getItems().add("Choice");
        cb2.getItems().add("Zwei");
        cb2.getItems().add("Drei");

        ListView<String> liste = new ListView<>();
        liste.getItems().addAll("Liste","Zwei", "Drei");
        liste.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String o, String n) ->
                        System.out.println("Liste: "+n));
//        liste.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        liste.setMaxWidth(100);
        ScrollPane scrolli = new ScrollPane();
        scrolli.setMaxWidth(100);
        scrolli.setMaxHeight(150);
        scrolli.setContent(liste);
        scrolli.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        box.getChildren().addAll(cb, cb2, scrolli);
        return box;
    }

    private Node getTextFelder() {
        HBox box = new HBox();
        box.setSpacing(15);
        TextField tf = new TextField();
        tf.setPromptText("Gib mir Input!");
        tf.setOnAction(e ->
                System.out.println("Eingabe: " + tf.getText())
        );
        TextField tfNurZahlen = new TextField() {
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
        tfNurZahlen.setPromptText("Nur Zahlen!");

        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(4);
        textArea.setPrefColumnCount(20);
        textArea.setWrapText(true);

        box.getChildren().addAll(tf, tfNurZahlen, textArea);
        return box;
    }

    private Node getBoxAndButts() {
        HBox box = new HBox();
        box.setSpacing(15);
        CheckBox box1 = new CheckBox("2 Zust??nde");
        CheckBox box2 = new CheckBox("3 Zust??nde");
        box2.setAllowIndeterminate(true);

        ToggleButton toggleButton = new ToggleButton("Opt 1");
        ToggleButton toggleButton2 = new ToggleButton("Opt 2");
        ToggleButton toggleButton3 = new ToggleButton("Opt 3");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);

        RadioButton radioButton = new RadioButton("R 1");
        RadioButton radioButton2 = new RadioButton("R 2");
        RadioButton radioButton3 = new RadioButton("R 3");
        ToggleGroup radiotoggleGroup = new ToggleGroup();
        radioButton.setToggleGroup(radiotoggleGroup);
        radioButton2.setToggleGroup(radiotoggleGroup);
        radioButton3.setToggleGroup(radiotoggleGroup);

        box.getChildren().addAll(box1, box2, toggleButton, toggleButton2, toggleButton3, radioButton, radioButton2, radioButton3);
        return box;
    }

    private Node getButtons() {
        HBox box = new HBox();
        box.setSpacing(15);
        Button b1 = new Button("TuNix!");
        Button b2 = new Button("TuWas!");
        b2.setOnAction(e -> b2.setText("Geklickt!"));
        Button b3 = new Button("Default");
        b3.setDefaultButton(true);
        Button b4 = new Button("Abbruch");
        b4.setCancelButton(true);
        Hyperlink link = new Hyperlink("Klick mich nicht!");
        link.setOnAction(e -> Platform.exit());

        box.getChildren().addAll(b1, b2, b3, b4, link);
        return box;
    }

    private Node getLabels() {
        HBox box = new HBox();
        box.setSpacing(15);
        Label einLabel = new Label("Klick mich!");
        einLabel.setFont(Font.font("Verdana", 18));
        einLabel.setTextFill(Color.web("#005091"));
        einLabel.setOnMouseClicked(e -> einLabel.setText("Danke!"));
        Label labelMitBild = new Label("Mit Icon");
//        Image image = new Image("http://www.kiltz.de/icon_biggrin.gif");
        Image image = new Image("img/wtf-code.jpg");
        labelMitBild.setGraphic(new ImageView(image));
        labelMitBild.setContentDisplay(ContentDisplay.RIGHT);
        labelMitBild.setGraphicTextGap(15);
        labelMitBild.setTooltip(new Tooltip("Ein Icon aus dem Netz."));

        Label langerLabel = new Label("In den Betten \n\n der Hutmacher drehen gegen T??rme. Wir haben nichts fangen k??nnen, nur eine Zeitung kurzweilig ??berhaupt gesehen. Jeder herein, ganz versessen den Ganges.");
        langerLabel.setWrapText(true);
        langerLabel.setTooltip(new Tooltip(langerLabel.getText()));
        langerLabel.setContentDisplay(ContentDisplay.CENTER);

        ScrollPane scrolli = new ScrollPane();
        scrolli.setMaxWidth(100);
        scrolli.setContent(langerLabel);


        box.getChildren().addAll(einLabel, labelMitBild, scrolli);
        return box;
    }

}