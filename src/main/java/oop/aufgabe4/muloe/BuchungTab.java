package oop.aufgabe4.muloe;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Zahlen;

import java.text.ParseException;

public class BuchungTab extends BasisTab {
    public double d_kontostand = 0;
    public TextField tf_betragseingabe = new TextField();
    public TextField tf_dispo = new TextField();
    public CheckBox cb_einzahlen = new CheckBox("Einzahlen");
    public CheckBox cb_auszahlen = new CheckBox("Auszahlen");
    public Label l_anzeigekontostand = new Label("Dialog für Buchungen");
    public Button b_buchen = new Button("buchen");
    public Button b_disposetzen = new Button("Dispo setzen");

    public void kontostand() {
        String s_betragseingabe = tf_betragseingabe.getText();

        try {
            double d_betragseingabe = Zahlen.stringToDouble(s_betragseingabe);

            b_buchen.setOnAction(event -> {

                if (cb_einzahlen.isSelected()) {
                    d_kontostand += d_betragseingabe;
                    l_anzeigekontostand.setText(String.format("Kontostand: %.2f", d_kontostand));
                }

                if (cb_auszahlen.isSelected()) {
                    d_kontostand = d_kontostand - d_betragseingabe;
                    l_anzeigekontostand.setText(String.format("Kontostand: %.2f", d_kontostand));
                }
            });
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        //l_anzeigekontostand.setText(String.format("Kontostand: %.2f", d_kontostand));
    }

    public void dispo() {
        String s_dispoeingabe = tf_dispo.getText();

        try {
            double d_dispoeingabe = Zahlen.stringToDouble(s_dispoeingabe);

            b_disposetzen.setOnAction(event -> {
                d_kontostand += d_dispoeingabe;
                l_anzeigekontostand.setText(String.format("Kontostand: %.2f", d_kontostand));
            });
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public Tab getTab() {

        // https://stackoverflow.com/questions/60035716/hbox-inside-vbox?rq=1
        HBox hb_box1 = new HBox();
        tf_betragseingabe.setPromptText("Betrag");
        tf_dispo.setPromptText("Dispo");
        hb_box1.getChildren().addAll(tf_betragseingabe, tf_dispo);
        hb_box1.setSpacing(50);

        HBox hb_box2 = new HBox();
        hb_box2.getChildren().addAll(cb_einzahlen, cb_auszahlen);
        hb_box2.setSpacing(5);

        HBox hb_box3 = new HBox();
        hb_box3.getChildren().addAll(b_buchen, b_disposetzen);
        hb_box3.setSpacing(145);

        VBox vb_box1 = new VBox();
        vb_box1.getChildren().add(l_anzeigekontostand);
        vb_box1.getChildren().add(hb_box1);
        vb_box1.getChildren().add(hb_box2);
        vb_box1.getChildren().add(hb_box3);
        vb_box1.setSpacing(10);

        Tab tab = new Tab("Buchungen", vb_box1);
        kontostand();
        dispo();
        return tab;
    }
}
