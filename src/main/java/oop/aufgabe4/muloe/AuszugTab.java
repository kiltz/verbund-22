package oop.aufgabe4.muloe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class AuszugTab extends BasisTab {
    private final Konto konto;
    TableView<Buchung> tabelle;

    public AuszugTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        BorderPane root = new BorderPane();
        root.setTop(getSuchLeiste());
        root.setCenter(getTabelle());
        Tab tab = new Tab("Auszüge", root);
        return tab;
    }

    private Node getSuchLeiste() {
        HBox box = new HBox(15);
        box.setPadding(new Insets(10));
        Button bAktualisieren = new Button("Aktualisieren");
        bAktualisieren.setOnAction(e -> aktualisieren());
        bAktualisieren.setDefaultButton(true);
        box.getChildren().addAll(bAktualisieren);
        return box;
    }

    private void aktualisieren() {
        ObservableList<Buchung> buchungen = FXCollections
                .observableArrayList(konto.getBuchungen());
        tabelle.setItems(buchungen);
    }

    public Node getTabelle() {
        tabelle = new TableView<Buchung>();
        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(tabelle);

        TableColumn<Buchung, String> artCol = new TableColumn<>();
        artCol.setCellValueFactory(new PropertyValueFactory<>("buchungArt"));
        artCol.setText("Buchungsart");
        artCol.setPrefWidth(120);

        TableColumn<Buchung, String> datumCol = new TableColumn<>();
        datumCol.setCellValueFactory(new PropertyValueFactory<>("datum"));
        datumCol.setText("Datum");
        datumCol.setPrefWidth(150);

        TableColumn<Buchung, String> betragCol = new TableColumn<>();
        betragCol.setCellValueFactory(new PropertyValueFactory<>("betrag"));
        betragCol.setText("Betrag");
        betragCol.setPrefWidth(100);

        tabelle.getColumns().addAll(artCol, datumCol, betragCol);
        return scrolli;
    }
}
