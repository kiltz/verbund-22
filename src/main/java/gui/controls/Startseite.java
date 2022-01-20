package gui.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Startseite extends Application {

    private Stage primaryStage;
    Kontaktformular kontaktformular;
    Statistik statistik;
    Login login;
    Font myFont = new Font("Arial", 25);
    Scene sStart;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        kontaktformular = new Kontaktformular(this);
        statistik = new Statistik(this);
        login = new Login(this);
        this.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    void show() {
        if (sStart == null) {
            Button bKontaktformular = new Button("Kontaktformular");
            bKontaktformular.setPrefSize(220, 30);
            bKontaktformular.setFont(myFont);
            bKontaktformular.setOnAction(event -> kontaktformular.show());

            Button bStatistik = new Button("Statistik");
            bStatistik.setPrefSize(220, 30);
            bStatistik.setFont(myFont);
            bStatistik.setOnAction(event -> statistik.show());

            Button bLogin = new Button("Login");
            bLogin.setPrefSize(220, 30);
            bLogin.setFont(myFont);
            bLogin.setOnAction(event -> login.show());

            VBox vbStart = new VBox(bKontaktformular, bStatistik, bLogin);
            vbStart.setPadding(new Insets(10));
            vbStart.setAlignment(Pos.CENTER);
            vbStart.setSpacing(10);

            sStart = new Scene(vbStart, 250, 220);
        }

        primaryStage.setTitle("Startseite");
        primaryStage.setScene(sStart);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
