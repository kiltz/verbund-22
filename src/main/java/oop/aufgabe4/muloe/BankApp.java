package oop.aufgabe4.muloe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/*
Aufgabe:
1. Erweitere die BuchungTab mit Eingabefelder für die Betragseingabe und Einzahlen/Auszahlen
    und Anzeige des Kontostands

2. Erweiterung der BuchungTab durch setzen und Anzeigen des Dispo

3. Anzeige der Historie (Unterscheidung zwischen Einzahlung und Auszahlung) in der AuszugTab

 */
public class BankApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Konto konto = new Konto();
        TabPane root = new TabPane();
        List<BasisTab> tabs = new ArrayList<>();
        tabs.add(new BuchungTab(konto));
        tabs.add(new AuszugTab(konto));

        for (BasisTab tab : tabs) {
            root.getTabs().add(tab.getTab());
        }
        Scene scene = new Scene(root, 500, 350);
        primaryStage.setTitle("Bank Applikation");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
