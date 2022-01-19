package oop.aufgabe4.muloe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class AuszugTab extends BasisTab {
    private final Konto konto;
    private final KontoAuszug kontoAuszug;
    private Label lAnzeige;
    private ComboBox<String> cbKategorien;
    private TableView<Eintrag> tabelle;

    public AuszugTab(Konto konto) {
        this.konto = konto;
        kontoAuszug = konto.getKontoAuszug();
    }

    @Override
    public Tab getTab() {
        VBox box = new VBox(getMeldungenZeile(), getAuszugsZeile(), getAuszugOhneKategorieZeile(), getTabelle());
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        return new Tab("Auszüge", box);
    }

    private Node getAuszugsZeile() {
        Button bAuszugZeigen = new Button("Anzeigen");
        bAuszugZeigen.setOnAction(e -> {
            lAnzeige.setText("");
            if (cbKategorien.getSelectionModel().isEmpty()) {
                lAnzeige.setText("Wählen Sie eine Kategorie");
            } else {
                auszugAnzeigen(cbKategorien.getValue());
            }
        });

        Label lKategorien = new Label("Kategorie: ");
        cbKategorien = new ComboBox<>();
        cbKategorien.getItems().addAll("Kleidung", "Lebensmittel", "Auto",
                "Fast-Food", "Sport", "Miete", "Sonstiges");

        HBox hBox = new HBox(lKategorien, cbKategorien, bAuszugZeigen);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        return hBox;
    }

    private Node getAuszugOhneKategorieZeile() {
        Button bAlleAuszuegeZeigen = new Button("Alle Ausgaben anzeigen");
        bAlleAuszuegeZeigen.setOnAction(e -> {
            lAnzeige.setText("");
            auszugAnzeigen(null);
        });

        HBox hBox = new HBox(bAlleAuszuegeZeigen);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        return hBox;
    }

    private Node getMeldungenZeile() {
        lAnzeige = new Label("");
        lAnzeige.setTextFill(Color.RED);
        return lAnzeige;
    }

    private Node getTabelle() {
        tabelle = new TableView<>();
        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(tabelle);

        TableColumn<Eintrag, String> colDatum = new TableColumn<>();
        colDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        colDatum.setText("Datum");
        colDatum.setPrefWidth(80);

        TableColumn<Eintrag, String> colKategorie = new TableColumn<>();
        colKategorie.setCellValueFactory(new PropertyValueFactory<>("kategorie"));
        colKategorie.setText("Kategorie");
        colKategorie.setPrefWidth(100);

        TableColumn<Eintrag, String> colBetrag = new TableColumn<>();
        colBetrag.setCellValueFactory(new PropertyValueFactory<>("betrag"));
        colBetrag.setText("Betrag");
        colBetrag.setPrefWidth(80);

        tabelle.getColumns().addAll(colDatum, colKategorie, colBetrag);
        return scrolli;
    }

    private void auszugAnzeigen(String kategorie) {
        List<Eintrag> liste = kontoAuszug.getEintraege(kategorie);

        ObservableList<Eintrag> pw = FXCollections
                .observableArrayList(liste);
        tabelle.setItems(pw);
    }
}
