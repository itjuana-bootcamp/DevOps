package solid.srp;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Course {

    private int id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    private final ArrayList<Course> courses = new ArrayList<>();

    public Course(int id, String name, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
