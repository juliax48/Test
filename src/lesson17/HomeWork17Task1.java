package lesson17;

import java.time.*;
import java.util.*;

public class HomeWork17Task1 {
    public static void main(String[] args) {
        List<Lesson> classLessons = new ArrayList<>();

        LocalDate date = LocalDate.of(2022, 10, 19);

        int lessonNumber = 1;

        while (lessonNumber <= 14) {
            switch (date.getDayOfWeek()) {
                case WEDNESDAY:
                    classLessons.add(new Lesson(
                            "Lesson " + lessonNumber, date.atTime(16, 30).atZone(ZoneId.of("CET"))));
                    lessonNumber += 1;
                    break;
                case SATURDAY:
                    classLessons.add(new Lesson(
                            "Lesson " + lessonNumber, date.atTime(07, 30).atZone(ZoneId.of("CET"))));
                    lessonNumber += 1;
                    break;
            }

            date = date.plusDays(1);
        }
        for (Lesson lesson : classLessons) {
            System.out.println(lesson.getName() + " " + lesson.getTime());
        }
    }
}


class Lesson {
    private String name;

    private ZonedDateTime time;

    public Lesson(String name, ZonedDateTime time) {
        this.name = name;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public ZonedDateTime getTime() {
        return time;
    }
}



