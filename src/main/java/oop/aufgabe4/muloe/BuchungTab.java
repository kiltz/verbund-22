package oop.aufgabe4.muloe;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Zahlen;

import java.text.ParseException;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    public TextField tf_betragseingabe = new TextField("Betrag");
    public CheckBox cb_einzahlen = new CheckBox("Einzahlen");
    public CheckBox cb_auszahlen = new CheckBox("Auszahlen");
    public Label anzeige = new Label("Dialog für Buchungen");

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    public void kontostand() {
        String s_betragseingabe = tf_betragseingabe.getText();

        try {
            double d_betragseingabe = Zahlen.stringToDouble(s_betragseingabe);

            cb_einzahlen.setOnAction(event -> {
                konto.einzahlen(d_betragseingabe);
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
            });

            cb_auszahlen.setOnAction(event -> {
                konto.auszahlen(d_betragseingabe);
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
            });

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tab getTab() {
        Button b_buchen = new Button("buchen");

        // https://stackoverflow.com/questions/60035716/hbox-inside-vbox?rq=1
        HBox hb_box1 = new HBox();
        hb_box1.getChildren().add(tf_betragseingabe);
        hb_box1.setSpacing(5);

        HBox hb_box2 = new HBox();
        hb_box2.getChildren().addAll(cb_einzahlen, cb_auszahlen);
        hb_box2.setSpacing(5);

        VBox vb_box1 = new VBox();
        vb_box1.getChildren().add(anzeige);
        vb_box1.getChildren().add(hb_box1);
        vb_box1.getChildren().add(hb_box2);
        vb_box1.getChildren().add(b_buchen);
        vb_box1.setSpacing(10);

        b_buchen.setOnAction(e -> {
            kontostand();
        });

        Tab tab = new Tab("Buchungen", vb_box1);
        return tab;
    }
}
