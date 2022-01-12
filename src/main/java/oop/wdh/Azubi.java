package oop.wdh;

public class Azubi {
    private String name;
    private String firma;

    public Azubi(String name, String firma) {
        this.name = name;
        this.firma = firma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return name + " " + firma;
    }
}
