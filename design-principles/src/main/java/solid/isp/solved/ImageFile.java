package solid.isp.solved;

public class ImageFile extends File implements Printable, Writable {

    private String url;
    private int width;
    private int height;

    public ImageFile(String url, int width, int height, long size) {
        super(size);
        this.url = url;
        this.width = width;
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("----- IMAGE FILE -----");
        System.out.println(url);
        System.out.println("Resolution = (" + width + ", " + height + ")");
        System.out.println("Size = " + getSize() + " bytes");
    }

    @Override
    public void saveToFile(String fileName) {
        System.out.println("Saving data to " + fileName + "...");
    }
}
