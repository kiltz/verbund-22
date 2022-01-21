package de.verbund.pwmanager;

import de.verbund.pwmanager.service.Manager;
import de.verbund.pwmanager.service.Passwort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PasswortManagerController implements Initializable {
    private Stage stage;
    final Stage neuerEintrag = new Stage();
    private List<String> kategorien;
    private ObservableList<Passwort> passwoerter;

    @FXML
    private TableView<Passwort> tvTabelle;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colBenutzername;
    @FXML
    private TableColumn colPasswort;

    @FXML
    private VBox vbButtonBox;
    Label lKategorie;
    Label lName;
    Label lBenutzername;
    Label lPasswort;
    Label lMeldung;
    TextField tfKategorie;
    TextField tfName;
    TextField tfPasswort;
    TextField tfBenutzername;
    TextField[] textFelder;
    Label[] labels;
    private Manager manager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBenutzername.setCellValueFactory(new PropertyValueFactory<>("benutzername"));
        colPasswort.setCellValueFactory(new PropertyValueFactory<>("passwort"));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void dateiOeffnen(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File tempDatei = fileChooser.showOpenDialog(PasswortManagerApp.getPrimaryStage());
        if (tempDatei != null) {
            if (manager != null) {
                manager.neueDateiOeffnen(tempDatei.getAbsolutePath());
            } else {
                manager = new Manager(tempDatei.getAbsolutePath());
            }
            kategorienFinden();
        }
    }

    private void kategorienFinden() {
        vbButtonBox.getChildren().clear();
        kategorien = manager.getKategorien();

        for (int i = 0; i < kategorien.size(); i++) {
            Button b = new Button(kategorien.get(i));
            b.setPrefWidth(200);
            b.setStyle("-fx-border-color:#CCD1D1; -fx-background-color:#F2F3F4;");
            b.setOnAction(event -> tabelleBefullen(b.getText(), b));
            vbButtonBox.getChildren().add(b);
        }
    }


    public void addEintrag(ActionEvent actionEvent) {
        if (manager != null) {
            neuerEintrag.initModality(Modality.NONE);

            lKategorie = new Label("Kategorie:");
            tfKategorie = new TextField();

            lName = new Label("Servicename:");
            tfName = new TextField();

            lBenutzername = new Label("Benutzername:");
            tfBenutzername = new TextField();

            lPasswort = new Label("Passwort:");
            tfPasswort = new TextField();

            lMeldung = new Label("");
            lMeldung.setTextFill(Color.RED);

            Button bSpeichern = new Button("Speichern");
            bSpeichern.setOnAction(e -> speichern());

            VBox vBox = new VBox(lKategorie, tfKategorie, lName, tfName, lBenutzername,
                    tfBenutzername, lPasswort, tfPasswort, bSpeichern, lMeldung);
            vBox.setPadding(new Insets(10));
            vBox.setSpacing(5);
            vBox.setAlignment(Pos.CENTER_LEFT);

            Scene dialogScene = new Scene(vBox, 200, 270);
            neuerEintrag.setScene(dialogScene);
            neuerEintrag.show();
        }
    }

    private void speichern() {
        textFelder = new TextField[]{tfKategorie, tfName, tfBenutzername, tfPasswort};
        labels = new Label[]{lKategorie, lName, lBenutzername, lPasswort};
        lMeldung.setText("");

        for (int i = 0; i < textFelder.length; i++) {
            if (textFelder[i].getText().length() <= 0) {
                labels[i].setTextFill(Color.RED);
                lMeldung.setText("Nicht alle Felder ausgefüllt");
            } else {
                labels[i].setTextFill(Color.BLACK);
            }
        }

        if (lMeldung.getText().equals("")) {
            manager.addPasswort(tfKategorie.getText(), tfName.getText(), tfBenutzername.getText(), tfPasswort.getText());
            kategorienFinden();
            neuerEintrag.close();
        }

    }

    public void tabelleBefullen(String kategorie, Button b) {
        for (Node n : vbButtonBox.getChildren()) {
            n.setStyle("-fx-border-color:#CCD1D1; -fx-background-color:#F2F3F4;");
        }
        b.setStyle("-fx-border-color:#797D7F; -fx-border-width: 0.5px;");
        passwoerter = FXCollections.observableArrayList(manager.suche(kategorie));
        tvTabelle.setItems(passwoerter);
    }


}
