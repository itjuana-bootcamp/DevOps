package solid.dip.solved;

import java.util.ArrayList;

public class FileSystemStorage implements Storage {

    private final ArrayList<Document> files = new ArrayList<>();

    public FileSystemStorage() {
        files.add(new Document("Resume", "docx", 4560));
        files.add(new Document("Taxes", "xlsx", 23600));
        files.add(new Document("wallpaper", "jpg", 22500));
    }

    @Override
    public ArrayList<Document> getDocs() {
        return files;
    }
}
