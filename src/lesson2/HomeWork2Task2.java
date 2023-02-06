package lesson2;

import java.util.Scanner;

public class HomeWork2Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first digit number");
        int q = scanner.nextInt();
        System.out.println("Enter second digit number");
        int w = scanner.nextInt();

        int operation = q % w;
        System.out.println("The result of dividing q by w with a remainder is :" + operation);
    }
}
