package utils;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.Map;

public class GuiComponents {

    public static Node setPasswortFieldElement() {
        HBox box = new HBox();
        box.getChildren().add(new PasswordField());
        box.setSpacing(10);
        return box;
    }

    public static Node setTextFieldElement(String[] promtTexte) {
        HBox box = new HBox();
        for (String promtText : promtTexte) {
            TextField t = new TextField();
            t.setPromptText(promtText);
            box.getChildren().add(t);
        }
        box.setSpacing(10);
        return box;
    }

    public static Node setRadioButtonElement(String[] namen) {
        HBox box = new HBox();
        ToggleGroup radiotoggleGroup = new ToggleGroup();
        for (String name : namen) {
            RadioButton r = new RadioButton(name);
            r.setToggleGroup(radiotoggleGroup);
            box.getChildren().add(r);
        }
        box.setSpacing(10);
        return box;
    }

    public static Node setCombo(Map<String, String[]> combos) {
        HBox box = new HBox();
        System.out.println(combos);
        for (Map.Entry<String, String[]> combo : combos.entrySet()) {
            ComboBox<String> cb = new ComboBox<>();
            cb.setPromptText(combo.getKey());
            for (String name : combo.getValue()) {
                cb.getItems().add(name);
            }
            box.getChildren().add(cb);
        }

        return box;
    }
}
