package oop.aufgabe4.muloe;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class KontoAuszug {
    private final String path = "src/main/java/oop/aufgabe4/muloe/auszug.txt";
    private List<Eintrag> eintraege;
    private List<Eintrag> eintraegeList;

    private void eintraegeLesen() {
        eintraege = new ArrayList<>();
        try {
            for (String zeile : Files.readAllLines(Paths.get(path))) {
                String[] temp = zeile.split(";");
                eintraege.add(new Eintrag(temp[0], temp[1], temp[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eintragHinzufuegen(String neuerEintrag) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(neuerEintrag);
        } catch (IOException ignore) {
        }
    }

    public List<Eintrag> getEintraege(String kategorie) {
        eintraegeLesen();

        if (kategorie == null) {
            return eintraege;
        } else {
            eintraegeList = new ArrayList<>();
            for (Eintrag eintrag : eintraege) {
                if (eintrag.getKategorie().equals(kategorie)) {
                    eintraegeList.add(eintrag);
                }
            }
            return eintraegeList;
        }
    }
}
