package gui.fxml;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class EditorController {
    public void beenden(ActionEvent actionEvent) {
        Platform.exit();
    }
}
