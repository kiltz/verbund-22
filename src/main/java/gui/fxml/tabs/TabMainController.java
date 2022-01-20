package gui.fxml.tabs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;

public class TabMainController {
    @FXML
    private TabPane tabPane;

    public void doBeenden(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void doTab1(ActionEvent actionEvent) {
        zeige("Tab 1", "tab1.fxml");
    }


    public void doTab2(ActionEvent actionEvent) {
        zeige("Tab 2", "tab2.fxml");
    }

    private void zeige(String titel, String fxmlDatei) {
        URL res = getClass().getResource(fxmlDatei);
        try {
            Parent tabFxml = FXMLLoader.load(res);
            Tab tab = new Tab(titel, tabFxml);
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
