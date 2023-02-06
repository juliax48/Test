package lesson2;

import java.util.Scanner;

public class HomeWork2Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three-digit number");
        int x = scanner.nextInt();

        int a = x % 10;
        System.out.println("The last digit of three-digit number " + x + " " + "is: " + a);
    }

}
