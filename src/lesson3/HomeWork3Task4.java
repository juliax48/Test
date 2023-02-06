package lesson3;

import java.util.Scanner;

public class HomeWork3Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number");
        int numberOfSec = scanner.nextInt();

        int hours = numberOfSec / 3600;
        int minutes = (numberOfSec - (3600 * hours)) / 60;
        int sec = (numberOfSec - (3600 * hours) - (minutes * 60));

        System.out.println("Entered seconds is " + hours + " hours " + minutes + " minutes " + sec + " seconds");
    }

}
