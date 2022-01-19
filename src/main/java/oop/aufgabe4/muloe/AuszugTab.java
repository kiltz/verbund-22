package oop.aufgabe4.muloe;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AuszugTab extends BasisTab {
    public Label l_anzeige = new Label("Dialog für Auszüge");
    public Label l_einzahlung = new Label("Einzahlungen");
    public Label l_auszahlung = new Label("Auszahlungen");

    /*
    public void historie() {
        try {
                //if (die betragseingabe ist eine einzahlung){
                // dann wird die Buchungen unter einzahlung aufgeführt }

                // if (die betragseingabe ist eine auszahlung){
                // dann wird die Buchungen unter auszahlung aufgeführt }
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
     */

    @Override
    public Tab getTab() {

        HBox hb_box1 = new HBox();
        hb_box1.getChildren().add(l_anzeige);
        hb_box1.setSpacing(50);

        HBox hb_box2 = new HBox();
        hb_box2.getChildren().addAll(l_einzahlung, l_auszahlung);
        hb_box2.setSpacing(50);

        VBox vb_box1 = new VBox();
        vb_box1.getChildren().add(hb_box1);
        vb_box1.getChildren().add(hb_box2);
        // Hier müssen die Buchungen sichtbar werden
        vb_box1.setSpacing(10);

        Tab tab = new Tab("Auszüge", vb_box1);
        //historie();
        return tab;
    }
}
