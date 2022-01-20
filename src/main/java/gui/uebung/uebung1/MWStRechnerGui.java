package gui.uebung.uebung1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class MWStRechnerGui extends Application {
    private TextField tfBetrag;
    private Label lMWSt19;
    private Label erg;
    private double ergebnis;
    private String strErgebnis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox();
        Scene scene = new Scene(root, 400, 100);
        root.getChildren().add(Betrag());
        root.getChildren().add(MWSt());
        root.getChildren().add(Equals());
        root.getChildren().add(Ergebnis());
        root.setPadding(new Insets(20));
        root.setSpacing(10);
        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node Betrag() {
        HBox node = new HBox();
        tfBetrag = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                if (text.isEmpty() || !text.matches("[a-ü\\.]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (text.matches("[0-9,]")) {
                    super.replaceSelection(text);
                }
            }
        };
        tfBetrag.setPromptText("Betrag eingeben:");
        node.getChildren().add(tfBetrag);
        return node;
    }

    private Node Equals() {
        HBox node = new HBox();
        Button equals = new Button("=");
        equals.setOnAction(event -> rechne());
        equals.setDefaultButton(true);
        node.getChildren().add(equals);
        return node;
    }

    private void rechne() {
        strErgebnis = tfBetrag.getText();
        try {
            ergebnis = Zahlen.stringToDouble(strErgebnis);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        strErgebnis = Zahlen.doubleToString(ergebnis * 1.19);
        if (ergebnis > 0) {
            erg.setText(strErgebnis);
        } else {
            erg.setText("Bitte eine Zahl eingeben");
        }
    }

    private Node MWSt() {
        HBox node = new HBox();
        lMWSt19 = new Label("19 % ");
        node.getChildren().add(lMWSt19);
        return node;
    }

    private Node Ergebnis() {
        HBox node = new HBox();
        erg = new Label();
        node.getChildren().add(erg);
        return node;
    }
}