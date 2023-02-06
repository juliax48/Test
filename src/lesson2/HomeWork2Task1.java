package lesson2;

import java.util.Scanner;

public class HomeWork2Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two-digit number");
        int a = scanner.nextInt();
        int sum = a / 10 + a % 10;

        System.out.println("Sum of two-digit number is: " + sum);
    }

}
