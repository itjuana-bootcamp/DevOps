package solid.dip;

import java.util.ArrayList;

public class DatabaseStorage {

    private final ArrayList<Document> documents = new ArrayList<>();

    public DatabaseStorage() {
        documents.add(new Document("Presentation", "pptx", 4560));
        documents.add(new Document("CV", "pdf", 1200));
        documents.add(new Document("profile_picture", "png", 12000));
    }

    public ArrayList<Document> getDocs() {
        return documents;
    }
}
