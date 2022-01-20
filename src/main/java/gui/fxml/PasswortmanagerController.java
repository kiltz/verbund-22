package gui.fxml;

import de.verbund.pwmanager.service.Manager;
import de.verbund.pwmanager.service.Passwort;
import de.verbund.pwmanager.utils.Datei;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



public class PasswortmanagerController {

    Datei datei = new Datei("passwd.txt");

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
    public TableColumn<Passwort, String> benutzernameCol;
    @FXML
    public TableColumn<Passwort, String> passwortCol;

    }

    public void initialize() {
        Manager manager = new Manager();
        ArrayList<Passwort> tabelleInfos = manager.lese();
        tabellefüllen();
    }
}
