package oop.aufgabe4.muloe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Auszahlung extends Buchung {

    String art;
    double betrag;
    String datum;

    public Auszahlung(double betrag) {
        setBetrag(betrag);
        setBuchungArt("Auszahlung");
        setDatum(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    public Auszahlung(double betrag, String datum) {
        setBetrag(betrag);
        setBuchungArt("Auszahlung");
        setDatum(datum);
    }
}
