package gui.controls.panes.mueloe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class TabAufgabeApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TabPane root = new TabPane();
        // ein Tab
        RechnerTab rechnerTab = new RechnerTab();
        Tab tab = new Tab("Rechner", rechnerTab.getRechnerNodes());
        tab.setClosable(true);
        root.getTabs().add(tab);
        // noch ein Tab

        //...

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Einige Tabbies!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
