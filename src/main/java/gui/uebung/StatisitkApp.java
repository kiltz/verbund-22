package gui.uebung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        TextField tf_zahleneingabe1 = new TextField("erste Zahl");
        TextField tf_zahleneingabe2 = new TextField("zweite Zahl");
        Label l_min = new Label();
        Label l_max = new Label();
        Label l_summe = new Label();
        Label l_durchschnitt = new Label();
        Label l_anzahl = new Label();
        HBox root = new HBox();
        VBox zahleneingabe = new VBox();
        zahleneingabe.setSpacing(15);
        zahleneingabe.getChildren().addAll(tf_zahleneingabe1, tf_zahleneingabe2);
        Scene scene = new Scene(zahleneingabe, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
