package gui.uebung.aufgabe15;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class AuszugTab extends BasisTab {
    private final Konto konto;
    private ListView<Object> liste;
    private ScrollPane spAnzeige;
    private Button bAktualisieren;
    private VBox box;


    public AuszugTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        box = new VBox();
        spAnzeige = new ScrollPane();
        spAnzeige.setMaxSize(400, 600);
        spAnzeige.setContent(liste);
        liste = new ListView<>();
        liste.setMaxWidth(200);
        bAktualisieren = new Button("Aktualisieren");
        box.getChildren().add(spAnzeige);
        box.getChildren().add(bAktualisieren);
        box.setPadding(new Insets(20));
        spAnzeige.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        spAnzeige.setVisible(true);
        bAktualisieren.setOnAction(e -> {
            liste.getItems().clear();
            for (double betrag : konto.getBuchungen()) {
                String art = betrag > 0 ? "Einzahlung" : "Auszahlung";
                String eintrag = String.format("%s %.2f%n", art, betrag);
                liste.getItems().add(eintrag);
            }
        });
        Tab tab = new Tab("Auszüge", box);
        return tab;
    }

}