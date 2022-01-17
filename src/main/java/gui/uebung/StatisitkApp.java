package gui.uebung;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

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
        Button b_berechne = new Button("Auswerten");
        Label l_min = new Label("Minimum: ");
        Text t_minimum = new Text();
        Label l_max = new Label("Maximum: ");
        Text t_maximum = new Text();
        Label l_summe = new Label("Summe: ");
        Text t_summe = new Text();
        Label l_durchschnitt = new Label("Durchschnitt: ");
        Text t_durchschnitt = new Text();
        Label l_anzahl = new Label("Anzahl:");
        Text t_anzahl = new Text("2");

        HBox root = new HBox();
        VBox zahleneingabe = new VBox();
        zahleneingabe.setSpacing(10);
        zahleneingabe.getChildren().addAll(tf_zahleneingabe1, tf_zahleneingabe2, b_berechne);

        b_berechne.setOnAction(event -> {
            String s_eingabe1 = tf_zahleneingabe1.getText();
            String s_eingabe2 = tf_zahleneingabe2.getText();

            try {
                double d_zahl1 = Zahlen.stringToDouble(s_eingabe1);
                double d_zahl2 = Zahlen.stringToDouble(s_eingabe2);

                double d_summe = d_zahl1 + d_zahl2;
                String s_summe = Zahlen.doubleToString(d_summe);
                t_summe.setText(s_summe);

                double d_durchschnitt = d_summe / 2;
                String s_durchschnitt = Zahlen.doubleToString(d_durchschnitt);
                t_durchschnitt.setText(s_durchschnitt);

                if (d_zahl1 > d_zahl2) {
                    String s_maximum = Zahlen.doubleToString(d_zahl1);
                    t_maximum.setText(s_maximum);
                    String s_minimum = Zahlen.doubleToString(d_zahl2);
                    t_minimum.setText(s_minimum);
                } else {
                    String s_maximum = Zahlen.doubleToString(d_zahl2);
                    t_maximum.setText(s_maximum);
                    String s_minimum = Zahlen.doubleToString(d_zahl1);
                    t_minimum.setText(s_minimum);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }


            zahleneingabe.getChildren().addAll(l_min, t_minimum, l_max, t_maximum, l_summe, t_summe,
                    l_durchschnitt, t_durchschnitt, l_anzahl, t_anzahl);
        });

        Scene scene = new Scene(zahleneingabe, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}