package gui.uebung;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.GuiComponents;

import java.time.Year;
import java.util.HashMap;

public class Kontaktliste {

    Button absendenButton;

    public Kontaktliste() {
        VBox root = new VBox();
        absendenButton = new Button("Absenden");
        absendenButton.setOnAction(e -> absenden(e));
        root.getChildren().add(GuiComponents.setRadioButtonElement(new String[]{"Herr", "Frau"}));
        root.getChildren().add(GuiComponents.setTextFieldElement(new String[]{"Vornamen eingeben"}));
        root.getChildren().add(GuiComponents.setTextFieldElement(new String[]{"Nachnamen eingeben"}));
        root.getChildren().add(GuiComponents.setTextFieldElement(new String[]{"E-Mail eingeben"}));
        String[] tage = new String[31];
        for (int i = 0; i < 31; i++) {
            tage[i] = String.valueOf(i + 1);
        }
        String[] monate = new String[]{"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
        String[] jahr = new String[150];
        for (int i = 0; i < 150; i++) {
            jahr[i] = String.valueOf(Year.now().getValue() - i);
        }
        root.getChildren().add(GuiComponents.setCombo(new HashMap<String, String[]>() {{
            put("Jahr", jahr);
            put("Monat", monate);
            put("Tag", tage);
        }}));
        root.getChildren().add(absendenButton);
        root.setSpacing(20);
        Stage stage = new Stage();
        stage.setTitle("Profil");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    private void absenden(ActionEvent e) {
        //noch zu tun
    }
}
