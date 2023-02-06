package newtasks;

public class Season {
    public static void main(String[] args) {
        getDaySeason(AllSeason.SPRING);

    }

    public static void getDaySeason (AllSeason season){
        System.out.println("In " + season + " " + season.getDay() + " days");
    }

}

enum AllSeason{
    WINTER(89), AUTUMN(92), SPRING(91), SUMMER(92);
    int day;

    AllSeason(int day) {
        this.day = day;
    }
    public int getDay() {
        return day;
    }
}