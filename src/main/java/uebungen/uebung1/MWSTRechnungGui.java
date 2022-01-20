package uebungen.uebung1;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class MWSTRechnungGui extends Application {

    private TextField tfEingabe;
    private Label lErgebnis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();

        root.getChildren().add(getTextFeld());
        root.getChildren().add(getLabels());
        root.getChildren().add(getButton());
        root.getChildren().add(getLabel());


        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private Node getTextFeld() {
        HBox box = new HBox();
        tfEingabe = new TextField();

        tfEingabe.setPromptText("Eingabe mit Komma");

        box.getChildren().add(tfEingabe);
        return tfEingabe;
    }

    private Node getButton() {
        HBox box = new HBox();

        Button gleich = new Button("=");

        gleich.setOnAction(e -> rechne());
        gleich.setDefaultButton(true);
        box.getChildren().add(gleich);

        return gleich;
    }

    private void rechne() {
        String eingabe = tfEingabe.getText();
        try {

            double betrag = Zahlen.stringToDouble(eingabe);

            double MwstSatz = 0.19;
            double ergebnis = (betrag * MwstSatz);

            lErgebnis.setText(Zahlen.doubleToString(ergebnis));


        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }


    private Node getLabels() {
        HBox box = new HBox();
        Label label = new Label("19%");
        Label slabel = new Label();

        box.getChildren().addAll(label, slabel);

        return box;
    }

    private Node getLabel() {
        HBox box = new HBox();

        lErgebnis = new Label();

        box.getChildren().add(lErgebnis);
        return lErgebnis;
    }

}
