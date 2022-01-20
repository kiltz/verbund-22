package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Rechner extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Font myFont = new Font("Arial", 20);

        TextField tfEins = new TextField();
        tfEins.setPrefColumnCount(2);
        tfEins.setFont(myFont);

        Label l1 = new Label("+");
        l1.setFont(myFont);

        TextField tfZwei = new TextField();
        tfZwei.setPrefColumnCount(2);
        tfZwei.setFont(myFont);

        Label lErgebnis = new Label("= ?");
        lErgebnis.setFont(myFont);

        HBox hBox1 = new HBox();
        hBox1.getChildren().setAll(tfEins, l1, tfZwei, lErgebnis);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(5);


        Button bRechne = new Button();
        bRechne.setText("Rechnen");
        bRechne.setFont(myFont);
        bRechne.setDefaultButton(true);
        bRechne.setOnAction(event -> {
            try {
                int a = Integer.parseInt(tfEins.getText());
                int b = Integer.parseInt(tfZwei.getText());

                lErgebnis.setText(String.format("= %d", a + b));
            } catch (NumberFormatException ex) {
                tfEins.setText("");
                tfZwei.setText("");
                lErgebnis.setText("= ?");
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(hBox1, bRechne);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Scene scene = new Scene(root, 250, 200);

        primaryStage.setTitle("Coolste App");
        primaryStage.setScene(scene);
        primaryStage.show();

//        class ButtonClick implements ActionListener {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                try {
//                    int a = Integer.parseInt(tfEins.getText());
//                    int b = Integer.parseInt(tfZwei.getText());
//
//                    lErgebnis.setText(String.format("= %d", a + b));
//                } catch (NumberFormatException ex) {
//                    tfEins.setText("");
//                    tfZwei.setText("");
//                    lErgebnis.setText("= ?");
//                }
//            }
//        }
    }

}
