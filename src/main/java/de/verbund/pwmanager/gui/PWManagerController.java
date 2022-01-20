package de.verbund.pwmanager.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class PWManagerController {

    @FXML
    public TextField tfSearchbar;
    private String strSearch;

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
}
