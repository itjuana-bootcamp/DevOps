package solid.srp.solved;

public class App {

    public static void main(String[] args) {
        CoursesManager manager = new CoursesManager();

        Course course01 = new Course(1, "Design Principles", DateConstants.OCTOBER, DateConstants.FEBRUARY);
        manager.add(course01);

        Course course02 = new Course(2, "Test-Driven Development", DateConstants.OCTOBER, DateConstants.MARCH);
        manager.add(course02);

        Course course03 = new Course(3, "CI/CD", DateConstants.FEBRUARY, DateConstants.APRIL);
        manager.add(course03);

        manager.print();
    }
}
