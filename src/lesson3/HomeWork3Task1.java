package lesson3;

import java.util.Scanner;

public class HomeWork3Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number");
        int a = scanner.nextInt();
        System.out.println("Enter second number");
        int b = scanner.nextInt();
        System.out.println("Enter third number");
        int c = scanner.nextInt();

        if (a < b & b < c) {
            System.out.println("Entered average number " + b);
        }
        else if (c < b & c > a) {
            System.out.println("Entered average number " + c);
        }
        else if (a > b & a < c) {
            System.out.println("Entered average number " + a);
        }
        else if(a < b & a > c) {
            System.out.println("Entered average number " + a);
        }
        else if (b < a & b > c) {
            System.out.println("Entered average number " + b);
        }
    }

}

