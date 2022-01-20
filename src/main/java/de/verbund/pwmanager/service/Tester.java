package de.verbund.pwmanager.service;

public class Tester {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.neueDateiOeffnen("src/main/java/de/verbund/pwmanager/datenbankTest.txt");
//        manager.addPasswort("Webseiten","amazon", "alex", "kkfjskldfj");
        System.out.println(manager.getKategorien());
    }
}
