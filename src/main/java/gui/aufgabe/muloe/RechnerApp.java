package gui.aufgabe.muloe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
Aufgabe:
1. Kopiert die BasicApp nach RechnerApp
2. Erstellt zwei TextFelder, zwei Label und einen Button
    (TextField, Button)
    [.5.] + [.2.] (=) 7

Keine Funktionalität!
 */

public class RechnerApp extends Application {


    private Label lErgebnis;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField tfEins = new TextField("5");
        TextField tfZwei = new TextField("2");
        Button bGleich = new Button(" = ");
        bGleich.setDefaultButton(true);
        bGleich.setOnAction(e -> machWas(e));

        lErgebnis = new Label("7");
        Label lPlus = new Label(" + ");
        HBox root = new HBox();
        root.setSpacing(10);
        root.getChildren().addAll(tfEins, lPlus, tfZwei, bGleich, lErgebnis);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void machWas(ActionEvent e) {
        lErgebnis.setText("Bingo! ");
    }

}
