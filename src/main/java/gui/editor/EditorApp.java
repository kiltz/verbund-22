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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.Optional;


public class EditorApp extends Application {
    private TextArea taText;
    private Label lPfad;
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
        Node text = getTextArea();
        Node buttons = getButtons();

        BorderPane root = new BorderPane();
        root.setTop(suche);
        root.setBottom(buttons);
        root.setCenter(text);

        Scene scene = new Scene(root, 800, 700);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::appSchliessen);
    }

    private Node getButtons() {
        Button bSpeichern = new Button("Speichern");
        bSpeichern.setOnAction(e -> speichern());
        Button bBeenden = new Button("Beenden");
        bBeenden.setOnAction(e -> appSchliessen(null));
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

        } catch (NullPointerException e) {
            Alert meldung = new Alert(Alert.AlertType.INFORMATION);
            meldung.setHeaderText("");
            meldung.setContentText("Sie haben noch keine Datei geöffnet.");
            meldung.initOwner(primaryStage.getOwner());
            Optional<ButtonType> res = meldung.showAndWait();
        }

    }

    private Node getTextArea() {
        taText = new TextArea("");
        taText.setVisible(false);

        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(taText);
        scrolli.setPadding(new Insets(5));
        scrolli.setFitToHeight(true);
        scrolli.setFitToWidth(true);

        return scrolli;
    }

    private Node getSuche() {
        Label lDatei = new Label("Datei:");
        lPfad = new Label("");
        lPfad.setPrefWidth(250);
        lPfad.setPrefHeight(23);
        lPfad.setStyle("-fx-border-color: black; -fx-background-color: white;");
        Button bOeffnen = new Button("Öffnen");
        bOeffnen.setOnAction(e -> dateiWaehlen());

        HBox hBox = new HBox(lDatei, lPfad, bOeffnen);
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
            lPfad.setText(" " + datei.getAbsolutePath());
            taText.setVisible(true);
        } catch (NullPointerException | IOException ignore) {
        }
    }

    private void appSchliessen(WindowEvent event) {
        if (datei == null) {
            Platform.exit();
            System.exit(0);
        } else {
            Alert meldung = new Alert(Alert.AlertType.INFORMATION);
            meldung.getButtonTypes().remove(ButtonType.OK);
            meldung.getButtonTypes().add(ButtonType.CANCEL);
            meldung.getButtonTypes().add(ButtonType.YES);
            meldung.setHeaderText("");
            meldung.setContentText("Wollen Sie die Datei wirklich schließen?");
            meldung.initOwner(primaryStage.getOwner());
            Optional<ButtonType> res = meldung.showAndWait();

            if (res.isPresent()) {
                if (res.get().equals(ButtonType.CANCEL) && event != null) {
                    event.consume();
                } else if (res.get().equals(ButtonType.YES)) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        }

    }
}
