package gui.editor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;


public class EditorApp extends Application {
    private TextArea taText;
    private TextField tfPfad;
    private Stage primaryStage;
    private FileChooser fileChooser = new FileChooser();
    private File datei;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        Node suche = getSuche();
        Node text = getTextfeld();
        Node buttons = getButtons();

        BorderPane root = new BorderPane();
        root.setTop(suche);
        root.setBottom(buttons);
        root.setCenter(text);

        Scene scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node getButtons() {
        Button bSpeichern = new Button("Speichern");
        bSpeichern.setOnAction(e -> speichern());
        Button bBeenden = new Button("Beenden");
        bBeenden.setOnAction(e -> appSchliessen());
        HBox hBox = new HBox(bSpeichern, bBeenden);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setPadding(new Insets(10));

        return hBox;
    }

    private void speichern() {
        try (FileWriter fw = new FileWriter(datei.getAbsolutePath(), false)) {
            fw.write(taText.getText());
        } catch (IOException ignore) {
        }
    }

    private Node getTextfeld() {
        taText = new TextArea("");
        taText.setPrefWidth(480);
        taText.setPrefHeight(350);


        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(taText);
        scrolli.setPadding(new Insets(10));

        return scrolli;
    }

    private Node getSuche() {
        Label lDatei = new Label("Datei:");
        tfPfad = new TextField("");
        tfPfad.setPrefWidth(250);
        Button bOeffnen = new Button("Öffnen");
        bOeffnen.setOnAction(e -> dateiWaehlen());

        HBox hBox = new HBox(lDatei, tfPfad, bOeffnen);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        return hBox;
    }

    private void dateiWaehlen() {
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        datei = fileChooser.showOpenDialog(primaryStage);

        try (BufferedReader br = new BufferedReader(new FileReader(datei))) {
            StringBuilder tempDatei = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                tempDatei.append(line);
                tempDatei.append("\n");
            }

            taText.setText(tempDatei.toString());
            tfPfad.setText(datei.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void appSchliessen() {
        final Stage antwort = new Stage();
        antwort.initModality(Modality.NONE);
        antwort.initStyle(StageStyle.UNDECORATED);

        Label lSchliessen = new Label("Wollen Sie die Datei wirklich schließen?");

        Button bJa = new Button("Ja");
        bJa.setOnAction(e -> {
            Platform.exit();
            System.exit(0);
        });
        Button bNein = new Button("Nein");
        bNein.setOnAction(e -> antwort.close());
        HBox hBox = new HBox(bJa, bNein);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(lSchliessen, hBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        Scene sSchliessen = new Scene(vBox, 220, 80);
        antwort.setScene(sSchliessen);
        antwort.show();
    }
}
