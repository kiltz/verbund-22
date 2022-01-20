package de.verbund.pwmanager;

import de.verbund.pwmanager.service.Manager;
import de.verbund.pwmanager.service.Passwort;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PasswortManagerController implements Initializable {
    private Stage stage;
    private Manager manager = new Manager("src/main/java/de/verbund/pwmanager/datenbankTest.txt");
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
            manager.neueDateiOeffnen(tempDatei.getAbsolutePath());
            kategorien = manager.getKategorien();

            for (int i = 0; i < kategorien.size(); i++) {
                Button b = new Button(kategorien.get(i));

                b.setPrefWidth(200);
                b.setOnAction(event -> tabelleBefullen(b.getText()));
                vbButtonBox.getChildren().add(b);
            }
        }
    }


    public void dateiSpeichern(ActionEvent actionEvent) {
    }

    public void dateiSchliessen(ActionEvent actionEvent) {
    }

    public void tabelleBefullen(String kategorie) {
        passwoerter = FXCollections.observableArrayList(manager.suche(kategorie));
        tvTabelle.setItems(passwoerter);
    }


}
