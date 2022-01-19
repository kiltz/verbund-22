package oop.aufgabe4.muloe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class BuchungTab extends BasisTab {
    private final Konto konto;
    private double dispo = 0;
    private double kontostand = 0;
    private List<Double> buchungen;

    public BuchungTab(Konto konto) {
        this.konto = konto;
    }

    @Override
    public Tab getTab() {
        HBox box = new HBox();
        Label anzeige = new Label("Dialog für Buchungen");
        Button bEinzahlen = new Button("Einzahlen");
        bEinzahlen.setOnAction(e -> {
            konto.einzahlen(100);
            anzeige.setText(String.format("Kontostand: %.2f", konto.getKontoStand()));
        });
        box.getChildren().addAll(bEinzahlen, anzeige);
        Tab tab = new Tab("Buchungen", box);
        return tab;
    }

    public Konto() {
        this();
    }

    public Konto(double dispo) {
        this.dispo = dispo;
        buchungen = new ArrayList<>();
    }

    public Konto(double dispo, double kontostand) {
        this.dispo = dispo;
        this.kontostand = kontostand;
    }

    public setDispo(double neuerDispo) {
        dispo = neuerDispo;
    }

    public einzahlen(double betrag) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
        buchungen.add(betrag);
    }

    public auszahlen(double betrag) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
            buchungen.add(betrag * -1);
        } else {
            throw new KeineKontoDeckungException(kontostand, kontostand + dispo);
        }
    }

    public List<Double> getBuchungen() {
        return buchungen;
    }
}
