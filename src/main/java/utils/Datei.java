package utils;

import java.io.*;

public class Datei {
    private String dateiName;

    public Datei(String dateiName) {
        this.dateiName = dateiName;

    }

    public void schreibe(String text) {
        schreibe(text, false);
    }

    public void schreibe(String text, boolean append) {
        File datei = null;
        datei = new File(dateiName);
        try (FileWriter outStream = new FileWriter(datei, append)) {

            outStream.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lese() {
        StringBuffer inhalt = new StringBuffer();
        File datei = null;
        BufferedReader reader = null;
        datei = new File(dateiName);
        try (FileReader inStream = new FileReader(datei)) {
            reader = new BufferedReader(inStream);
            String zeile = "";
            while ((zeile = reader.readLine()) != null) {
                if (inhalt.length() > 0) {
                    inhalt.append("\n");
                }
                inhalt.append(zeile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inhalt.toString();
    }
}
