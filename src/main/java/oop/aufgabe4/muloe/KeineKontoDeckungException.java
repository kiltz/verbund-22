package oop.aufgabe4.muloe;

public class KeineKontoDeckungException extends Throwable {
    public KeineKontoDeckungException(double kontostand, double verfuegbar) {
        super(String.format("Der Kontostand ist bei %.2f EUR, es sind noch %.2f EUR verfügbar.", kontostand, verfuegbar));
    }
}
