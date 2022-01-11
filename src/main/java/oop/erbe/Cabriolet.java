package oop.erbe;

public class Cabriolet extends Auto {

    public void oeffneVerdeck() {
        System.out.println("öffne das Verdeck");
    }

    @Override
    public String getTyp() {
        return super.getTyp()+" Cabrio";
    }
}
