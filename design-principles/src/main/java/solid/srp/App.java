package solid.srp;

public class App {

    public static void main(String[] args) {
        Course array = new Course();

        Course course01 = new Course(1, "Design Principles", AppUtils.october, AppUtils.february);
        array.getCourses().add(course01);

        Course course02 = new Course(2, "Test-Driven Development", AppUtils.october, AppUtils.march);
        array.getCourses().add(course02);

        Course course03 = new Course(3, "CI/CD", AppUtils.february, AppUtils.april);
        array.getCourses().add(course03);

        AppUtils.printCourse(array.getCourses());
    }
}
