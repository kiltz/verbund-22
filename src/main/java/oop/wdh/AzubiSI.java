package oop.wdh;

public class AzubiSI extends Azubi {
    private String produkte;

    public AzubiSI(String name, String firma, String produkte) {
        super(name, firma);
        this.produkte = produkte;
    }

    public String getProdukte() {
        return produkte;
    }

    public void setProdukte(String produkte) {
        this.produkte = produkte;
    }

    @Override
    public String toString() {
        return super.toString() + " " + produkte;
    }
}
