package lesson.enums;

public class DaysWeek {
    public static void main(String[] args) {
        Today today = new Today(WeekDays.FRIDAY);
        today.dayInfo();
    }

}


enum WeekDays {
    MONDAY("Good"),
    TUESDAY("Bed"),
    WEDNESDAY("fdf"),
    THURSDAY("dw3"),
    FRIDAY("de"),
    SATURDAY("ds"),
    SUNDAY("df");

    private String mood;

    private WeekDays(String mood) {
        this.mood = mood;
    }
}

class Today {
    WeekDays day;

    public Today(WeekDays day) {
        this.day = day;
    }

    void dayInfo() {
        switch (day) {
            case THURSDAY, FRIDAY, MONDAY, TUESDAY, WEDNESDAY -> {
                System.out.println("Go to work");
                break;
            }
            case SUNDAY, SATURDAY -> {
                System.out.println("Relax");
                break;
            }
        }
    }
}