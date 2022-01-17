package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class RechnerApp extends Application {

    private TextField tf_eingabe1;
    private TextField tf_eingabe2;
    private Label l_ergebnis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tf_eingabe1 = new TextField("5");
        tf_eingabe2 = new TextField("2");
        Label l_plus = new Label("+");
        l_ergebnis = new Label("7");
        Button b_berechne = new Button("=");
        b_berechne.setDefaultButton(true);
        b_berechne.setOnAction(e -> berechne(e));
        HBox root = new HBox();
        VBox rechner = new VBox();
        rechner.getChildren().addAll(tf_eingabe1, l_plus, tf_eingabe2, b_berechne, l_ergebnis);
        Scene scene = new Scene(rechner, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void berechne(ActionEvent e) {
        String s_text1 = tf_eingabe1.getText();

        try {
            double d_zahl1 = Zahlen.stringToDouble(s_text1);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
