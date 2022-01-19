package oop.aufgabe4.muloe;

public class KeineKontoDeckungException extends Throwable {
    public KeineKontoDeckungException(double kontostand, double d_auszahlBetrag) {
        super(String.format("Der Kontostand beträgt %.2f EUR.\n" +
                        "Die gewünschte Summe %.2f EUR kann leider nicht ausbezahlt werden,\n" +
                        "da Ihr Konto nicht ausreichend gedeckt ist.",
                kontostand, d_auszahlBetrag)
        );
    }
}
