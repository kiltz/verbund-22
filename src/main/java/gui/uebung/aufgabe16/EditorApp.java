package gui.uebung.aufgabe16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import utils.Datei;

import java.io.File;
import java.io.FileWriter;

public class EditorApp extends Application {
    private TextArea taTextEditor;
    private String datei;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(dateiEinlesen());
        root.setCenter(textEditor());
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
        TextField dateiPfad = new TextField();
        dateiPfad.setPromptText("Dateipfad:");
        Button bLesen = new Button("lesen");
        datei = dateiPfad.getText();
        dateiPfad.setFocusTraversable(false);
        bLesen.setFocusTraversable(true);
        node.getChildren().add(dateiLabel);
        node.getChildren().add(dateiPfad);
        node.getChildren().add(bLesen);
        bLesen.setOnAction(event -> Datei.lese());
        new Button("Lesen");
        return node;
    }

    private Node textEditor() {
        FlowPane node = new FlowPane();
        node.setAlignment(Pos.CENTER);
        taTextEditor = new TextArea("");
        node.getChildren().add(taTextEditor);
        return node;
    }

    private Node speichernBeenden() {
        FlowPane node = new FlowPane();
        Button bSave = new Button("Speichern");
        Button bEnd = new Button("Beenden");
        bSave.setOnAction(event -> speichern());
        bEnd.setOnAction(event -> System.exit(0));
        node.getChildren().add(bSave);
        node.getChildren().add(bEnd);
        node.setVgap(10);
        node.setHgap(10);
        node.setAlignment(Pos.BOTTOM_RIGHT);
        return node;
    }

    private void speichern() {
        File f = new File(String.format("%s"), datei);
        String absolute = f.getAbsolutePath();
        try (FileWriter fw = new FileWriter(absolute, false)) {
            fw.write(taTextEditor.getText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
