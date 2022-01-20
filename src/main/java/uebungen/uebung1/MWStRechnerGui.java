package uebungen.uebung1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.text.ParseException;

public class MWStRechnerGui extends Application {
    TextField tfBetrag;
    Label lErgebnis;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        tfBetrag = new TextField();
        tfBetrag.setMinWidth(80);

        Label lMWSt = new Label("19 %");
        lMWSt.setMinWidth(30);

        lErgebnis = new Label();
        lErgebnis.setMinWidth(60);

        Button bRechnen = new Button("=");
        bRechnen.setMinWidth(30);
        bRechnen.setAlignment(Pos.CENTER);
        bRechnen.setOnAction(event -> rechne());
        bRechnen.setDefaultButton(true);

        HBox root = new HBox(tfBetrag, lMWSt, bRechnen, lErgebnis);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 30, 10, 30));
        root.setSpacing(5);

        Scene scene = new Scene(root, 300, 50);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Mehrwertsteuerrechner");
        primaryStage.show();
    }

    private void rechne() {
        try {
            double WMSt = Zahlen.stringToDouble(tfBetrag.getText()) * 0.19;
            lErgebnis.setText(Zahlen.doubleToString(WMSt));
        } catch (ParseException e) {
            tfBetrag.setText("");
            lErgebnis.setText("");
        }
    }
}
