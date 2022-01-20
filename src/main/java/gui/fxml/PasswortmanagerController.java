package gui.fxml;

import de.verbund.pwmanager.service.Manager;
import de.verbund.pwmanager.service.Passwort;
import de.verbund.pwmanager.utils.Datei;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class PasswortmanagerController {

    @FXML
    public TextField tfSuche;
    @FXML
    public TextField tfName;
    @FXML
    public TextField tfBenutzername;
    @FXML
    public TextField tfPasswort;
    @FXML
    public TableView<Passwort> tabelle;
    @FXML
    public TableColumn<Passwort, String> nameCol;
    @FXML
    public TableColumn<Passwort, String> benutzerCol;
    @FXML
    public TableColumn<Passwort, String> passwortCol;
    Datei datei = new Datei("passwd.txt");

    @FXML
    void initialize() {
        Manager manager = new Manager();
        ArrayList<Passwort> tabelleInfos = manager.lese();
        tabelleFüllen(tabelleInfos);
    }

    public void tabelleFüllen(ArrayList<Passwort> eintraege) {
        ObservableList<Passwort> pw = FXCollections.observableArrayList(eintraege);
        tabelle.setItems(pw);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        benutzerCol.setCellValueFactory(new PropertyValueFactory<>("benutzername"));
        passwortCol.setCellValueFactory(new PropertyValueFactory<>("passwort"));
    }

    public void erstellePasswort() {

    }
}
