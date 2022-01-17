package gui.uebung;

import javafx.scene.layout.VBox;

import java.awt.*;

public class Kontakt {
    String anrede;
    String vorname;
    String nachname;
    String eMail;
    String geburtstag;

    public Kontakt(String anrede, String vorname, String nachname, String eMail, String geburtstag) {
        this.anrede = anrede;
        this.vorname = vorname;
        this.nachname = nachname;
        this.eMail = eMail;
        this.geburtstag = geburtstag;
    }

    public void kontaktAnzeigen() {
        VBox root = new VBox();
        Label lAnrede = new Label("Anrede: " + anrede);
        Label lVorname = new Label("Vorname: " + vorname);
        Label lNachname = new Label("Nachname: " + nachname);
        Label lEMail = new Label("E-Mail: " + eMail);
        Label lGeburtstag = new Label("Geburtstag: " + geburtstag);

        // noch nicht fertig

    }

}
