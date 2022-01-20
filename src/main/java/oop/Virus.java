package oop;

import java.util.ArrayList;
import java.util.List;

public class Virus {

    // Instanzvariable
    long nr;
    // Klassenvariable
    static long anzahl;

    static List<Virus> liste = new ArrayList<>();

    public Virus() {
        anzahl++;
        nr = anzahl;
    }

    public static void main(String[] args) {
        while (true) {
            Virus v = new Virus();
            liste.add(v);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.print(anzahl+"/"+nr+";");
    }
}
