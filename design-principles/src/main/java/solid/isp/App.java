package solid.isp;

public class App {
    public static void main(String[] args) {
        FileManager manager = new FileManager();

        TextFile textFile = new TextFile("Hello World", 250);
        manager.add(textFile);

        ImageFile imageFile = new ImageFile("https://ps.w.org/hello-world/assets/icon.svg?rev=3283047", 1200, 960, 45678);
        manager.add(imageFile);

        ZipFile zipFile = new ZipFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpl390EGpo-Dr7C6xRNMFZOPQeFgjcKOq2cbWVP4pSQG-juP2wSdRuQOJI&s=10", 44444);
        manager.add(zipFile);

        TextFile textFile2 = new TextFile("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor egestas congue. Proin egestas odio vel tortor elementum tempor. Vestibulum eu pulvinar felis, vitae pharetra sapien. Nam eleifend finibus justo, molestie dignissim nisi pretium ac. Nunc ut ipsum eget dolor aliquam porta vel non erat. Duis pellentesque, ipsum nec elementum fringilla, ex enim porta felis, eget iaculis massa orci quis sapien. Proin quis euismod quam.", 1350);
        manager.add(textFile2);

        for(File file: manager.getFiles()) {
            file.print();
        }

        for(File file: manager.getFiles()) {
            file.saveToDataBase();
        }
    }
}
