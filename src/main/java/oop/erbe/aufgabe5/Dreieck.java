package oop.erbe.aufgabe5;

public class Dreieck extends Form {
    int i_seite_a_d;
    int i_seite_b_d;
    int i_seite_c_d;

    public Dreieck(int i_seite_a_d, int i_seite_b_d, int i_seite_c_d) {
        super();
        this.i_seite_a_d = i_seite_a_d;
        this.i_seite_b_d = i_seite_b_d;
        this.i_seite_c_d = i_seite_c_d;
    }

    @Override
    public double d_berechne_umfang() {
        return (i_seite_a_d + i_seite_b_d + i_seite_c_d);
    }
}
