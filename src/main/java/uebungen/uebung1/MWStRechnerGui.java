package uebungen.uebung1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

/*
Aufgabe 1: 2 Pt
Aufgabe 2: 2 Pt
Aufgabe 3: 2 Pt
Aufgabe 4: 3 Pt
Aufgabe 5: 7 Pt
Aufgabe 6: 3 Pt
Aufgabe 7: 5 Pt
---------------
24 Pt.
 */
public class MWStRechnerGui extends Application {

    private TextField tfEingabe;
    private Label lErgebnis;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();

        tfEingabe = new TextField();
        Label lProzent = new Label("19 %");
        lErgebnis = new Label();
        Button bGleich = new Button(" = ");
        bGleich.setOnAction(e -> rechne());
        bGleich.setDefaultButton(true);
        root.getChildren().addAll(tfEingabe, lProzent, bGleich, lErgebnis);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.show();

    }

    private void rechne() {
        String eingabe = tfEingabe.getText();
        try {
            double zahl = Zahlen.stringToDouble(eingabe);
            double ergebnis = zahl * 0.19;
            lErgebnis.setText(Zahlen.doubleToString(ergebnis));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
