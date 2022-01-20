package oop.aufgabe4.muloe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auszahlung extends Buchung {

    String art;
    double betrag;
    String datum;
    String zweck;

    public Auszahlung(String zweck, double betrag) {
        setBetrag(betrag);
        setBuchungArt("Auszahlung");
        setDatum(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        setZweck(zweck);
    }

    public Auszahlung(double betrag, String zweck, String datum) {
        setBetrag(betrag);
        setBuchungArt("Auszahlung");
        setDatum(datum);
        setZweck(zweck);
    }
}
