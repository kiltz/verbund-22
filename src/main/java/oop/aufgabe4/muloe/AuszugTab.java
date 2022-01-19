package oop.aufgabe4.muloe;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.text.ParseException;
import java.util.List;

public class AuszugTab extends BasisTab {
    public Konto konto;
    public Label l_anzeige = new Label("Dialog für Auszüge");
    public Label l_einzahlung = new Label("Einzahlungen");
    public Label l_einzahlungliste = new Label();
    public Label l_auszahlung = new Label("Auszahlungen");
    public Label l_auszahlungliste = new Label();

    public AuszugTab(Konto konto) {
        this.konto = konto;
    }

    public void historie() {
        List<Double> al_einzahlungen = konto.getEinzahlungen();
        List<Double> al_auszahlungen = konto.getAuszahlungen();

        for (int i = 0; i < al_einzahlungen.size(); i++) {
            l_einzahlungliste.setText(al_einzahlungen.get(i).toString());
        }

        for (int i = 0; i < al_auszahlungen.size(); i++) {
            l_auszahlungliste.setText(al_auszahlungen.get(i).toString());
        }
    }

    @Override
    public Tab getTab() {

        HBox hb_box1 = new HBox();
        hb_box1.getChildren().add(l_anzeige);
        hb_box1.setSpacing(50);

        HBox hb_box2 = new HBox();
        hb_box2.getChildren().addAll(l_einzahlung, l_auszahlung);
        hb_box2.setSpacing(50);

        VBox vb_einzahlungen = new VBox();
        vb_einzahlungen.getChildren().addAll(l_einzahlungliste);
        vb_einzahlungen.setSpacing(10);

        VBox vb_auszahlungen = new VBox();
        vb_einzahlungen.getChildren().addAll(l_auszahlungliste);
        vb_einzahlungen.setSpacing(10);

        HBox hb_box3 = new HBox();
        hb_box3.getChildren().addAll(vb_einzahlungen, vb_auszahlungen);
        hb_box3.setSpacing(50);

        VBox vb_box1 = new VBox();
        vb_box1.getChildren().add(hb_box1);
        vb_box1.getChildren().add(hb_box2);
        vb_box1.getChildren().add(hb_box3);
        vb_box1.setSpacing(10);

        Tab tab = new Tab("Auszüge", vb_box1);
        historie();
        return tab;
    }
}
