package solid.isp;

import java.util.ArrayList;

public class FileManager {

    private ArrayList<File> files = new ArrayList<>();

    public void add(File file) {
        files.add(file);
    }

    public ArrayList<File> getFiles() {
        return files;
    }
}
