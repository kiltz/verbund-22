package oop.wdh;

public class AzubiListe {
    private Azubi[] azubis = new Azubi[2];
    private int index = 0;

    public void add(Azubi azubi) {
        if (index == azubis.length) {

            System.out.println("Array zu klein, muss es vergrößern...");
            Azubi[] azubisNeu = new Azubi[azubis.length + 2];
            for (int i = 0; i < azubis.length; ++i) {
                azubisNeu[i] = azubis[i];
            }
            azubis = azubisNeu;
        }
        azubis[index] = azubi;
        index++;
    }
}
