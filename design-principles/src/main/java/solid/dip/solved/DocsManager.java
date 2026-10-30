package solid.dip.solved;

public class DocsManager {

    private final Storage storage;

    public DocsManager(Storage storage) {
        this.storage = storage;
    }

    public int numberOfFiles() {
        return storage.getDocs().size();
    }

    public void append(Document document) {
        storage.getDocs().add(document);
    }

    public void remove(Document document) {
        storage.getDocs().remove(document);
    }

    public void clear() {
        storage.getDocs().clear();
    }

    public void print() {
        System.out.println("===== FILES =====");
        for(Document file: storage.getDocs()) {
            System.out.println(file);
        }
        System.out.println("================");
    }
}
