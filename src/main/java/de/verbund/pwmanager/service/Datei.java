package de.verbund.pwmanager.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Datei {
    private final File datei;
    private final Path pfad;

    public Datei(String pfad) {
        this.pfad = Paths.get(pfad);
        datei = new File(pfad);
    }

    public void schreibe(String text) {
        try (FileWriter outStream = new FileWriter(datei, true)) {
            outStream.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> lese() {
        try {
            return Files.readAllLines(pfad);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
