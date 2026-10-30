package solid.ocp;

public class Calculator {

    public double calculateArea(Object shape) {
        if(shape instanceof Square square) {
            return square.getSide() * square.getSide();

        } else if(shape instanceof Rectangle rectangle) {
            return rectangle.getLength() * rectangle.getWidth();

        } else if(shape instanceof Circle circle) {
            return Math.PI * Math.pow(circle.getRadius(), 2);

        }else if(shape instanceof  Triangle triangle) {
            return (triangle.getBase() * triangle.getHeight()) / 2;
        }
        return 0;
    }
}
