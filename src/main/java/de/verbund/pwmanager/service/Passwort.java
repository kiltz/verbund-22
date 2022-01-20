package de.verbund.pwmanager.service;

public class Passwort {
    private String kategorie;
    private String name;
    private String benutzername;
    private String passwort;

    public Passwort() {
    }

    public Passwort(String kategorie, String name, String benutzername, String passwort) {
        this.kategorie = kategorie;
        this.name = name;
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    @Override
    public String toString() {
        return "Passwort{" +
                "kategorie='" + kategorie + '\'' +
                ", name='" + name + '\'' +
                ", benutzername='" + benutzername + '\'' +
                ", passwort='" + passwort + '\'' +
                '}';
    }
}
