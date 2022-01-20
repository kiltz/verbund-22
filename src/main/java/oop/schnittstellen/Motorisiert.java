package oop.schnittstellen;

public interface Motorisiert {
    void start();

    void stop();

    int getDrehzahl();

    void setDrehzahl(int drehzahl);
}
