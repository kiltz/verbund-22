package oop.schnittstellen;

public class BMWMotor extends Motor {
    private int drehzahl;

    @Override
    public void start() {
        drehzahl = 400;
    }

    @Override
    public void stop() {
        drehzahl = 0;
    }

    @Override
    public int getDrehzahl() {
        return drehzahl;
    }

    @Override
    public void setDrehzahl(int drehzahl) {
        if (drehzahl < 6000) {
            this.drehzahl = drehzahl;
        }
    }
}
