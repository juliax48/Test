package lesson5Arrays;

import java.util.Random;
import java.util.Scanner;

public class Practics {
    public static void main(String[] args) {
        System.out.println("Enter array size");
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        if (arraySize > 10 || arraySize < 1) {
            System.out.println("Error, enter correct number form 1 to 10");
        } else {
            int[] array = new int[arraySize];

            Random random = new Random();

            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(10);
                System.out.print (array[i] + " ");
            }
        }
    }
}
