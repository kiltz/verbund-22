package features.inout.aufgabe;

import java.io.*;


public class Datei {

    StringBuffer inhalt = new StringBuffer();
    File file = null;

    public Datei(String pfad) {
        this.file = new File(pfad);
    }

    public void schreibe(String zeile1) throws IOException {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(zeile1);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public void schreibe(String zeile1, boolean append) throws IOException {
        try (FileWriter fw = new FileWriter(file, append)) {
            fw.write(zeile1);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public String lese() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String zeile;
            while ((zeile = br.readLine()) != null) {
                inhalt.append(zeile).append("\n");
            }
            inhalt.deleteCharAt(inhalt.length() - 1);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
        return inhalt.toString();
    }
}
