package solid.isp;

public class ImageFile implements File {

    private String url;
    private int width;
    private int height;
    private long size;

    public ImageFile(String url, int width, int height, long size) {
        this.url = url;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    @Override
    public void print() {
        System.out.println("----- IMAGE FILE -----");
        System.out.println(url);
        System.out.println("Resolution = (" + width + ", " + height + ")");
        System.out.println("Size = " + size + " bytes");
    }

    @Override
    public void saveToFile(String fileName) {
        System.out.println("Saving data to " + fileName + "...");
    }

    @Override
    public void saveToDataBase() {
        // NOTHING
    }
}
