package features.collection.pwmanager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PasswdManagerApp extends Application {
    private static final String BLAU = "#005091";
    private static final String ROT = "#E23130";

    private Manager manager;
    private TextField tfName;
    private TextField tfBenutzerName;
    private Label lStatus;
    private TextField tfSuche;
    private TextArea taErgebnis;

    private Label lName = new Label("Name:");
    private Label lBenutzerName = new Label("Benutzer:");

    private PasswordField pfPasswort;
    private TextField tfPasswort = new TextField("");
    private PasswordField pfPasswortWiederholen;
    private TextField tfPasswortWiederholen = new TextField("");
    private CheckBox bxAnzeigen = new CheckBox();

    private Label lPasswort = new Label("Passwort:");
    private Label lPasswortAnzeigen = new Label("Passwörter anzeigen:");
    private Label lPasswortWiederholen = new Label("Passwort wiederholen:");


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        manager = new Manager();
        VBox root = new VBox(15);
        root.getChildren().add(getNameZeile());
        root.getChildren().add(getBenutzerNameZeile());
        root.getChildren().add(getPasswdZeile());
        root.getChildren().add(getPasswdWiedeholenZeile());
        root.getChildren().add(getPasswdAnzeigenZeile());
        root.getChildren().add(getEintragenZeile());
        root.getChildren().add(getSuchZeile());
        root.getChildren().add(getSuchErgebnisZeile());

        root.setPadding(new Insets(10, 0, 10, 0));

        Scene scene = new Scene(root, 300, 550);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Passwort-Manager");
        primaryStage.setResizable(false);
        primaryStage.show();
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
        if (!alleFelderAusgefuellt()) {
            lStatus.setTextFill(Color.web(ROT));
            lStatus.setText("Nicht alle Felder ausgefüllt!");
            return;
        }

        if (!passwoerterSindGleich()) {
            lStatus.setTextFill(Color.web(ROT));
            lStatus.setText("Passwörter stimmen nicht überein!");
            return;
        }

        try {
            manager.neu(new Passwort(tfName.getText(), tfBenutzerName.getText(), pfPasswort.getText()));
            lStatus.setTextFill(Color.web(BLAU));
            lStatus.setText(tfName.getText() + " wurde eingetragen.");
            tfName.setText("");
            tfBenutzerName.setText("");
            pfPasswort.setText("");
        } catch (Exception e) {
            lStatus.setTextFill(Color.web(ROT));
            lStatus.setText("Fehler: " + e.getMessage());
        }
    }

    private boolean passwoerterSindGleich() {
        if (bxAnzeigen.isSelected()) {
            pfPasswort.setText(tfPasswort.getText());
            pfPasswortWiederholen.setText(tfPasswortWiederholen.getText());
        }
        return pfPasswort.getText().equals(pfPasswortWiederholen.getText());
    }

    private boolean alleFelderAusgefuellt() {
        boolean check = true;
        Predicate<Map.Entry<TextField, Label>> isEmpty = feld -> feld.getKey().getText().length() <= 0;

        if (bxAnzeigen.isSelected()) {
            pfPasswort.setText(tfPasswort.getText());
            pfPasswortWiederholen.setText(tfPasswortWiederholen.getText());
        }

        Map<TextField, Label> felder = new HashMap<>();
        felder.put(tfName, lName);
        felder.put(tfBenutzerName, lBenutzerName);
        felder.put(pfPasswort, lPasswort);
        felder.put(pfPasswortWiederholen, lPasswortWiederholen);

        for (Map.Entry<TextField, Label> feld : felder.entrySet()) {
            if (!isEmpty.test(feld)) {
                feld.getValue().setTextFill(Color.BLACK);
            } else {
                feld.getValue().setTextFill(Color.RED);
                check = false;
            }
        }

        return check;
    }

    private Node getPasswdZeile() {
        VBox box = new VBox(5);
        box.setPadding(new Insets(0, 10, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);
        pfPasswort = new PasswordField();
        pfPasswort.setPrefWidth(290);
        tfPasswort.setPrefWidth(290);
        tfPasswort.setVisible(false);
        Group group = new Group(tfPasswort, pfPasswort);

        box.getChildren().addAll(lPasswort, group);
        return box;
    }

    private Node getPasswdWiedeholenZeile() {
        VBox box = new VBox(5);
        box.setPadding(new Insets(0, 10, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);
        pfPasswortWiederholen = new PasswordField();
        pfPasswortWiederholen.setPrefWidth(290);
        tfPasswortWiederholen.setPrefWidth(290);
        tfPasswortWiederholen.setVisible(false);

        box.getChildren().addAll(lPasswortWiederholen, new Group(tfPasswortWiederholen, pfPasswortWiederholen));
        return box;
    }

    private Node getPasswdAnzeigenZeile() {
        bxAnzeigen.setOnAction(press -> passwortAnzeigen());
        HBox box = new HBox(lPasswortAnzeigen, bxAnzeigen);
        box.setSpacing(5);
        box.setPadding(new Insets(-10, 10, 0, 10));
        box.setAlignment(Pos.CENTER_RIGHT);
        return box;
    }

    private Node getBenutzerNameZeile() {
        VBox box = new VBox(5);
        box.setPadding(new Insets(0, 10, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);
        tfBenutzerName = new TextField();
        tfBenutzerName.setPrefWidth(220);

        box.getChildren().addAll(lBenutzerName, tfBenutzerName);
        return box;
    }

    private Node getNameZeile() {
        VBox box = new VBox(5);
        box.setPadding(new Insets(0, 10, 0, 10));
        box.setAlignment(Pos.CENTER_LEFT);
        tfName = new TextField();
        tfName.setPrefWidth(220);

        box.getChildren().addAll(lName, tfName);
        return box;
    }

    private void passwortAnzeigen() {
        if (bxAnzeigen.isSelected()) {
            tfPasswort.setText(pfPasswort.getText());
            tfPasswort.setVisible(true);
            pfPasswort.setVisible(false);

            tfPasswortWiederholen.setText(pfPasswortWiederholen.getText());
            tfPasswortWiederholen.setVisible(true);
            pfPasswortWiederholen.setVisible(false);
        } else {
            pfPasswort.setText(tfPasswort.getText());
            pfPasswort.setVisible(true);
            tfPasswort.setVisible(false);

            pfPasswortWiederholen.setText(tfPasswortWiederholen.getText());
            pfPasswortWiederholen.setVisible(true);
            tfPasswortWiederholen.setVisible(false);
        }
    }
}