package solid.dip.solved;

public class Document {

    private String name;
    private String extension;
    private long size;

    public Document(String name, String extension, long size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    @Override
    public String toString() {
        return name + "." + extension + " (" + size + " bytes)";
    }
}
