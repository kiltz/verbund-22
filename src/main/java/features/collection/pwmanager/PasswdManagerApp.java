package features.collection.pwmanager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.GuiComponents;

import java.util.List;

public class PasswdManagerApp extends Application {
    private static final String BLAU = "#005091";
    private static final String  ROT = "#E23130";

    private Manager manager;
    private TextField tfName;
    private TextField tfBenutzerName;
    private TextField tfPasswort;
    private Label lStatus;
    private TextField tfSuche;
    private TextArea taErgebnis;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene((Parent) getRoot(), 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Passwort-Manager");
        primaryStage.show();
    }

    public Node getRoot() {
        manager = new Manager();
        BorderPane root = new BorderPane();
        HBox passwortEingabe = new HBox();
        root.setTop(getSuchZeile());
        root.setCenter(GuiComponents.kombinierenVertikal(new Node[]{passwortEingabe, getEintragenZeile()}));
        root.setBottom(getSuchErgebnisZeile());
        passwortEingabe.getChildren().addAll(getNameZeile(), getBenutzerNameZeile(), getPasswdZeile());
        return root;
    }

    private Node getSuchErgebnisZeile() {
        HBox box = new HBox(15);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER_RIGHT);
        taErgebnis = new TextArea();
        box.getChildren().add(taErgebnis);
        return box;
    }

    private Node getSuchZeile() {
        HBox box = new HBox(15);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        tfSuche = new TextField();
        Button bSuche = new Button("Suche");
        bSuche.setOnAction(e -> suche());
        bSuche.setDefaultButton(true);
        box.getChildren().addAll(tfSuche, bSuche);
        return box;
    }

    private void suche() {
        List<Passwort> erg = manager.suche(tfSuche.getText());
        StringBuffer txt = new StringBuffer("Name\tBenutzer\tPasswort\n");
        for (Passwort p : erg) {
            txt.append(p.getName()+"\t"+p.getBenutzername()+"\t"+p.getPasswort()+"\n");
        }
        taErgebnis.setText(txt.toString());
    }

    private Node getEintragenZeile() {
        HBox box = new HBox(15);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER_RIGHT);
        Button bEintragen = new Button("Eintragen");
        bEintragen.setOnAction(e -> eintragen());
        lStatus = new Label();
        box.getChildren().addAll(lStatus, bEintragen);
        return box;
    }

    private void eintragen() {
        // TODO Validate
        if (tfName.getText().isEmpty()) {
            lStatus.setTextFill(Color.web(ROT));
            lStatus.setText("Wen soll ich eintragen?");
        } else {
            try {
                manager.neu(new Passwort(tfName.getText(), tfBenutzerName.getText(), tfPasswort.getText()));
                lStatus.setTextFill(Color.web(BLAU));
                lStatus.setText(tfName.getText()+" wurde eingetragen.");
                tfName.setText("");
                tfBenutzerName.setText("");
                tfPasswort.setText("");
            } catch (Exception e) {
                lStatus.setTextFill(Color.web(ROT));
                lStatus.setText("Fehler: "+e.getMessage());
            }
        }
    }

    private Node getPasswdZeile() {
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        tfPasswort = new TextField();

        box.getChildren().addAll(new Label("Passwort:"), tfPasswort);
        return box;
    }

    private Node getBenutzerNameZeile() {
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        tfBenutzerName = new TextField();

        box.getChildren().addAll(new Label("Benutzer:"), tfBenutzerName);
        return box;
    }

    private Node getNameZeile() {
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        tfName = new TextField();

        box.getChildren().addAll(new Label("Name:"), tfName);
        return box;
    }
}