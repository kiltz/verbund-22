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
 */
public class StatisitkApp extends Application {

    private Label summe;
    private Label min;
    private Label max;
    private Label durchschnitt;

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
        primaryStage.setTitle("Mo's Statistik");
        primaryStage.show();
    }

    private Node getButtons() {
        HBox box = new HBox();
        Button button = new Button("Ergebnis");
        button.setOnAction(event -> button.setText("Done"));


        box.getChildren().add(button);
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


        box.getChildren().addAll(tf);
        return box;
    }


    private Node getLabels() {
        VBox box = new VBox();
        summe = new Label("Summe: 0");
        min = new Label("Min: 0");
        max = new Label("Max: 0");
        durchschnitt = new Label("Durschnitt: 0");

        // Integer.parseInt();

        /*
        int i;

        int arr;
        for(i=0 ; i<arr.length ; i++)  // Array ausgeben
            System.out.println(arr[i]);

        // Maximum bestimmen
        max = arr[0];
        for( i=0 ; i<arr.length ; i++)
            if (max<arr[i])
                max = arr[i] ;

        System.out.println("max = " + max);

        // Minimum bestimmen
        min = arr[0];
        for( i=0 ; i<arr.length ; i++)
            if (min>arr[i])
                min = arr[i] ;

        System.out.println("min = " + min);

        // Mittelwert bestimmen
        double mittel = 0 ;
        // Summe bilden
        for( i=0 ; i<arr.length ; i++)
            mittel += arr[i] ;

        mittel /= arr.length ;
        System.out.println("Mittelwert = " + durchschnitt);




         */


        box.getChildren().addAll(summe, min, max, durchschnitt);
        return box;
    }  // end main

}
