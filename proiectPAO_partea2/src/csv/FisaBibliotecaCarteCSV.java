package csv;

import biblioteca.ExemplarCarte;

import java.io.*;

public class FisaBibliotecaCarteCSV {
    private static FisaBibliotecaCarteCSV instance;
    private FisaBibliotecaCarteCSV() {}

    public static synchronized FisaBibliotecaCarteCSV getInstance() {
        if (instance == null)
            instance = new FisaBibliotecaCarteCSV();

        return instance;
    }

    public void scrieFisaBibliotecaCarteInCSV(ExemplarCarte exemplarCarte, int numarCarte) { // numarCarte -> numarul cartii din biblioteca
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Ana\\Desktop\\proiectPAO_partea2\\src\\csv\\fisaBibliotecaCarteCSVafisare.csv", true))) {
            String line = exemplarCarte.getTitlu() + ", " + exemplarCarte.getAutor() + ", " + exemplarCarte.getEditura() + ", " + exemplarCarte.getGenLiterar() + ", " + exemplarCarte.getNumarPagini() + ", " + exemplarCarte.getAnAparitie() + ", " + exemplarCarte.getIdCarte() + ", " + numarCarte;
            writer.write(line);
            writer.newLine();
            ServiciuAudit.logAudit("Fisa cartii cu numarul " + numarCarte + " a fost creata si afisata.");
        }
        catch (IOException e) {
            System.out.println("eroare la scrierea cartii in fisierul CSV: " + e.getMessage());
        }
    }
}
