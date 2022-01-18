package gui.controls.panes.tabapp;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginTab {

    private TextField tfUserName;
    private TextField tfPassword;
    private Label eingabeErr = new Label("");

    private Node loginButton() {
        HBox box = new HBox();
        box.setSpacing(10);
        Button bLogin = new Button("Login");
        box.getChildren().addAll(bLogin);
        bLogin.setDefaultButton(true);
        tfUserName.setPromptText("Enter Username");
        tfPassword.setPromptText("Enter Password");
//        bLogin.setStyle("-fx-background-color: #dfdfdf; ");
        eingabeErr.setMaxHeight(200);
        box.getChildren().add(eingabeErr);
        bLogin.setOnAction(event -> buttonClicked());
        return box;

    }

    private Node buttonClicked() {
        VBox vBox = new VBox();
        eingabeErr.setText("");
        pruefeEingabe();
        return vBox;
    }

    private void pruefeEingabe() {
        eingabeErr.setStyle("-fx-text-fill: red;");
        if (tfUserName.getText().trim().isEmpty()) {
            eingabeErr.setText("Username can't be empty");
        } else if (tfPassword.getText().trim().isEmpty()) {
            eingabeErr.setText("Password can't be empty");
        } else if (tfPassword.getText().trim().length() < 4) {
            eingabeErr.setText("Password must be longer\nthen 4 characters");
        } else {
            eingabeErr.getStyleClass().clear();
            eingabeErr.setStyle(null);
            eingabeErr.setText("Logged in as: " + tfUserName.getText());
            tfUserName.clear();
            tfPassword.clear();
//            System.exit(0); // braucht timer
        }
    }


    private Node getUsernameAndPassword() {
        HBox hBox = new HBox();
        hBox.setSpacing(15);
        tfUserName = new TextField();
        tfUserName.setMaxWidth(120);
        tfUserName.setFocusTraversable(false);
        tfPassword = new PasswordField();
        tfPassword.setMaxWidth(120);
        tfPassword.setFocusTraversable(false);
        hBox.getChildren().add(tfUserName);
        hBox.getChildren().add(tfPassword);
        return hBox;
    }
}

