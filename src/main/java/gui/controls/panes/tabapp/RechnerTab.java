package gui.controls.panes.tabapp;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import utils.Zahlen;

import java.text.ParseException;

public class RechnerTab {
    private TextField tfEins;
    private TextField tfZwei;
    private Label lErgebnis;

    public Node getRechnerNodes() {
        lErgebnis = new Label();
        Label lPlus = new Label(" + ");
        tfEins = new TextField();
        tfEins.setMaxWidth(50);
        tfZwei = new TextField();
        tfZwei.setMaxWidth(50);
        tfEins.setPromptText("Zahl1");
        tfZwei.setPromptText("Zahl2");
        tfEins.setFocusTraversable(false);
        tfZwei.setFocusTraversable(false);
        Button bRechne = new Button(" = ");
        bRechne.setDefaultButton(true);
        bRechne.setOnAction(e -> rechne(e));

        HBox root = new HBox();
        root.setSpacing(10);
        Insets insets = new Insets(20, 10, 20, 10);
        root.setPadding(insets);
        root.getChildren().addAll(tfEins, lPlus, tfZwei, bRechne, lErgebnis);

        return root;
    }

    private void rechne(ActionEvent e) {
        // 1. Textfelder auslesen
        String textEins = tfEins.getText();
        String textZwei = tfZwei.getText();
        try {
            double zahlEins = Zahlen.stringToDouble(textEins);
            double zahlZwei = Zahlen.stringToDouble(textZwei);
            double ergebnis = zahlEins + zahlZwei;
            lErgebnis.setText(Zahlen.doubleToString(ergebnis));
        } catch (ParseException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
