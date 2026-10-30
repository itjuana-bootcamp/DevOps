package solid.dip;

public class App {

    public static void main(String[] args) {
        DocsManager manager = new DocsManager();
        manager.append(new Document("Test", "txt", 123));
        manager.append(new Document("Final Document", "pdf", 4321));

        manager.print();
    }
}
