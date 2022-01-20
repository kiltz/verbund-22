package de.verbund.pwmanager.service;

import de.verbund.pwmanager.utils.Datei;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final Datei datei;
    private ArrayList<Passwort> datensaetze;

    public Manager() {
        datei = new Datei("passwd.txt");
        ArrayList<Passwort> datensaetze = lese();

    }

    public ArrayList<Passwort> lese() {
        ArrayList<Passwort> liste = new ArrayList<>();
        try {
            String inhalt = datei.lese();
            String[] saetze = inhalt.split("\n");
            for (String satz : saetze) {
                String[] teile = satz.split(";");
                liste.add(new Passwort(teile[0], teile[1], teile[2]));
            }

        } catch (Exception e) {
            // dann ist die halt nicht da!
        }
        return liste;
    }

    public void neu(Passwort p) throws Exception {
        // Validierung
        datensaetze.add(p);
        String satz = p.getName() + ";" + p.getBenutzername() + ";" + p.getPasswort() + "\n";
        datei.schreibe(satz, true);
    }

    public List<Passwort> suche(String s) {
        List<Passwort> ergebnisListe = new ArrayList<>();
        for (Passwort daten : datensaetze) {
            if (daten.getName().contains(s)) {
                ergebnisListe.add(daten);
            }
        }
        return ergebnisListe;
    }
}
