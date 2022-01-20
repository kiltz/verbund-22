package oop.aufgabe4.muloe;

import utils.Zahlen;
import utils.muloe.Datei;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Konto {
    private double dispo = 0;
    private final Datei datei = new Datei("kontoInfos.txt");
    private double kontostand = 0;
    private List<Buchung> buchungen;

    public Konto() {
        this(0);
        buchungen = lese();
    }

    public Konto(double dispo) {
        this.dispo = dispo;
        buchungen = lese();
    }

    public Konto(double dispo, double kontostand) {
        this.dispo = dispo;
        this.kontostand = kontostand;
        buchungen = lese();
    }

    public void schreibeBuchung(Buchung b) {
        buchungen.add(b);
        String eintrag = b.buchungInfosGeben();
        datei.schreibe(eintrag, true);
    }

    public List<Buchung> lese() {
        List<Buchung> liste = new ArrayList<>();
        double summeKontostand = 0;
        try {
            String inhalt = datei.lese();
            String[] eintraege = inhalt.split("\n");
            for (String eintrag : eintraege) {
                String[] teile = eintrag.split(";");
                double betrag;
                try {
                    betrag = Zahlen.stringToDouble(teile[3]);
                    if (teile[0].equals("Einzahlung")) {
                        liste.add(new Einzahlung(betrag, teile[2]));
                        summeKontostand += betrag;
                    } else if (teile[0].equals("Auszahlung")) {
                        liste.add(new Auszahlung(betrag, teile[3], teile[2]));
                        summeKontostand -= betrag;
                    } else {
                        liste.add(new Dispo(betrag, teile[1]));
                        setDispo(betrag);
                    }
                } catch (ParseException e) {
                    System.out.println("Es liegt ein Fehler in der Datei vor");
                }
            }

        } catch (Exception e) {

        }
        setKontostand(summeKontostand);
        return liste;
    }

    public void setDispo(double neuerDispo, boolean schreibe) {
        dispo = neuerDispo;
        if (schreibe) {
            schreibeBuchung(new Dispo(neuerDispo));
        }
    }

    public void setDispo(double neuerDispo) {
        setDispo(neuerDispo, false);
    }

    public double getDispo() {
        return dispo;
    }

    public void einzahlen(double betrag) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
        schreibeBuchung(new Einzahlung(betrag));
    }

    private void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getKontoStand() {
        return kontostand;
    }

    // 2. gebe die Exception weiter
    public void auszahlen(String zweck, double betrag) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
            schreibeBuchung(new Auszahlung(zweck, betrag));
        } else {
            throw new KeineKontoDeckungException(kontostand, kontostand + dispo);
        }
    }

    public List<Buchung> getBuchungen() {
        return buchungen;
    }
}
