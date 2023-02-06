package lesson5Arrays;

import java.util.Random;
import java.util.Scanner;

public class HomeWork5Task4 {
    public static void main(String[] args) {
        System.out.println("enter number of demetoin");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];

        Random random = new Random();
        for (int rowArray = 0; rowArray < array.length; rowArray++) {
            for (int columnArray = 0; columnArray < array[rowArray].length; columnArray++) {
                if (rowArray == columnArray || rowArray + columnArray == n - 1) {
                    array[rowArray][columnArray] = 0;
                }

                if (rowArray > columnArray && rowArray + columnArray < n - 1) {
                    array[rowArray][columnArray] = random.nextInt(9) + 1;
                }

                if (rowArray > columnArray && rowArray + columnArray > n - 1) {
                    array[rowArray][columnArray] = random.nextInt(9) - 10;
                }

                if (rowArray < columnArray && rowArray + columnArray > n - 1) {
                    array[rowArray][columnArray] = random.nextInt(9) + 1;
                }

                if (rowArray < columnArray && rowArray + columnArray < n - 1) {
                    array[rowArray][columnArray] = random.nextInt(9) - 10;
                }
            }
        }
        for (int columnArray = 0; columnArray < array.length; columnArray++) {
            for (int rowArray = 0; rowArray < array[columnArray].length; rowArray++) {

                System.out.print(array[rowArray][columnArray] + "   ");
            }
            System.out.println();
        }
    }
}

