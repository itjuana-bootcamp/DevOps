package solid.srp.solved;

import java.time.LocalDateTime;

public class Course {
    private int id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    public Course(int id, String name, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
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

    public String getStartFormatted() {
        return start.format(DateConstants.DEFAULT_FORMATTER);
    }

    public String getEndFormatted() {
        return end.format(DateConstants.DEFAULT_FORMATTER);
    }
}
