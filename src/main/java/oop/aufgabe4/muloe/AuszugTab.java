package oop.aufgabe4.muloe;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AuszugTab extends BasisTab {
    private final Konto konto;
    private Label anzeige;
    private Button button;
    private Button zurueck;
    private ListView<Object> liste;
    private ScrollPane scrolli;


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


        liste = new ListView<>();
        liste.setMaxWidth(200);
        scrolli = new ScrollPane();
        scrolli.setMaxWidth(200);
        scrolli.setMaxHeight(200);
        scrolli.setContent(liste);
        scrolli.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrolli.setVisible(false);

        box.getChildren().add(anzeige);
        box.getChildren().add(button);
        box.getChildren().add(scrolli);
        //box.getChildren().add(zurueck);

        Tab tab = new Tab("Auszüge", box);
        tab.setOnSelectionChanged(e ->
                anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()))
        );
        return tab;
    }

    private void andereAnsicht() {
        if (button.getText().equals("Historie")) {
            liste.getItems().clear();
            for (double betrag : konto.getBuchungen()) {
                String art = betrag > 0 ? "Einzahlung" : "Auszahlung";
                String eintrag = String.format("%s %.2f%n", art, betrag);
                liste.getItems().add(eintrag);
            }
            //anzeige.setText();
            scrolli.setVisible(true);
            button.setText("Zurück");
        } else {
            scrolli.setVisible(false);
            button.setText("Historie");
        }

    }
}
