package solid.ocp;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<Object> shapes = new ArrayList<>();
        Calculator calculator = new Calculator();

        Square square = new Square(8);
        shapes.add(square);

        Rectangle rectangle = new Rectangle(10, 20);
        shapes.add(rectangle);

        Circle circle = new Circle(20);
        shapes.add(circle);

        Triangle triangle = new Triangle(20, 15);
        shapes.add(triangle);

        for(Object shape: shapes) {
            double area = calculator.calculateArea(shape);
            System.out.println(area);
        }
    }
}
