package solid.srp.solved;

import java.util.ArrayList;

public class CoursesManager {

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void add(Course course) {
        courses.add(course);
    }

    public void print() {
        System.out.println("========== COURSES ==========");
        for(Course course: courses) {
            System.out.println(course.getName());
            System.out.println(course.getStartFormatted());
            System.out.println(course.getEndFormatted());
            System.out.println("----------");
        }
        System.out.println("=========================");
    }
}
