package oop.aufgabe4.muloe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dispo extends Buchung {
    String art;
    double betrag;
    String datum;
    String zweck;

    public Dispo(double betrag) {
        setBetrag(betrag);
        setBuchungArt("Dispo");
        setDatum(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        setZweck("");
    }

    public Dispo(double betrag, String datum) {
        setBetrag(betrag);
        setBuchungArt("Dispo");
        setDatum(datum);
        setZweck("");
    }
}
