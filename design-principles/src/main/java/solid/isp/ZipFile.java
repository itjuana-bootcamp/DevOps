package solid.isp;

public class ZipFile implements File {

    private String url;
    private long size;

    public ZipFile(String url, long size) {
        this.url = url;
        this.size = size;
    }

    @Override
    public void print() {
        // NOTHING
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
