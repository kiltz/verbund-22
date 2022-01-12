package oop.erbe.aufgabe5;

public class FormenListe {
    private Form[] liste = new Form[2];
    private int index = 0;

    public void add(Form formList) {
        if (index == liste.length) {

            System.out.println("Array zu klein, muss es vergrößern...");
            Form[] listeNeu = new Form[liste.length + 1];
            for (int i = 0; i < liste.length; ++i) {
                listeNeu[i] = liste[i];
            }
            liste = listeNeu;
        }
        liste[index] = formList;
        index++;
    }
}
