package lesson2;

import java.util.Scanner;

public class HomeWork2Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter four-digit number");
        int abcd = scanner.nextInt();
        System.out.println("abcd is: " + abcd);

        int ab = abcd / 100;
        int cd = abcd % 100;
        int result = ab + cd;
        System.out.println("The sum of the digits ab + cd of the number " + abcd + " is: " + result);
    }

}
