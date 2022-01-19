package oop.aufgabe4.muloe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class AuszugTab extends BasisTab {
    private final Konto konto;
    private Label anzeige;
    private Button button;
    private Button zurueck;


    public AuszugTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox();
        anzeige = new Label("Dialog für Auzüge");
        button = new Button("Historie");
        zurueck = new Button("Zurück");
        button.setOnAction(e -> andereAnsicht());
        //zurueck.setOnAction(e -> box.removeEventFilter(box.getChildren(zurueck)));

        box.setSpacing(10);

        box.getChildren().add(anzeige);
        box.getChildren().add(button);
        //box.getChildren().add(zurueck);

        Tab tab = new Tab("Auszüge", box);
        tab.setOnSelectionChanged(e ->
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()))
        );
        return tab;
    }

    private void andereAnsicht() {
        if (button.getText().equals("Historie")) {
            konto.zeigeHistorie();
            //anzeige.setText();
            button.setText("Zurück");
        } else {
            button.setText("Historie");
        }

    }
}
