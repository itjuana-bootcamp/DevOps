package solid.dip;

public class DocsManager {

    private final DatabaseStorage databaseStorage = new DatabaseStorage();

    public int numberOfFiles() {
        return databaseStorage.getDocs().size();
    }

    public void append(Document document) {
        databaseStorage.getDocs().add(document);
    }

    public void remove(Document document) {
        databaseStorage.getDocs().remove(document);
    }

    public void clear() {
        databaseStorage.getDocs().clear();
    }

    public void print() {
        System.out.println("===== FILES =====");
        for(Document file: databaseStorage.getDocs()) {
            System.out.println(file);
        }
        System.out.println("================");
    }
}
