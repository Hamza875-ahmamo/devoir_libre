package org.example.exam__blanc.helper;


import org.example.exam__blanc.model.Membre;

import java.io.IOException;
import java.util.List;

public class CsvReaded {
    private String filePath;
    private List<Membre> membres;
    private FileService fileService;

    // Constructor that accepts the file path
    public CsvReaded(String filePath) throws IOException {
        this.filePath = filePath;
        this.fileService = new FileService();
        this.membres = fileService.chargerListeMembre(filePath);
    }

    // Getter for membres
    public List<Membre> getMembres() {
        return membres;
    }

    // Main method to print members as JSON
    public static void main(String[] args) {
        try {
            // Create CsvReaded instance with the file path
            CsvReaded csvReaded = new CsvReaded("C:\\Users\\hamza\\IdeaProjects\\exam__blanc\\src\\main\\resources\\members.csv");

            // Get the set of membres
            List<Membre> membres = csvReaded.getMembres();

            for (Membre m: membres){
                System.out.println(m.toJson());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
