package de.verbund.pwmanager.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import utils.Datei;


public class PWManagerController /* implements Initializable */ {

    @FXML
    public TextField tfSearchbar;
    @FXML
    private ToggleButton bPWToggleVis;
    @FXML
    private TextField tfNewPassword;
    @FXML
    private Label textPassword;
    @FXML
    private TextField tfNewName;
    @FXML
    private TextField tfNewUser;
    @FXML
    private TextField tfNote;
    @FXML
    private TextArea taData;
    @FXML
    private Accordion acAccount;
    @FXML
    private Label cantBeNull;

    private String strSearch;
    private String name;
    private String user;
    private String password;
    private String note;

    public void doSave() {
        writeInTxt();
        System.out.println("It should save with this");
    }

    public void doCloseApp() {
        System.exit(0);
    }


    public void doSearch() {
        strSearch = tfSearchbar.getText();
        if (!strSearch.isEmpty()) {
            System.out.println("Searching: " + strSearch + "...");
        } else {
            System.out.println("Searching: nothing...");
        }
    }

    public void doTogglePWVis() {
        if (bPWToggleVis.isSelected()) {
            System.out.println("Toggle On");
            textPassword.setText(tfNewPassword.getText());
            tfNewPassword.setVisible(false);
        } else {
            System.out.println("Toggle Off");
            textPassword.setText(null);
            tfNewPassword.setVisible(true);
        }
    }

    public void doAddNewData() {
        name = tfNewName.getText();
        user = tfNewUser.getText();
        password = tfNewPassword.getText();
        note = tfNote.getText();
        if (!name.isEmpty() && !user.isEmpty() && !password.isEmpty()) {
            createNewTitledPane();
            tfNewName.clear();
            tfNewUser.clear();
            tfNewPassword.clear();
            tfNote.clear();
        } else {
            cantBeNull.setVisible(true);
        }
    }

    @FXML
    private void createNewTitledPane() {
        AnchorPane newPanelContent = new AnchorPane();
        newPanelContent.getChildren().add(new TextArea(String.format("%s \n%s \n%s \n%s", name, user, password, note)));
        TitledPane pane = new TitledPane(tfNewName.getText(), newPanelContent);
        pane.setMaxSize(441.0, 352.0);
        System.out.println(acAccount);
        acAccount.getPanes().add(pane);
        writeInTxt();
    }

    private void writeInTxt() {
        Datei.schreibe(String.format("%s \n%s \n%s \n%s", name, user, password, note));
    }
}

