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
                    betrag = Zahlen.stringToDouble(teile[2]);
                    if (teile[0].equals("Einzahlung")) {
                        liste.add(new Einzahlung(betrag, teile[1]));
                        einzahlen(betrag);
                    } else if (teile[0].equals("Auszahlung")) {
                        liste.add(new Auszahlung(betrag, teile[1]));
                        auszahlen(betrag);
                    } else {
                        liste.add(new Dispo(betrag, teile[1]));
                        setDispo(betrag);
                    }
                } catch (ParseException e) {
                    System.out.println("Es liegt ein Fehler in der Datei vor");
                } catch (KeineKontoDeckungException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {

        }
        return liste;
    }

    public void setDispo(double neuerDispo, boolean schreibe) {
        dispo = neuerDispo;
        schreibeBuchung(new Dispo(neuerDispo));
    }

    public void setDispo(double neuerDispo) {
        dispo = neuerDispo;
    }

    public double getDispo() {
        return dispo;
    }

    public void einzahlen(double betrag) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
    }

    public void einzahlen(double betrag, boolean schreibe) {
        //kontostand = kontostand + betrag;
        kontostand += betrag;
        schreibeBuchung(new Einzahlung(betrag));
    }

    public double getKontoStand() {
        return kontostand;
    }

    // 2. gebe die Exception weiter
    public void auszahlen(double betrag) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
        } else {
            throw new KeineKontoDeckungException(kontostand, kontostand + dispo);
        }
    }

    public void auszahlen(double betrag, boolean schreibe) throws KeineKontoDeckungException {
        if (kontostand + dispo >= betrag) {
            kontostand -= betrag;
            schreibeBuchung(new Auszahlung(betrag));
        } else {
            throw new KeineKontoDeckungException(kontostand, kontostand + dispo);
        }
    }

    public List<Buchung> getBuchungen() {
        return buchungen;
    }
}
