package solid.srp.solved;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateConstants {
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public static final LocalDateTime OCTOBER = dateFrom(1793343463000L);
    public static final LocalDateTime FEBRUARY = dateFrom(1803711463000L);
    public static final LocalDateTime MARCH = dateFrom(1806476263000L);
    public static final LocalDateTime APRIL = dateFrom(1809068263000L);

    private static LocalDateTime dateFrom(long milli) {
        Instant instant = Instant.ofEpochMilli(milli);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
