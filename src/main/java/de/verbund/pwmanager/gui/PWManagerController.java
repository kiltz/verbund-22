package de.verbund.pwmanager.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;


public class PWManagerController {

    private String strSearch;
    @FXML
    public TextField tfSearchbar;
    @FXML
    private ToggleButton bPWToggleVis;
    @FXML
    private TextField tfNewPassword;
    @FXML
    private Label textPassword;

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
}
