package de.kiltz.pwmanager.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;

public class PWMainController {
    @FXML
    private TabPane tabPane;

    public void doBeenden(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void doNeu(ActionEvent actionEvent) {
        zeige("Neue Passörter", "pwNeu.fxml");
    }

    public void doSuchen(ActionEvent actionEvent) {
        zeige("Suche Passörter", "pwSuche.fxml");
    }

    private void zeige(String titel, String fxmlDatei) {
        URL res = getClass().getResource("/fxml/pw/" + fxmlDatei);
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
