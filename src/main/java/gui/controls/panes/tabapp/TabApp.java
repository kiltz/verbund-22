package gui.controls.panes.tabapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class TabApp extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane root = new TabPane();
        RechnerTab rechnerTab = new RechnerTab();
        Tab tab = new Tab("Rechner", rechnerTab.getRechnerNodes());
        Tab tab2 = new Tab("Login"); // Tab noch mit einfügen --> neue Methode?
        tab.setClosable(true);
        root.getTabs().addAll(tab, tab2);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Einige Tabbies!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

