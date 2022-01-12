package oop.wdh;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Azubi[] azubis = new Azubi[7];
        azubis[0] = new AzubiSI("Jan", "BNP Paribas", "Microsoft");
        azubis[1] = new AzubiSI("Marcel", "BNP Paribas", "Red Bull");
        azubis[2] = new AzubiAE("Nikita", "BNP Paribas", "Java, C++");
        azubis[3] = new AzubiAE("Dmitry", "BNP Paribas", "Java");
        azubis[4] = new AzubiAE("Moritz", "TeamBank", "Java");
        azubis[5] = new AzubiAE("Tobias", "TeamBank", "Java, HTML, JavaScript");
        azubis[6] = new AzubiAE("Lana", "Semikron", "Java, HTML, JavaScript");

        for (Azubi a : azubis) {
            System.out.println(a);
        }

        AzubiListe liste = new AzubiListe();
        liste.add(new AzubiSI("Jan", "BNP Paribas", "Microsoft"));
        liste.add(new AzubiSI("Marcel", "BNP Paribas", "Microsoft"));
        liste.add(new AzubiAE("Lana", "Semikron", "Java, HTML, JavaScript"));

        List<Azubi> liste2 = new ArrayList<>();
        liste2.add(new AzubiSI("Jan", "BNP Paribas", "Microsoft"));
        liste2.add(new AzubiSI("Marcel", "BNP Paribas", "Microsoft"));
        liste2.add(new AzubiAE("Lana", "Semikron", "Java, HTML, JavaScript"));


    }
}
