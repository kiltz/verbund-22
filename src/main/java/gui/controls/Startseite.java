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

    public Startseite() {
    }

    public Startseite(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Startseite startseite = new Startseite(primaryStage);
        startseite.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    void show() {
        Kontaktformular kontaktformular = new Kontaktformular(this);
        Statistik statistik = new Statistik(this);
        Login login = new Login(this);

        Font myFont = new Font("Arial", 25);

        Button bKontaktformular = new Button("Kontaktformular");
        bKontaktformular.setPrefSize(215, 30);
        bKontaktformular.setFont(myFont);
        bKontaktformular.setOnAction(event -> kontaktformular.show());

        Button bStatistik = new Button("Statistik");
        bStatistik.setPrefSize(215, 30);
        bStatistik.setFont(myFont);
        bStatistik.setOnAction(event -> statistik.show());

        Button bLogin = new Button("Login");
        bLogin.setPrefSize(215, 30);
        bLogin.setFont(myFont);
        bLogin.setOnAction(event -> login.show());

        VBox vbStart = new VBox(bKontaktformular, bStatistik, bLogin);
        vbStart.setPadding(new Insets(10, 10, 10, 10));
        vbStart.setAlignment(Pos.CENTER);
        vbStart.setSpacing(10);

        Scene sStart = new Scene(vbStart, 230, 220);
        primaryStage.setTitle("Startseite");
        primaryStage.setScene(sStart);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
