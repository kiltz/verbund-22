package gui.uebung;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Aufgabe:
 * Zahleneingabe
 * Min, Max, Summe, Durchschnitt, anzahl Zahlen ausgeben
 */
public class StatisitkApp extends Application {

    private Label lMin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        primaryStage.setTitle("Statistics");
        root.getChildren().addAll(min(), max(), summe(), durchschnitt(), anzZahlen());
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node min() {
        VBox box = new VBox();
        Integer min;
        lMin = new Label("Min: ");
        return box;
    }

    private Node max() {
        return null;
    }

    private Node summe() {
        return null;
    }

    private Node durchschnitt() {
        return null;
    }

    private Node anzZahlen() {
        return null;
    }


}
