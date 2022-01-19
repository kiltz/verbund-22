package gui.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EditorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label l_datei = new Label("Datei");
        TextField tf_dateiname = new TextField();
        tf_dateiname.setPromptText("Dateiname");
        TextArea ta_dateiliste = new TextArea("");
        Button b_lesen = new Button("Lesen");
        Button b_speichern = new Button("Speichern");
        Button b_beenden = new Button("beenden");

        /*
        b_lesen.setOnAction(event -> {
        in tf_dateiname eingegebenes soll in ta_dateiliste aufgeführt werden
        });

        b_speichern.setOnAction(event -> {
        Elemente der ta_dateiliste sollen in einem anderen Textdokument gespeichert/überschrieben werden
        }

        b_beenden.setOnAction(event -> {
        Fenster soll geschlossen werden
        platformexit()
        }
        */

        FlowPane fp_oberenbereich = new FlowPane();
        fp_oberenbereich.setAlignment(Pos.CENTER);
        fp_oberenbereich.setHgap(10);
        fp_oberenbereich.getChildren().addAll(l_datei, tf_dateiname, b_lesen);

        AnchorPane ap_unterenbereich = new AnchorPane();
        HBox hb_box2 = new HBox();
        hb_box2.setSpacing(10);
        hb_box2.getChildren().addAll(b_speichern, b_beenden);
        ap_unterenbereich.getChildren().add(hb_box2);
        AnchorPane.setRightAnchor(hb_box2, 10.0);
        AnchorPane.setBottomAnchor(hb_box2, 10.0);
        AnchorPane.setTopAnchor(hb_box2, 10.0);

        ScrollPane sp_auflistung = new ScrollPane(ta_dateiliste);
        ta_dateiliste.setPadding(new Insets(15, 15, 15, 15));
        sp_auflistung.setFitToWidth(true);
        sp_auflistung.setFitToHeight(true);
        sp_auflistung.setHbarPolicy((ScrollPane.ScrollBarPolicy.ALWAYS));
        sp_auflistung.setVbarPolicy((ScrollPane.ScrollBarPolicy.ALWAYS));

        BorderPane bp_root = new BorderPane();
        bp_root.setBottom(ap_unterenbereich);
        bp_root.setTop(fp_oberenbereich);
        bp_root.setCenter(ta_dateiliste);

        Scene scene = new Scene(bp_root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
