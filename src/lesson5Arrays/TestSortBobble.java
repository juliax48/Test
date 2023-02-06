package lesson5Arrays;

import java.util.Random;
import java.util.Scanner;

public class TestSortBobble {
    public static void main(String[] args) {
        System.out.println("Enter size number of array");

        Scanner scanner = new Scanner(System.in);
        int sizeNumber = scanner.nextInt();

        int[] array = new int[sizeNumber];

        Random random = new Random(10);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int minIndex = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                if (array[i] > minIndex){
                    minIndex = array[0];
                }
                if (array[0]+1 > array[i])

                System.out.print(array[i] + " ");
            }
        }
    }
}
