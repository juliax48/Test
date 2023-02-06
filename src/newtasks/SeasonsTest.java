package newtasks;

public class SeasonsTest {
    public static void main(String[] args) {

    }

}

enum Seasons {
    WINTER(0), AUTUMN(5), SPRING(10), SUMMER(24);
    int averageTemp;

    Seasons(int averageTemp) {
        this.averageTemp = averageTemp;
    }

//    public void getInfo(Season season) {
//        switch (season) {
//            case WINTER -> {
//                System.out.println("I love " + WINTER);
//                break;
//            }
//            case AUTUMN -> {
//                System.out.println("I love " + AUTUMN);
//                break;
//            }
//
//            case SPRING -> {
//                System.out.println("I love " + SPRING);
//                break;
//            }
//            case SUMMER -> {
//                System.out.println("I love " + SUMMER);
//                break;
//            }
//            default -> {
//                System.out.println("not season");
//            }
//        }
//    }
}


class FourSeason {
    Season season;

    public FourSeason(Season season) {
        this.season = season;
    }


}