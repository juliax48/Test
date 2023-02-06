package lesson4;

import java.util.Scanner;

public class Practics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter digit 1:");
        int firstDigit = scanner.nextInt();

        System.out.println("Enter digit 2:");
        int secondDigit = scanner.nextInt();

        for (int counter1 = 0; counter1 < 3 && secondDigit != 0; counter1++) {
            System.out.println("counter1 = " + counter1);

            int res = firstDigit;
            for (int counter2 = 0; counter2 < 3 && res >= secondDigit; counter2++) {
                System.out.println("Division = " + res + " Divider = " + secondDigit);
                res = res / secondDigit;

                System.out.println("Result = " + res);
            }

            secondDigit--;
        }

        scanner.close();
    }
}
