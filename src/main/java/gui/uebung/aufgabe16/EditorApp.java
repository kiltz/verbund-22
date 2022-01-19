package gui.uebung.aufgabe16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import utils.Datei;

import java.io.File;
import java.io.FileWriter;

public class EditorApp extends Application {
    private TextArea taTextEditor;
    private String dateiName;
    private String dateiPfad;
    private TextField dateiPfadName;
    private Button bSave;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(dateiEinlesen());
        root.setCenter(getTextFromArea());
        root.setBottom(speichernBeenden());
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Node dateiEinlesen() {
        FlowPane node = new FlowPane();
        node.setAlignment(Pos.CENTER);
        node.setVgap(20);
        node.setHgap(20);
        Label dateiLabel = new Label("Datei");
        dateiPfadName = new TextField();
        dateiPfadName.setPromptText("Dateipfad:");
        Button bLesen = new Button("lesen");
        dateiName = dateiPfadName.getText();
        dateiPfadName.setFocusTraversable(false);
        bLesen.setFocusTraversable(true);
        node.getChildren().add(dateiLabel);
        node.getChildren().add(dateiPfadName);
        node.getChildren().add(bLesen);
        bLesen.setOnAction(event -> Datei.lese());
        new Button("Lesen");
        return node;
    }

    private Node getTextFromArea() {
        FlowPane node = new FlowPane();
        node.setAlignment(Pos.CENTER);
        taTextEditor = new TextArea("");
        ScrollPane scrolli = new ScrollPane();
        scrolli.setContent(taTextEditor);
        scrolli.setPadding(new Insets(20));
        scrolli.setFitToHeight(true);
        scrolli.setFitToWidth(true);
        return scrolli;
    }

    private Node speichernBeenden() {
        FlowPane node = new FlowPane();
        bSave = new Button("Speichern");
        Button bEnd = new Button("Beenden");
        bSave.setOnAction(event -> speichern());
        bEnd.setOnAction(event -> System.exit(0));
        // wenn nach speichern, text in file == text in scrolli -->
        // Button text = "Gespeichert"
        // wenn text geändert wird --> Button text = "Speichern"
        node.getChildren().add(bSave);
        node.getChildren().add(bEnd);
        node.setVgap(10);
        node.setHgap(10);
        node.setAlignment(Pos.BOTTOM_RIGHT);
        return node;
    }

    private void speichern() {
        File f = new File(String.format("\"C:\\%s.txt"), dateiName);
        dateiPfad = f.getAbsolutePath();
        try {
            if (dateiPfad.length() >= 0) {
                dateiPfadName.setText(dateiPfad);
            }
        } catch (Exception e) {
            System.out.println("Noch nichts eingegeben");
        }
        try (FileWriter fw = new FileWriter(dateiPfad, false)) {
            fw.write(taTextEditor.getText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
