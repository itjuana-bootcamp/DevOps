package solid.srp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AppUtils {

    public static LocalDateTime october = AppUtils.dateFrom(1793343463000L);
    public static LocalDateTime february = AppUtils.dateFrom(1803711463000L);
    public static LocalDateTime march = AppUtils.dateFrom(1806476263000L);
    public static LocalDateTime april = AppUtils.dateFrom(1809068263000L);

    private static LocalDateTime dateFrom(long milli) {
        Instant instant = Instant.ofEpochMilli(milli);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return date.format(formatter);
    }

    public static void printCourse(ArrayList<Course> courses) {
        System.out.println("========== COURSES ==========");
        for(Course course: courses) {

            System.out.println(course.getName());

            String start = AppUtils.formatDate(course.getStart());
            System.out.println(start);

            String end = AppUtils.formatDate(course.getEnd());
            System.out.println(end);

            System.out.println("----------");
        }
        System.out.println("=========================");
    }
}
