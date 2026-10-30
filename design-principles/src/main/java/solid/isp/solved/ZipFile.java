package solid.isp.solved;

public class ZipFile extends File implements Writable {

    private String url;

    public ZipFile(String url, long size) {
        super(size);
        this.url = url;
    }

    @Override
    public void saveToFile(String fileName) {
        System.out.println("Saving data to " + fileName + "...");
    }
}
