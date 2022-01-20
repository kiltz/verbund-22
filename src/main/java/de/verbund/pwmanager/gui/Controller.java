package de.verbund.pwmanager.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author tz
 */
public class Controller {

    @FXML
    private Label lVersion;

    @FXML
    void initialize() {
        lVersion.setText("Version 0.2");
    }

}
