package solid.isp.solved;

public class TextFile extends File implements Printable, Recordable {

    private String text;

    public TextFile(String text, long size) {
        super(size);
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("----- TEXT FILE -----");
        System.out.println(text);
        System.out.println("Size = " + getSize() + " bytes");
    }

    @Override
    public void saveToDataBase() {
        System.out.println("Saving data to database...");
    }
}
