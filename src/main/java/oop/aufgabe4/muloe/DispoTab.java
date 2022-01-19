package oop.aufgabe4.muloe;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class DispoTab extends BasisTab {
    private final Konto konto;
    private Label anzeige;


    public DispoTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox();
        anzeige = new Label("Dispo");


        //zurueck.setOnAction(e -> box.removeEventFilter(box.getChildren(zurueck)));

        box.setSpacing(10);

        box.getChildren().add(anzeige);

        //box.getChildren().add(zurueck);

        Tab tab = new Tab("Dispo", box);
        tab.setOnSelectionChanged(e ->
                anzeige.setText(String.format("Dispo: %.2f", konto.getBuchungen()))
        );
        return tab;
    }
}
