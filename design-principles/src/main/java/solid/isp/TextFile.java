package solid.isp;

public class TextFile implements File {

    private String text;
    private long size;

    public TextFile(String text, long size) {
        this.text = text;
        this.size = size;
    }

    @Override
    public void print() {
        System.out.println("----- TEXT FILE -----");
        System.out.println(text);
        System.out.println("Size = " + size + " bytes");
    }

    @Override
    public void saveToFile(String fileName) {
        // NOTHING
    }

    @Override
    public void saveToDataBase() {
        System.out.println("Saving data to database...");
    }
}
