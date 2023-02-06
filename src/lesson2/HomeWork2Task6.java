package lesson2;

import java.util.Scanner;

public class HomeWork2Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter five-digit number");
        int x = scanner.nextInt();

        int a = x / 100 % 10;
        System.out.println("The third-digit of number " + x + " is: " + a);
    }

}
