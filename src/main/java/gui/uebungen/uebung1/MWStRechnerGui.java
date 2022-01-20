package gui.uebungen.uebung1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class MWStRechnerGui extends Application {

    public TextField tf_betragseingabe = new TextField();
    public Label l_ergebnis = new Label();

    public static void main(String[] args) {
        launch(null);
    }

    public void rechne() throws ParseException {
        String s_betragseingabe = tf_betragseingabe.getText();
        double d_betragseingabe = Zahlen.stringToDouble(s_betragseingabe);

        double d_ergebnis = (d_betragseingabe / 100 * 119);
        String s_ergebnis = Zahlen.doubleToString(d_ergebnis);
        l_ergebnis.setText(s_ergebnis);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        tf_betragseingabe.setPromptText("Betrag (mit Komma!)");
        Label l_mehrwertsteuer = new Label("19%");
        Button b_rechne = new Button("=");
        b_rechne.setDefaultButton(true);

        b_rechne.setOnAction(event -> {
            try {
                rechne();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        HBox WurzelKnoten = new HBox();
        Scene scene = new Scene(WurzelKnoten, 700, 200);
        WurzelKnoten.getChildren().addAll(tf_betragseingabe, l_mehrwertsteuer, b_rechne, l_ergebnis);
        WurzelKnoten.setSpacing(10);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.show();

    }
}

/*
1. 1 Punkt
2. 2 Punkte
3. 2 Punkte
4. 3 Punkte
5. 7 Punkte
6. 2 Punkte
7. 5 Punkte

22/24

 */
