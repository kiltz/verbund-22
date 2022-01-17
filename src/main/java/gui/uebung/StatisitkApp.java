package gui.uebung;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zahleneingabe
 * Min, Max, Summe, Durchschnitt, anzahl Zahlen ausgeben
 *
 */
public class StatisitkApp extends Application {

    public static void main(String[] args) {
        launch(null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setSpacing(15);

        root.getChildren().add(getTextFelder());
        root.getChildren().add(getButtons());
        root.getChildren().add(getLabels());

        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(root);


        Scene scene = new Scene(scrolli, 700, 200);
        root.setSpacing(10);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node getButtons() {
        HBox box = new HBox();
        Button button = new Button("Ergebnis");
        button.setOnAction(event -> button.setText("Done"));

        // Nach erneuter eingabe soll wieder zurückspringen auf Eingabe
        // button.setOnAction(event -> button.setText("Ergebnis"));

        box.getChildren().add(button);
        return box;
    }

    private Node getLabels() {
        // Wie stelle ich sie untereinander
        VBox box = new VBox();
        Label summe = new Label("Summe: ");
        Label min = new Label("Min: ");
        Label max = new Label("Max: ");
        Label durchschnitt = new Label("Durchschnitt: ");


        box.getChildren().addAll(summe, min, max, durchschnitt);
        return box;

    }

    private Node getTextFelder() {

        // rechnungen fehlen
        HBox box = new HBox();
        box.setSpacing(8);
        TextField tf = new TextField();
        tf.setPromptText("Eingabe");
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


        box.getChildren().addAll(tf);
        return box;
    }


}
