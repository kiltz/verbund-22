package de.verbund.pwmanager.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PWManagerController /* implements Initializable */ {

    private String strSearch;
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

    public void doSave() {
        System.out.println("It should save with this");
    }

    public void doCloseApp() {
        System.exit(0);
    }


    public void doSearch() {
        strSearch = tfSearchbar.getText();
        if (strSearch.isEmpty()) {
            System.out.println("Searching: " + strSearch + "...");
        } else {
            System.out.println("Searching: nothing...");
        }
    }

    public void doTogglePWVis() {
        boolean isSelected = bPWToggleVis.isSelected();
        if (isSelected) {
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
        acAccount.setVisible(true);
        taData.setText(String.format("%s \n%s \n%s \n%s", tfNewName.getText(), tfNewUser.getText(), tfNewPassword.getText(), tfNote.getText()));
        tfNewName.clear();
        tfNewUser.clear();
        tfNewPassword.clear();
        tfNote.clear();
    }
    /*
    public void doAddNewData() {
        TODO
    }
     */
}
