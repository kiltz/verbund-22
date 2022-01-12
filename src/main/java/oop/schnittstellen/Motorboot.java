package oop.schnittstellen;

public class Motorboot implements Motorisiert {

    // Komposition
    private Motor motor = new BMWMotor();

    @Override
    public void start() {
        motor.start();
    }

    @Override
    public void stop() {
        motor.stop();
    }

    @Override
    public int getDrehzahl() {
        return motor.getDrehzahl();
    }

    @Override
    public void setDrehzahl(int drehzahl) {
        motor.setDrehzahl(drehzahl);
    }
}
