package lesson17;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Task1 {
    public static void main(String[] args) {

        LocalTime startDate = LocalTime.from(LocalDateTime.now().minusHours(10).minusDays(5));
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

    }
    private static void stringToDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss XXX");
        String dateString = "21/Dec/2022:05:30:10 +03:00";

        OffsetDateTime parsedOffsetDateTime = OffsetDateTime.parse(dateString, dateTimeFormatter);
        System.out.println("parsedOffsetDateTime = " + parsedOffsetDateTime);
    }

    private static void dateToString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E dd/MMMM/yyyy HH:mm:ss XXX");
        OffsetDateTime offsetDateTimeNow = OffsetDateTime.now(ZoneId.of("Europe/Minsk"));

        String formattedDate = offsetDateTimeNow.format(dateTimeFormatter);
        System.out.println("formattedDate = " + formattedDate);
    }
}
