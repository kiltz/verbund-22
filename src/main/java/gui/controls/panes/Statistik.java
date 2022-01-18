package gui.controls.panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class Statistik extends Seiten {

    private TextField tfEingabe;
    private Label lAusgabeW;
    private Label lAusgabeZ;
    private CheckBox box1;
    private CheckBox box2;
    private List<String> zeilen = new ArrayList<>();

    public Node getRoot() {
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

        VBox vbStatistik = new VBox(lEingabe, tfEingabe, hb1, hb2, new VBox(lAusgabeW, lAusgabeZ));
        vbStatistik.setPadding(new Insets(10));
        vbStatistik.setAlignment(Pos.TOP_LEFT);
        vbStatistik.setSpacing(10);

        return vbStatistik;
    }

    private void showStatistik() {
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
}
