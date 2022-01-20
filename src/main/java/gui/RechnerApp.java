package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.Zahlen;

import java.text.ParseException;

public class RechnerApp extends Application {

    private Label lErg;
    private Label lPlus;
    private TextField summand1;
    private Button rechnerButton;
    private TextField summand2;


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        TabPane root = new TabPane();
//
//        StatisitkApp statistikApp = new StatisitkApp();
////        Tab tab1 = new Tab("StatistikApp", statistikApp.getStatistikApp());
//        Tab tab2 = new Tab("RechnerApp", getRechnerApp());
//        tab1.setClosable(true);
//        tab2.setClosable(true);
//        root.getTabs().addAll(tab1, tab2);
//        Scene scene = new Scene(root, 550, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    private Node getRechnerApp() {
        lErg = new Label("Ergebnis");
        lPlus = new Label("+");
        summand1 = new TextField();
        rechnerButton = new Button("=");
        summand2 = new TextField();
        summand1.setMaxWidth(50);
        summand2.setMaxWidth(50);
        rechnerButton.setOnAction(e -> rechne(e));
        HBox app = new HBox();
        Insets insets = new Insets(20, 10, 20, 10);
        app.setSpacing(10);
        app.setPadding(insets);
        app.getChildren().addAll(summand1, lPlus, summand2, rechnerButton, lErg);
        return app;
    }

    private void rechne(ActionEvent e) {
        try {
            double zahl1 = Zahlen.stringToDouble(summand1.getText());
            double zahl2 = Zahlen.stringToDouble(summand2.getText());
            double erg = zahl1 + zahl2;
            lErg.setText(Zahlen.doubleToString(erg));
            summand1.requestFocus();
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
