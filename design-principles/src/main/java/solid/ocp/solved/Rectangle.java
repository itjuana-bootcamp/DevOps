package solid.ocp.solved;

public class Rectangle implements Shape {

    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }
}
