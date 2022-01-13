package utils;

import java.io.*;

public class Datei {
    private String dateiName;
    private StringBuffer inhalt;

    public Datei(String dateiName) {
        this.dateiName = dateiName;
    }

    public void schreibe(String text) {
        schreibe(text, false); //
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

    public String lese() { // verwendung: String text = d.lese();
        StringBuffer inhalt = new StringBuffer();
        BufferedReader reader = null;
        File datei = null;
        datei = new File(dateiName);
        try (FileReader inStream = new FileReader(datei)) {
            reader = new BufferedReader(inStream);
            String zeile = "";
            while ((zeile = reader.readLine()) != null) // bis alles drin ist
            {
                if (!inhalt.isEmpty()) {
                    inhalt.append("\n");
                }
                inhalt.append(zeile);
            }
            // Ausgabe der gesammelten Werke
            // System.out.println(inhalt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inhalt.toString();
    }
}
