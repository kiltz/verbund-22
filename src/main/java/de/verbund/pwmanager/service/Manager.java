package de.verbund.pwmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {
    private Datei datei;
    private List<Passwort> paswoerter;


    public Manager() {
    }

    public Manager(String pfad) {
        this.datei = new Datei(pfad);
        this.paswoerter = lese();
    }

    private List<Passwort> lese() {
        List<Passwort> tempPass = new ArrayList<>();
        List<String> zeileDatenbank = datei.lese();

        String[] tempArr;
        for (String s : zeileDatenbank) {
            tempArr = s.split(";");
            tempPass.add(new Passwort(tempArr[0], tempArr[1], tempArr[2], tempArr[3]));
        }

        return tempPass;
    }

    public void addPasswort(String kategorie, String servicename, String benutzerName, String passwort) {
        String satz = String.format("%s;%s;%s;%s\n", kategorie, servicename, benutzerName, passwort);
        datei.schreibe(satz);
    }

    public List<Passwort> suche(String kategorie) {
        return paswoerter.stream().filter(p -> p.getKategorie().equals(kategorie)).collect(Collectors.toList());
    }

    public void neueDateiOeffnen(String pfad) {
        datei = new Datei(pfad);
        paswoerter = lese();
    }

    public List<String> getKategorien() {
        paswoerter = lese();
        return paswoerter.stream().map(Passwort::getKategorie).distinct().collect(Collectors.toList());
    }
}
