package gui.uebung;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.muloe.Datei;

public class Editor extends Application {

    TextArea textArea;
    ComboBox<String> cbDateiOeffnen;
    Datei datei;
    Datei alleDateienNamen = new Datei("alleDateiNamen.txt");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setTop(erstelleOben());
        root.setCenter(erstelleMitte());
        root.setBottom(erstelleUnten());
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node erstelleOben() {
        cbDateiOeffnen = new ComboBox<>();
        String inhalt = alleDateienNamen.lese();
        String[] alleDateien = inhalt.split("\n");
        System.out.println(alleDateien[0]);
        for (String dateiNamen : alleDateien) {
            cbDateiOeffnen.getItems().add(dateiNamen);
        }
        cbDateiOeffnen.setOnAction(e -> lesen());
        TextField eingabeFeld = new TextField();
        Button bDateiAntragErstellen = new Button("Datei erstellen");
        bDateiAntragErstellen.setOnAction(e -> dateiAntragErstellen());
        Button bTextAuswaehlen = new Button("Einlesen");
        bTextAuswaehlen.setOnAction(e -> {
            textArea.setText(textArea.getText() + eingabeFeld.getText());
        });
        HBox box = new HBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(bDateiAntragErstellen, cbDateiOeffnen, eingabeFeld, bTextAuswaehlen);
        return box;
    }

    private void dateiAntragErstellen() {
        HBox box = new HBox();
        TextField eingabeDateiName = new TextField();
        Button bDateiErstellen = new Button("Erstellen");
        bDateiErstellen.setOnAction(e -> {
            alleDateienNamen.schreibe(eingabeDateiName.getText() + ".txt\n", true);
        });
        box.getChildren().addAll(eingabeDateiName, bDateiErstellen);
        Stage stage = new Stage();
        stage.setTitle("Datei erstellen");
        StackPane pane = new StackPane(box);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    private void lesen() {
        try {
            datei = new Datei(cbDateiOeffnen.getValue());
            String inhalt = datei.lese();
            textArea.setText(inhalt);
        } catch (Exception e) {

        }
    }

    private Node erstelleMitte() {
        textArea = new TextArea();
        textArea.setWrapText(true);
        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(textArea);
        scrolli.setFitToHeight(true);
        scrolli.setFitToWidth(true);
        return scrolli;
    }

    private Node erstelleUnten() {
        AnchorPane anchor = new AnchorPane();
        Button bSpeichern = new Button("Speichern");
        bSpeichern.setOnAction(e -> speichern(textArea.getText()));
        Button bAbbruch = new Button("Abbruch");
        bAbbruch.setOnAction(e -> {
            System.exit(0);
        });
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        buttons.getChildren().addAll(bAbbruch, bSpeichern);
        anchor.getChildren().add(buttons);
        AnchorPane.setRightAnchor(buttons, 10.0);
        AnchorPane.setBottomAnchor(buttons, 20.0);
        return anchor;
    }

    private void speichern(String text) {
        datei = new Datei(cbDateiOeffnen.getValue());
        datei.schreibe(text);
    }
}
