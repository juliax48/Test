package lesson4;

import java.util.Scanner;

public class HomeWork4Task3 {
    public static void main(String[] args) {
        System.out.println("Enter positive natural number");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please, enter positive natural, except zero");
        } else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            System.out.println("Factorial number " + n + " = " + result);
        }
    }
}
