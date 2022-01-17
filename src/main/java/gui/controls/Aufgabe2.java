package gui.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class Aufgabe2 {

    private static TextField tfEingabe;
    private static Scene sAufgabe2;
    private static Label lAusgabeW;
    private static Label lAusgabeZ;
    private static CheckBox box1;
    private static CheckBox box2;
    private static List<String> zeilen = new ArrayList<>();

    private static Scene newAufgabe2(Stage primaryStage) {
        //zurück
        Button bZurueck = new Button("ZURÜCK");
        bZurueck.setFont(new Font("Arial", 10));
        bZurueck.setOnAction(event -> Aufgaben.showStart(primaryStage));

        Label lEingabe = new Label("Geben Sie etwas ein:");

        tfEingabe = new TextField();
        tfEingabe.setMinHeight(100);
        tfEingabe.setAlignment(Pos.TOP_LEFT);

        box1 = new CheckBox("Wörter zählen");
        box2 = new CheckBox("Zeichen zählen");
        HBox hb1 = new HBox(box1, box2);
        hb1.setSpacing(10);

        Button bZaehlen = new Button("Zählen");
        bZaehlen.setOnAction(event -> showStatistik());

        Button bZuruecksetzen = new Button("Zurücksetzen");
        bZuruecksetzen.setOnAction(event -> {
            zeilen = new ArrayList<>();
            lAusgabeW.setText("");
            lAusgabeZ.setText("");
        });

        HBox hb2 = new HBox(bZaehlen, bZuruecksetzen);
        hb2.setSpacing(10);

        lAusgabeW = new Label();
        lAusgabeZ = new Label();


        VBox vbAufgabe2 = new VBox(bZurueck, lEingabe, tfEingabe, hb1, hb2, new VBox(lAusgabeW, lAusgabeZ));
        vbAufgabe2.setPadding(new Insets(10));
        vbAufgabe2.setAlignment(Pos.TOP_LEFT);
        vbAufgabe2.setSpacing(10);

        return new Scene(vbAufgabe2, 300, 280);
    }

    private static void showStatistik() {
        zeilen.add(tfEingabe.getText());
        tfEingabe.setText("");

        AtomicInteger anzahlZeichen = new AtomicInteger();
        long anzahlWoerter = zeilen.stream()
                .flatMap(zeile -> Stream.of(zeile.split("\\s+")))
                .filter(wort -> wort.length() > 0)
                .peek(wort -> anzahlZeichen.addAndGet(wort.length()))
                .count();


        if (box1.isSelected()) {
            lAusgabeW.setText("Anzahl (Wörter): " + anzahlWoerter);
        } else {
            lAusgabeW.setText("");
        }
        if (box2.isSelected()) {
            lAusgabeZ.setText("Anzahl (Zeichen): " + anzahlZeichen);
        } else {
            lAusgabeZ.setText("");
        }

    }

    public static void show(Stage primaryStage) {
        if (sAufgabe2 == null) {
            sAufgabe2 = newAufgabe2(primaryStage);
        }

        primaryStage.setTitle("Statistik");
        primaryStage.setScene(sAufgabe2);
        primaryStage.show();

    }
}
