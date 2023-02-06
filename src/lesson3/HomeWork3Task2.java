package lesson3;

import java.util.Scanner;

public class HomeWork3Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("Entered number " + number + " is even");
        } else {
            System.out.println("Entered number " + number + " is odd");
        }
    }

}

