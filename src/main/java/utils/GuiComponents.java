package utils;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Map;

public class GuiComponents {


    public static Node setTextFieldElementsVertikal(String[] promtTexte) {
        VBox box = new VBox();
        for (String promtText : promtTexte) {
            TextField t = new TextField();
            t.setPromptText(promtText);
            box.getChildren().add(t);
        }
        box.setSpacing(10);
        return box;
    }

    public static Node setTextFieldElementsHorizontal(String[] promtTexte) {
        HBox box = new HBox();
        for (String promtText : promtTexte) {
            TextField t = new TextField();
            t.setPromptText(promtText);
            box.getChildren().add(t);
        }
        box.setSpacing(10);
        return box;
    }

    public static Node kombinierenHorizontal(Node[] elem) {
        HBox box = new HBox();
        for (Node e : elem) {
            box.getChildren().add(e);
        }
        box.setSpacing(10);
        return box;
    }

    public static Node kombinierenVertikal(Node[] elem) {
        VBox box = new VBox();
        for (Node e : elem) {
            box.getChildren().add(e);
        }
        box.setSpacing(10);
        return box;
    }

    public static Node setLabelElementsHorizontal(String[] texte, int spacing) {
        HBox box = new HBox();
        for (String text : texte) {
            box.getChildren().add(new Label(text));
        }
        box.setSpacing(spacing);
        return box;
    }

    public static Node setLabelElementsVertikal(String[] texte) {
        VBox box = new VBox();
        for (String text : texte) {
            box.getChildren().add(new Label(text));
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
