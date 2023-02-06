package lesson17;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataTime {
    public static void main(String[] args) {
        dateToString();
        stringToDate();
    }

    private static void stringToDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss XXX");

        String dateString = "21/Dec/2022 05:30:10 +03:00";

        OffsetDateTime parsedOffsetDateTime = OffsetDateTime.parse(dateString, dateTimeFormatter);
        System.out.println("parsedOffsetDateTime = " + parsedOffsetDateTime.toString());
    }

    private static void dateToString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E dd/MMMM/yyyy HH:mm:ss XXX");
        OffsetDateTime offsetDateTimeNow = OffsetDateTime.now(ZoneId.of("Europe/Minsk"));

        String formattedDate = offsetDateTimeNow.format(dateTimeFormatter);
        System.out.println("formattedDate = " + formattedDate);
    }

}

