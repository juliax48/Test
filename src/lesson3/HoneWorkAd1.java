package lesson3;

import java.util.Scanner;

public class HoneWorkAd1 {
    public static void main(String[] args) {
        System.out.println("Enter number");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = 0;

        for (int i = 1; i <= number; i++) {
            result = result + i;
        }
        System.out.println(result);
    }
}
