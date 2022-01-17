package utils;

import java.io.*;

public class Datei {
    File datei = null;

    public Datei(String dateiName) {
        datei = new File(dateiName);
    }

    public void schreibe(String eingabe) {
        try (FileWriter outStream = new FileWriter(datei)) {
            outStream.write(eingabe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void schreibe(String eingabe, boolean sollAnfügen) {
        try (FileWriter outStream = new FileWriter(datei, sollAnfügen)) {
            outStream.write(eingabe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lese() {
        StringBuffer inhalt = new StringBuffer();
        // einlesen der Datei
        try (BufferedReader reader = new BufferedReader(new FileReader(datei))) {
            String zeile = "";
            while ((zeile = reader.readLine()) != null) // bis alles drin ist
            {
                if (!inhalt.isEmpty()) {
                    inhalt.append("\n");
                }
                inhalt.append(zeile);
            }
        }
        // Etwas schief gegangen?
        catch (IOException e) {
            e.printStackTrace();
        }
        return inhalt.toString();
    }


}