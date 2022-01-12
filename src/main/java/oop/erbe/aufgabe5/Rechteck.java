package oop.erbe.aufgabe5;

public class Rechteck extends Form {
    int i_seite_a_r;
    int i_seite_b_r;

    public Rechteck(int i_seite_a_r, int i_seite_b_r) {
        super();
        this.i_seite_a_r = i_seite_a_r;
        this.i_seite_b_r = i_seite_b_r;
    }

    @Override
    public double d_berechne_umfang() {
        return (2 * (i_seite_a_r + i_seite_b_r));
    }
}