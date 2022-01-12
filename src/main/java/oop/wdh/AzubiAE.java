package oop.wdh;

public class AzubiAE extends Azubi {
    private String programmierSprachen;

    public AzubiAE(String name, String firma, String programmierSprachen) {
        super(name, firma);
        this.programmierSprachen = programmierSprachen;
    }

    public String getProgrammierSprachen() {
        return programmierSprachen;
    }

    public void setProgrammierSprachen(String programmierSprachen) {
        this.programmierSprachen = programmierSprachen;
    }

    @Override
    public String toString() {
        return super.toString() + " " + programmierSprachen;
    }
}
