package lesson2;

import java.util.Scanner;

public class HomeWork2Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three-digit number");
        int x = scanner.nextInt();

        int a = x / 100;
        int b = x / 10 % 10;
        int c = x % 10;
        int sum = a + b + c;

        System.out.println("Sum three-digit number is : " + sum);
    }

}
