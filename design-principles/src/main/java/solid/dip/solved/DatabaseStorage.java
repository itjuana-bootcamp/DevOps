package solid.dip.solved;

import java.util.ArrayList;

public class DatabaseStorage implements Storage {

    private final ArrayList<Document> documents = new ArrayList<>();

    public DatabaseStorage() {
        documents.add(new Document("Presentation", "pptx", 4560));
        documents.add(new Document("CV", "pdf", 1200));
        documents.add(new Document("profile_picture", "png", 12000));
    }

    @Override
    public ArrayList<Document> getDocs() {
        return documents;
    }
}
