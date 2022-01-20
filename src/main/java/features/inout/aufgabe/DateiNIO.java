//package features.inout.aufgabe;
//
//import java.io.IOException;
//import java.nio.file.*;
//import java.util.List;
//
//import static java.nio.charset.StandardCharsets.UTF_8;
//
//public class DateiNIO {
//
//    Path pfad = null;
//
//    public DateiNIO(String pfad) throws NoSuchFileException {
//        if (Files.isRegularFile(Paths.get(pfad))){
//            this.pfad = Paths.get(pfad);
//        } else {
//            throw new NoSuchFileException(pfad);
//        }
//
//    }
//
//    public void schreibe(String zeile1) throws IOException {
//        Files.writeString(pfad, zeile1);
//    }
//
//    public void schreibe(String zeile1, boolean append) throws IOException {
//        Files.writeString(pfad, zeile1, StandardOpenOption.APPEND);
//    }
//
//    public List<String> lese() throws IOException {
//        return Files.readAllLines(pfad);
//    }
//
//
//}
