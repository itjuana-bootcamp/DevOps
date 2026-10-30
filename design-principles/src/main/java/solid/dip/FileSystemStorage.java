package solid.dip;

import java.util.ArrayList;

public class FileSystemStorage {

    private final ArrayList<Document> files = new ArrayList<>();

    public FileSystemStorage() {
        files.add(new Document("Resume", "docx", 4560));
        files.add(new Document("Taxes", "xlsx", 23600));
        files.add(new Document("wallpaper", "jpg", 22500));
    }

    public ArrayList<Document> getDocs() {
        return files;
    }
}
