package oop.aufgabe4.muloe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Einzahlung extends Buchung {
    String art;
    double betrag;
    String datum;

    public Einzahlung(double betrag) {
        setBetrag(betrag);
        setBuchungArt("Einzahlung");
        setDatum(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
